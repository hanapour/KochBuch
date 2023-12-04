Bitte stellen Sie sicher, dass Sie in der Klasse 'DatabaseConnection' die Informationen für die Datenbankverbindung anpassen.
Falls keine Verbindung besteht, überprüfen Sie bitte, ob der MySQL Connector für Maven vorhanden ist. 
Falls nicht, können Sie die folgende Zeile in die 'pom.xml' Datei einfügen:
<!-- https://mvnrepository.com/artifact/com.mysql/mysql-connector-j -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.2.0</version>
</dependency>
