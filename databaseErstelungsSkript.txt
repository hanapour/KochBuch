--WFahed
CREATE database KochBuch;
Use KochBuch;
CREATE TABLE Rezepte (
    RezeptID INT AUTO_INCREMENT PRIMARY KEY,
    Rezeptname VARCHAR(255) NOT NULL,
    Autor VARCHAR(100),
    Zubereitungszeit INT,
    Kochzeit INT,
    Portionen INT,
    Kategorie VARCHAR(50),
    Zubereitungstext TEXT,
    Notizen TEXT,
	Foto NVARCHAR(500)
);
-- Tabelle für Zutaten
CREATE TABLE Zutaten (
    ZutatenID INT AUTO_INCREMENT PRIMARY KEY,
    Zutatenname VARCHAR(255) NOT NULL,
    Menge DECIMAL(10,2),
    Einheit VARCHAR(20),
    Kategorie VARCHAR(50)
);
-- Verknüpfungstabelle zwischen Rezepte und Zutaten
CREATE TABLE RezepteZutaten (
    RezeptZutatenID INT AUTO_INCREMENT PRIMARY KEY,
    RezeptID INT,
    ZutatenID INT,
    FOREIGN KEY (RezeptID) REFERENCES Rezepte(RezeptID),
    FOREIGN KEY (ZutatenID) REFERENCES Zutaten(ZutatenID)
);


-- Tabelle für Benutzer
CREATE TABLE Benutzer (
    BenutzerID INT AUTO_INCREMENT PRIMARY KEY,
    Vorname VARCHAR(50) NOT NULL,
    Nachname VARCHAR(50) NOT NULL,
    Benutzername VARCHAR(50) NOT NULL UNIQUE,
    Passwort VARCHAR(255) NOT NULL,
    Email VARCHAR(100) NOT NULL UNIQUE,
    Registrierungsdatum DATE
);
-- Tabelle für Favoriten
CREATE TABLE Favoriten (
    FavoritenID INT AUTO_INCREMENT PRIMARY KEY,
    BenutzerID INT null, 
    RezeptID INT,
    HinzugefuegtAm DATE,
    FOREIGN KEY (RezeptID) REFERENCES Rezepte(RezeptID),
    FOREIGN KEY (BenutzerID) REFERENCES Benutzer(BenutzerID) 
);

-- Tabelle für Kategorien
CREATE TABLE Kategorien (
    KategorieID INT AUTO_INCREMENT PRIMARY KEY,
    Kategoriename VARCHAR(50) NOT NULL
);

-- Verknüpfungstabelle zwischen Rezepte und Kategorien
CREATE TABLE RezepteKategorien (
    RezeptKategorieID INT AUTO_INCREMENT PRIMARY KEY,
    RezeptID INT,
    KategorieID INT,
    FOREIGN KEY (RezeptID) REFERENCES Rezepte(RezeptID),
    FOREIGN KEY (KategorieID) REFERENCES Kategorien(KategorieID)
	
);


