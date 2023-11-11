-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: kochbuch
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `benutzer`
--

DROP TABLE IF EXISTS `benutzer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `benutzer` (
  `BenutzerID` int NOT NULL AUTO_INCREMENT,
  `Vorname` varchar(50) NOT NULL,
  `Nachname` varchar(50) NOT NULL,
  `Benutzername` varchar(50) NOT NULL,
  `Passwort` varchar(255) NOT NULL,
  `Registrierungsdatum` date DEFAULT NULL,
  PRIMARY KEY (`BenutzerID`),
  UNIQUE KEY `Benutzername` (`Benutzername`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benutzer`
--

LOCK TABLES `benutzer` WRITE;
/*!40000 ALTER TABLE `benutzer` DISABLE KEYS */;
INSERT INTO `benutzer` VALUES (1,'wessam','fahed','wfahed','12345678','2023-11-02'),(2,'Kilian','Ketelhohn','808ket','dildo',NULL),(3,'55e','2zuzw','iohiuh','12345',NULL),(4,'111','1111','1111','222',NULL),(5,'11111','1111','11111','22',NULL),(6,'aaa','aaa','aaa','1111',NULL),(7,'','','','',NULL),(9,'1111','111','11','111',NULL);
/*!40000 ALTER TABLE `benutzer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favoriten`
--

DROP TABLE IF EXISTS `favoriten`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favoriten` (
  `FavoritenID` int NOT NULL AUTO_INCREMENT,
  `BenutzerID` int DEFAULT NULL,
  `RezeptID` int NOT NULL,
  `HinzugefuegtAm` date DEFAULT NULL,
  PRIMARY KEY (`FavoritenID`),
  KEY `RezeptID` (`RezeptID`),
  KEY `BenutzerID` (`BenutzerID`),
  CONSTRAINT `favoriten_ibfk_1` FOREIGN KEY (`RezeptID`) REFERENCES `rezepte` (`RezeptID`),
  CONSTRAINT `favoriten_ibfk_2` FOREIGN KEY (`BenutzerID`) REFERENCES `benutzer` (`BenutzerID`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favoriten`
--

LOCK TABLES `favoriten` WRITE;
/*!40000 ALTER TABLE `favoriten` DISABLE KEYS */;
INSERT INTO `favoriten` VALUES (57,NULL,15,NULL),(61,NULL,28,NULL),(62,NULL,29,NULL),(64,NULL,12,NULL),(67,NULL,8,NULL),(81,NULL,11,NULL);
/*!40000 ALTER TABLE `favoriten` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kategorien`
--

DROP TABLE IF EXISTS `kategorien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kategorien` (
  `KategorieID` int NOT NULL AUTO_INCREMENT,
  `Kategoriename` varchar(50) NOT NULL,
  PRIMARY KEY (`KategorieID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kategorien`
--

LOCK TABLES `kategorien` WRITE;
/*!40000 ALTER TABLE `kategorien` DISABLE KEYS */;
INSERT INTO `kategorien` VALUES (1,'Persisch'),(2,'Vorspeise'),(3,'Nachspeise'),(4,'Seafood'),(5,'Fleisch'),(6,'Vegan'),(7,'Persisch'),(8,'Vorspeise'),(9,'Nachspeise'),(10,'Seafood'),(11,'Fleisch'),(12,'Vegan');
/*!40000 ALTER TABLE `kategorien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rezepte`
--

DROP TABLE IF EXISTS `rezepte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rezepte` (
  `RezeptID` int NOT NULL AUTO_INCREMENT,
  `Rezeptname` varchar(255) NOT NULL,
  `Autor` varchar(100) DEFAULT NULL,
  `Zubereitungszeit` int DEFAULT NULL,
  `Kochzeit` int DEFAULT NULL,
  `Portionen` int DEFAULT NULL,
  `Kategorie` varchar(50) DEFAULT NULL,
  `Zubereitungstext` text,
  `Notizen` text,
  `Foto` text,
  PRIMARY KEY (`RezeptID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rezepte`
--

LOCK TABLES `rezepte` WRITE;
/*!40000 ALTER TABLE `rezepte` DISABLE KEYS */;
INSERT INTO `rezepte` VALUES (4,'Khoresht - e - ghormeh sabzi','Hossein Khan',40,60,4,'Persisch','1. Lammfleisch und Zwiebeln anbraten. 2. Bohnen und getrocknete Limonen hinzufügen. 3. Kräuter und Gewürze unterrühren. 4. 60 Minuten köcheln lassen.','Ein traditionelles persisches Gericht.','C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/RezeptImages/Khoreshtghormehsabzi.jpg'),(5,'Gebratene Garnelen mit Knoblauchbutter','Marie Fischer',15,10,2,'Seafood','1. Garnelen schälen und entdarmen. 2. Knoblauchbutter zubereiten. 3. Garnelen in der Knoblauchbutter braten. 4. Mit Zitrone und Petersilie servieren.','Ein einfaches und leckeres Seafood-Gericht.','C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/Timo Essen Bilder/IMG-20231031-WA0023.jpg'),(6,'Paella mit Meeresfrüchten','Juan Rodriguez',45,30,4,'Seafood','1. Reis kochen. 2. Meeresfrüchte in einer Pfanne anbraten. 3. Reis, Gemüse und Gewürze hinzufügen. 4. Alles zusammen köcheln lassen. 5. Mit Zitronenspalten garnieren.','Ein klassisches spanisches Seafood-Gericht.','C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/Timo Essen Bilder/IMG-20231031-WA0023.jpg'),(7,'Gegrillter Lachs mit Dillsoße','Emily Parker',20,15,2,'Seafood','1. Lachsfilet mit Dillmarinade bestreichen. 2. Auf dem Grill garen. 3. Dillsoße zubereiten. 4. Mit Lachs servieren.','Ein gesundes Seafood-Gericht mit köstlicher Soße.','C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/Timo Essen Bilder/IMG-20231031-WA0018.jpg'),(8,'Bierhähnchen','Andreas Weber',20,60,4,'Fleisch','1. Hähnchen waschen und trocknen. 2. Mit Gewürzen einreiben. 3. Bierdose in das Hähnchen stecken. 4. Auf dem Grill oder im Ofen garen. 5. Saftiges Hähnchen genießen.','Ein herzhaftes Grillgericht mit knuspriger Haut.','C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/Timo Essen Bilder/IMG-20231031-WA0011.jpg'),(9,'Schweinemedaillons in Senfsoße','Katrin Schulz',15,30,2,'Fleisch','1. Schweinemedaillons würzen und anbraten. 2. Senfsoße zubereiten und über die Medaillons gießen. 3. Im Ofen garen. 4. Mit Beilage servieren.','Ein zartes Schweinegericht mit würziger Senfsoße.','C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/Timo Essen Bilder/IMG-20231031-WA0067.jpg'),(10,'Rehkeule mit Preiselbeersoße','Markus Fischer',30,90,4,'Fleisch','1. Rehkeule würzen und anbraten. 2. Im Ofen schmoren. 3. Preiselbeersoße zubereiten und servieren. 4. Mit Beilagen nach Wahl genießen.','Ein festliches Wildgericht mit aromatischer Soße.','C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/Timo Essen Bilder/20231031-WA0068.jpg'),(11,'Tiramisu','Anna Müller',30,0,6,'Nachspeise','1. Mascarpone, Eigelb und Zucker miteinander vermengen. 2. Löffelbiskuits in Kaffee tränken und in eine Form legen. 3. Mascarpone-Mischung darüber schichten. 4. Mit Kakao bestäuben. 5. Im Kühlschrank kaltstellen.','Ein klassisches italienisches Dessert.','C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/RezeptImages/Tiramisu.jpg'),(12,'Schokoladenfondue','Marko Schmidt',15,10,4,'Nachspeise','1. Schokolade schmelzen. 2. Früchte in Stücke schneiden. 3. Schokolade zum Dippen verwenden. 4. Genießen!','Ein geselliges Dessert zum Dippen.','C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/RezeptImages/Schokofondue.png'),(13,'Vanilleeis mit heißen Himbeeren','Sophie Wagner',10,5,2,'Nachspeise','1. Vanilleeis in Schalen verteilen. 2. Himbeeren erhitzen und über das Eis gießen. 3. Sofort servieren.','Ein einfaches und köstliches Dessert.','C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/RezeptImages/VanilleeismitheißenHimbeeren.jpg'),(14,'Mirza Ghasemi','Parisa Amini',30,45,2,'Persisch','1. Auberginen rösten und zerstampfen. 2. Tomaten, Knoblauch und Gewürze hinzufügen. 3. 45 Minuten köcheln lassen. 4. Mit frischen Kräutern garnieren.','Ein köstliches persisches Gericht.','C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/RezeptImages/MirzaGhasemi.jpg'),(15,'Chelou Kabab Kubideh - Gegrillter Hackfleischspieß','Ali Mohammadi',30,20,4,'Persisch','1. Hackfleisch, Zwiebeln und Gewürze vermengen. 2. Fleisch auf Spieße stecken. 3. Grillen oder braten. 4. Mit Minze und Zwiebeln servieren.','Ein klassisches persisches Grillgericht.','C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/RezeptImages/ChelouKababHackfleischspieß.jpg'),(16,'Veganes Chili sin Carne','John Doe',20,30,4,'Vegan','1. Zwiebeln und Knoblauch hacken. 2. Gemüse in Würfel schneiden. 3. In einer Pfanne anbraten. 4. Gewürze hinzufügen. 5. Tomaten und Bohnen dazugeben. 6. 30 Minuten köcheln lassen.','Gesund und lecker.','C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/RezeptImages/VeganesChilisinCarne.jpg'),(17,'Vegane Gemüsepfanne','Jane Smith',15,20,2,'Vegan','1. Verschiedenes Gemüse schneiden. 2. In Pfanne braten. 3. Soße zubereiten. 4. Gemüse mit Soße mischen. 5. Servieren.','Schnell und einfach.','C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/RezeptImages/VeganeGemüsepfanne.jpg'),(28,'Persisch',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'file:/C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/RezeptImages/firstGheyme.jpg'),(29,'Persisch',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'file:/C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/RezeptImages/firstGhormeSabzi.jpg'),(30,'Persisch',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'file:/C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/RezeptImages/firstKebab.jpg'),(31,'Persisch',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'file:/C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/RezeptImages/secondGheyme.jpg'),(32,'Persisch',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'file:/C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/RezeptImages/secondGhormeSabzi.jpg'),(33,'Persisch',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'file:/C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/RezeptImages/secondKebab.jpg'),(34,'Persisch',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'file:/C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/RezeptImages/thirdGheyme.jpg'),(35,'Persisch',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'file:/C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/RezeptImages/thirdGhormeSabzi.jpg'),(36,'bbb',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Test');
/*!40000 ALTER TABLE `rezepte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rezeptekategorien`
--

DROP TABLE IF EXISTS `rezeptekategorien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rezeptekategorien` (
  `RezeptKategorieID` int NOT NULL AUTO_INCREMENT,
  `RezeptID` int DEFAULT NULL,
  `KategorieID` int DEFAULT NULL,
  PRIMARY KEY (`RezeptKategorieID`),
  KEY `RezeptID` (`RezeptID`),
  KEY `KategorieID` (`KategorieID`),
  CONSTRAINT `rezeptekategorien_ibfk_1` FOREIGN KEY (`RezeptID`) REFERENCES `rezepte` (`RezeptID`),
  CONSTRAINT `rezeptekategorien_ibfk_2` FOREIGN KEY (`KategorieID`) REFERENCES `kategorien` (`KategorieID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rezeptekategorien`
--

LOCK TABLES `rezeptekategorien` WRITE;
/*!40000 ALTER TABLE `rezeptekategorien` DISABLE KEYS */;
INSERT INTO `rezeptekategorien` VALUES (1,4,1),(2,14,1),(3,15,1),(4,11,3),(5,12,3),(6,13,3),(7,5,4),(8,6,4),(9,7,4),(10,8,5),(11,9,5),(12,10,5),(13,16,6),(14,17,6);
/*!40000 ALTER TABLE `rezeptekategorien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rezeptezutaten`
--

DROP TABLE IF EXISTS `rezeptezutaten`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rezeptezutaten` (
  `RezeptZutatenID` int NOT NULL AUTO_INCREMENT,
  `RezeptID` int DEFAULT NULL,
  `ZutatenID` int DEFAULT NULL,
  PRIMARY KEY (`RezeptZutatenID`),
  KEY `RezeptID` (`RezeptID`),
  KEY `ZutatenID` (`ZutatenID`),
  CONSTRAINT `rezeptezutaten_ibfk_1` FOREIGN KEY (`RezeptID`) REFERENCES `rezepte` (`RezeptID`),
  CONSTRAINT `rezeptezutaten_ibfk_2` FOREIGN KEY (`ZutatenID`) REFERENCES `zutaten` (`ZutatenID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rezeptezutaten`
--

LOCK TABLES `rezeptezutaten` WRITE;
/*!40000 ALTER TABLE `rezeptezutaten` DISABLE KEYS */;
/*!40000 ALTER TABLE `rezeptezutaten` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zutaten`
--

DROP TABLE IF EXISTS `zutaten`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zutaten` (
  `ZutatenID` int NOT NULL AUTO_INCREMENT,
  `Zutatenname` varchar(255) NOT NULL,
  `Menge` decimal(10,2) DEFAULT NULL,
  `Einheit` varchar(20) DEFAULT NULL,
  `Kategorie` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ZutatenID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zutaten`
--

LOCK TABLES `zutaten` WRITE;
/*!40000 ALTER TABLE `zutaten` DISABLE KEYS */;
/*!40000 ALTER TABLE `zutaten` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-11 15:50:04
