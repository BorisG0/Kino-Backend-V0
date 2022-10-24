-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `idBooking` int NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `pricePaid` int DEFAULT NULL,
  PRIMARY KEY (`idBooking`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `MailAddress` varchar(45) NOT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `FirstName` varchar(45) DEFAULT NULL,
  `BirthDate` date DEFAULT NULL,
  `PLZ` int DEFAULT NULL,
  `HouseNumber` int DEFAULT NULL,
  `Location` varchar(45) DEFAULT NULL,
  `Street` varchar(45) DEFAULT NULL,
  `Country` varchar(2) DEFAULT 'DE',
  `MobileNumber` varchar(45) DEFAULT NULL,
  `Password` varchar(80) NOT NULL,
  PRIMARY KEY (`MailAddress`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('aberger3@posterous.com','Berger','Angelico','2005-06-28',9123,23,'Sachsen','Center Place','DE','+49 356 560 4646','MiBtueRSa'),('agrealeya@who.int','Grealey','Adrienne','1964-11-26',51149,112,'Nordrhein-Westfalen','Eastwood Hill','DE','+49 902 261 9715','LeYfgdoAfznW'),('ahalewood4@umich.edu','Halewood','Aloin','2012-03-28',80686,12,'Bayern','Glendale Road','DE','+49 674 504 2593','6qwXciqelIwr'),('cskydalld@moonfruit.com','Skydall','Chalmers','1982-11-01',33619,36,'Nordrhein-Westfalen','Steensland Point','DE','+49 263 292 2594','az4oLv'),('dsedworth6@xrea.com','Sedworth','Darn','1987-10-02',1189,1,'Sachsen','Orin Hill','DE','+49 919 425 0372','mieeQE6UH2v'),('emaccardlec@tuttocitta.it','MacCardle','Esmeralda','1950-01-03',22559,54,'Hamburg','Dunning Terrace','DE','+49 360 766 5120','kInroC7P'),('fmatantsevb@bandcamp.com','Matantsev','Flint','1978-02-24',12169,27,'Berlin','Hintze Pass','DE','+49 122 219 9202','N2ZEUxPzp'),('gchaplynj@ezinearticles.com','Chaplyn','Guendolen','1999-06-19',90411,12,'Bayern','5th Street','DE','+49 745 117 4164','iNcd2ly8S9'),('kleadley9@umn.edu','Leadley','Krysta','1964-12-28',22179,100,'Hamburg','Evergreen Circle','DE','+49 135 196 3232','Ls2txI'),('lattlee1@sphinn.com','Attlee','Lyle','1947-04-28',40591,35,'Nordrhein-Westfalen','Sycamore Alley','DE','+49 824 261 2230','mNDtfnNnXL'),('ldunbabin2@digg.com','Dunbabin','Lolita','1980-04-30',9116,86,'Sachsen','Monterey Place','DE','+49 390 982 5080','fBu73M'),('llighten7@adobe.com','Lighten','Lorne','1999-04-12',65191,8,'Hessen','Hintze Hill','DE','+49 152 508 0397','SWXAIDj6Hp'),('lsemperg@issuu.com','Semper','Lazarus','1994-07-05',4317,8,'Sachsen','Londonderry Circle','DE','+49 557 556 1685','SBp0pvCguNIe'),('mlarrat8@shutterfly.com','Larrat','Mallorie','2000-02-16',14109,69,'Berlin','Drewry Parkway','DE','+49 182 399 1477','Zk2KJmx4M'),('pheadh@google.es','Head','Peadar','2006-06-14',13409,6921,'Berlin','Steensland Park','DE','+49 708 198 8187','VPUZeka'),('psavourye@rambler.ru','Savoury','Patience','1990-04-02',47239,42,'Nordrhein-Westfalen','Scoville Plaza','DE','+49 336 703 7610','S92TmyY20SG'),('tbradnamf@answers.com','Bradnam','Tilda','1995-09-03',22179,4,'Hamburg','Spohn Junction','DE','+49 520 281 2721','2E4GC3wg9'),('tburgwyn5@whitehouse.gov','Burgwyn','Tresa','2001-05-12',44369,15,'Nordrhein-Westfalen','Hanover Point','DE','+49 197 756 5887','K4zCOE5TU'),('wbieveri@slate.com','Biever','Wat','2000-08-17',20359,9,'Hamburg','Ronald Regan Park','DE','+49 718 718 1720','m4DCsSy2i');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `MailAddress` varchar(45) NOT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `FirstName` varchar(45) DEFAULT NULL,
  `Role` varchar(45) DEFAULT NULL,
  `Password` varchar(80) NOT NULL,
  PRIMARY KEY (`MailAddress`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('bgreenalf6@oakley.com','Luxen','Edmée','TicketVerkäufer','CawJOR'),('etebbit5@google.com.au','Merritt','Marie-thérèse','Manager','0O5fYu'),('jbraddick8@php.net','Laydon','Maëline','TicketVerkäufer','aJumewz075BX'),('jburgher3@state.gov','Denniston','Loïs','Kontrolleur','fEBNPoX'),('jseeks1@mediafire.com','Pheby','Cunégonde','Kontrolleur','1hgsK13B'),('mdeery0@microsoft.com','Gilmour','Mélia','Manager','8XXL2PZo'),('mkesterton7@ftc.gov','Fosh','Lorène','Manager','Djxl2gru'),('ncalven9@ask.com','Gibbe','Ráo','Manager','At1FXj'),('osilk4@nationalgeographic.com','Byrcher','Gaëlle','Manager','1aGSxKVP'),('regalton2@privacy.gov.au','Dwane','Agnès','SnackVerkäufer','9WIrhk9a52u');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `idEvent` int NOT NULL AUTO_INCREMENT,
  `Date` date DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `movie_idMovie` int DEFAULT NULL,
  `room_idRoom` int DEFAULT NULL,
  PRIMARY KEY (`idEvent`),
  KEY `fk_event_movie_idx` (`movie_idMovie`),
  KEY `fk_event_room1_idx` (`room_idRoom`),
  CONSTRAINT `fk_event_movie` FOREIGN KEY (`movie_idMovie`) REFERENCES `movie` (`idMovie`),
  CONSTRAINT `fk_event_room1` FOREIGN KEY (`room_idRoom`) REFERENCES `room` (`idRoom`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'2022-07-17','14:00:00',1,1),(2,'2022-11-07','18:00:00',1,3),(3,'2022-01-24','20:30:00',2,2),(4,'2022-06-18','19:30:00',1,2),(5,'2021-12-06','18:30:00',2,5),(6,'2022-07-17','14:00:00',2,3),(7,'2022-11-07','18:00:00',10,5),(8,'2022-01-25','20:30:00',2,4),(9,'2022-06-18','22:45:00',4,2),(10,'2021-12-06','18:30:00',2,4),(11,'2022-07-17','14:00:00',6,4);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `idMovie` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(45) DEFAULT NULL,
  `Duration` int DEFAULT NULL,
  `AgeRestriction` int DEFAULT NULL,
  `imageName` varchar(45) DEFAULT NULL,
  `Description` longtext,
  `Genre` varchar(100) DEFAULT NULL,
  `StartDate` date DEFAULT NULL,
  `movieStudio` varchar(100) DEFAULT NULL,
  `regie` varchar(100) DEFAULT NULL,
  `cast` varchar(100) DEFAULT NULL,
  `trailerLink` varchar(100) DEFAULT NULL,
  `active` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`idMovie`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Minions: Auf der Suche nach dem Mini-Boss',88,6,'img0.png','Als Fan der Superschurkengruppe Vicious 6 heckt Gru einen Plan aus, um böse genug zu werden, um sich ihnen anzuschließen, und wird dabei von seinen Anhängern, den Minions, unterstützt.',' Animation, Abenteuer, Komödie, Fantasy ','2022-06-30','Universal Pictures Studio & Illumination Entertainment','Kyle Balda','Steve Carell, Pierre Coffin, Alan Arkin','\"https://www.youtube.com/embed/6DxjJzmYsXo\"',1),(2,'Batman',176,12,'img1.png','Zwei Jahre lang jagte Bruce Wayne als Batman Verbrecher auf der Straße und geriet immer tiefer in die Schattenwelt Gothams. Im korrupten Netzwerk der Beamten und VIPs konnte er nur auf wenige Vertraute zählen, daher verkörperte er bald als Einziger die Rache der Bürger. Als ein Killer es mit einer Vielzahl an sadistischen Machenschaften auf die Elite Gothams abgesehen hat, führt eine Spur aus mysteriösen Hinweisen den weltbesten Detective in die Unterwelt, wo er auf Selina Kyle a.k.a. Catwoman, Oswald Cobblepot a.k.a. der Pinguin, Carmine Falcone und Edward Nashton a.k.a. der Riddler stößt. Mit der Zeit wird das wahre Ausmaß des verbrecherischen Plans klar und die Beweise deuten immer mehr auf einen Kriminellen im näheren Umfeld Batmans hin. Nun muss Batman neue Kontakte knüpfen, den Verbrecher entlarven und den Machtmissbrauch und die Korruption, die Gotham schon lange im Griff haben, gnadenlos niederschlagen.','Krimi, Mystery, Thriller','2022-03-03','Warner Brothers Studio','Matt Reeves','Robert Pattinson, Zoë Kravitz, Jeffrey Wright','\"https://www.youtube.com/embed/mqqft2x_Aa4\"',1),(3,'Spiderman: No Way Home',135,12,'img2.png','Peter Parker ist demaskiert und kann sein normales Leben nicht mehr von den hohen Einsätzen als Superheld trennen. Als er Doctor Strange um Hilfe bittet, wird die Lage noch gefährlicher und er muss entdecken, was es wirklich bedeutet, Spider-Man zu sein.','Action, Abenteuer, Science Fiction','2021-12-16','Marvel Entertainment','Kevin Feige, Amy Pascal','Tom Holland, Tobey Marguire, Andrew Garfield, Zendaya','\"https://www.youtube.com/embed/JfVOs4VSpmA\"',1),(4,'Jeeper Creepers',88,16,'img3.png','Als Laine gezwungen wird, mit ihrem Freund zu einem Horrorfestival zu reisen, beginnt sie, verstörende Visionen zu haben, die mit der urbanen Legende des Kriechers zusammenhängen. Als das Festival ankommt und die blutgetränkte Unterhaltung sich zu einem Rausch steigert, wird sie zum Mittelpunkt des Geschehens, während etwas Unheimliches herbeigerufen wurde.','Horror, Thriller, Mystery','2022-09-15','Black Hangar Studios','Timo Vuorensola','Gary Graham, Dee Wallace, Timo Vuorensola','\"https://www.youtube.com/embed/6D0yFgZnmYM\"',1),(5,'Saw',103,18,'img4.png','Ohne die leiseste Ahnung, wie sie in diesen Albtraum geraten sind, erwachen zwei Männer angekettet an gegenüberliegenden Wänden in einem Kellerverlies. Hinterlassen hat ihr Entführer lediglich eine ausgeblutete Leiche und ein Tonband, auf dem er den Gefangenen einen Ausweg anbietet. Wenn sie beweisen, dass sie bereit sind, wirklich alles für ihr überleben zu tun, haben sie die Chance, aus ihrem Verlies zu entkommen. Doch die Spielregeln des Sadisten sind gnadenlos. Wer die Freiheit will, muss sich selbst verstümmeln oder zum Mörder werden...','Horror, Mystery, Krimi','2005-02-03','Universal Pictures Studio & Illumination Entertainment','Kyle Balda','Steve Carell, Pierre Coffin, Alan Arkin','\"https://www.youtube.com/embed/gzy6ORqE9IY\"',1),(6,'Bullet Train',127,16,'img5.png','Bullet Train: So wird der Shinkansen-Zug auf der Strecke Tokio - Kyoto auch genannt, da er mit unglaublichen 320 Kilometern pro Stunde und ohne Zwischenstopp zwischen den beiden Städten hin und her rast. Aussteigen unmöglich. An Bord des Shinkansen ist auch Ladybug, ein vom Pech verfolgter Auftragskiller, der im Hochgeschwindigkeitszug sein nächstes Opfer erledigen soll. Nach einigen Rückschlägen für Ladybug muss dieses Mal einfach alles gut gehen. Doch auch dieser Auftrag wird nicht einfach, denn mit Tangerine, Prince, Hornet, Lemon und Kimura sind noch fünf weitere Auftragskiller an Bord. Erstaunlicherweise haben es nicht alle auf die gleiche Zielperson abgesehen - und doch scheinen ihre Aufträge miteinander verbunden. Natürlich kommen sich die eiskalten Auftragsmörder in die Quere und im Hochgeschwindigkeitszug entbrennt ein chaotischer Kampf auf Leben und Tod.','Action, Komödie, Thriller','2022-08-04','87North','David Leitch','Brad Pitt, Joey King, Aaron Taylor-Johnson','\"https://www.youtube.com/embed/0IOsk2Vlc4o\"',1),(7,'Thor: Love and Thunder',119,12,'img6.png','Nachdem sein Ruhestand von Gorr dem Götterschlächter, einem galaktischen Killer, der die Auslöschung der Götter anstrebt, unterbrochen wird, bittet Thor Odinson um die Hilfe von König Walküre, Korg und seiner Ex-Freundin Jane Foster, die nun als Mighty Thor das Mjolnir schwingt. Gemeinsam begeben sie sich auf ein erschütterndes kosmisches Abenteuer, um das Geheimnis der Rache des Götterschlächters zu lüften und ihn aufzuhalten, bevor es zu spät ist.','Fantasy, Action, Komödie','2022-07-08','Marvel Entertainment','Taika Waititi','Chris Hemsworth, Natalie Portman, Christian Bale','\"https://www.youtube.com/embed/Go8nTmfrQd8\"',1),(8,'Avatar - The Way of Water',161,12,'img7.png','Jake Sully lebt mit seiner neu gegründeten Familie auf dem Planeten Pandora, als eine vertraute Bedrohung zurückkehrt, die Jake, Neytiri und den Rest der Na\'vi-Armee mobilisiert, um ihren Planeten zu schützen.','Abenteuer','2022-07-17','20th Century Studios','James Cameron','Sigourney Weaver, Zoe Saldana, Sam Worthington','\"https://www.youtube.com/embed/NZrX_ES93JA\"',1),(9,'Top Gun Maverick',131,12,'img8.png','Aufgrund seiner Probleme mit Autoritäten hat es Flieger-Ass Maverick nie geschafft, die ganz große Karriere in der Navy zu machen. Anstatt Orden konnte er so vielmehr disziplinarische Verfahren sammeln. Nachdem er erneut über das Ziel hinausgeschossen ist, wird er kurzerhand zu seiner alten Elite-Flugschule Top Gun versetzt. Dort soll er die jungen Flieger, unter denen sich auch Rooster, der Sohn seines verstorbenen besten Freundes Goose befindet, auf eine Mission vorbereiten, die eigentlich unmöglich zu bewerkstelligen ist: Das schwer geschützte Nuklearprogramm eines fremden Landes muss zerstört werden. Weniger als drei Wochen bleiben zur Vorbereitung. Maverick hat nun alle Hände voll damit zu tun, die besten Absolventen der vergangenen Jahre zu einem Team zu formen, damit der Einsatz nicht zum Selbstmordkommando verkommt.','Action, Drama','2022-05-26','Paramount Pictures','Joseph Kosinski','Tom Cruise, Jennifer Connelly, Miles Teller','\"https://www.youtube.com/embed/3hO--XhlsfU\"',1),(10,'Avengers: Endgame',191,12,'img9.png','Thanos hat also tatsächlich Wort gehalten, seinen Plan in die Tat umgesetzt und die Hälfte allen Lebens im Universum ausgelöscht. Die Avengers? Machtlos. Iron Man und Nebula sitzen auf dem Planeten Titan fest, während auf der Erde absolutes Chaos herrscht. Doch dann finden Captain America und die anderen überlebenden Helden auf der Erde heraus, dass Nick Fury vor den verheerenden Ereignissen gerade noch ein Notsignal absetzen konnte, um Verstärkung auf den Plan zu rufen. Die Superhelden-Gemeinschaft bekommt mit Captain Marvel kurzerhand tatkräftige Unterstützung im Kampf gegen ihren vermeintlich übermächtigen Widersacher. Und dann ist da auch noch Ant-Man, der wie aus dem Nichts auftaucht und sich der Truppe erneut anschließt, um die ganze Sache womöglich doch noch zu einem guten Ende zu bringen …','Abenteuer, Science Fiction, Action','2019-04-24','Marvel Entertainment','Anthony Russo, Joe Russo','Robert Downey Jr., Chris Evans, Mark Rufallo','\"https://www.youtube.com/embed/TcMBFSGVi1c\"',1);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `idRoom` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idRoom`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1),(2),(3),(4),(5);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat` (
  `idSeat` int NOT NULL AUTO_INCREMENT,
  `Line` varchar(45) DEFAULT NULL,
  `NumberInLine` int DEFAULT NULL,
  `room_idRoom` int NOT NULL,
  PRIMARY KEY (`idSeat`),
  KEY `fk_seat_room1_idx` (`room_idRoom`),
  CONSTRAINT `fk_seat_room1` FOREIGN KEY (`room_idRoom`) REFERENCES `room` (`idRoom`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1,'A',1,1),(2,'A',2,1),(3,'A',3,1),(4,'A',4,1),(5,'A',5,1),(6,'B',1,1),(7,'B',2,1),(8,'B',3,1),(9,'B',4,1),(10,'B',5,1),(11,'C',1,1),(12,'C',2,1),(13,'C',3,1),(14,'C',4,1),(15,'C',5,1),(16,'A',1,2),(17,'A',2,2),(18,'A',3,2),(19,'A',4,2),(20,'A',5,2),(21,'B',1,2),(22,'B',2,2),(23,'B',3,2),(24,'B',4,2),(25,'B',5,2),(26,'C',1,2),(27,'C',2,2),(28,'C',3,2),(29,'C',4,2),(30,'C',5,2),(31,'A',1,3),(32,'A',2,3),(33,'A',3,3),(34,'A',4,3),(35,'A',5,3),(36,'B',1,3),(37,'B',2,3),(38,'B',3,3),(39,'B',4,3),(40,'B',5,3),(41,'C',1,3),(42,'C',2,3),(43,'C',3,3),(44,'C',4,3),(45,'C',5,3),(46,'A',1,4),(47,'A',2,4),(48,'A',3,4),(49,'A',4,4),(50,'A',5,4),(51,'B',1,4),(52,'B',2,4),(53,'B',3,4),(54,'B',4,4),(55,'B',5,4),(56,'C',1,4),(57,'C',2,4),(58,'C',3,4),(59,'C',4,4),(60,'C',5,4),(61,'A',1,5),(62,'A',2,5),(63,'A',3,5),(64,'A',4,5),(65,'A',5,5),(66,'B',1,5),(67,'B',2,5),(68,'B',3,5),(69,'B',4,5),(70,'B',5,5),(71,'C',1,5),(72,'C',2,5),(73,'C',3,5),(74,'C',4,5),(75,'C',5,5);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seats_in_event`
--

DROP TABLE IF EXISTS `seats_in_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seats_in_event` (
  `event_idEvent` int NOT NULL,
  `seat_idSeat` int NOT NULL,
  `Status` smallint DEFAULT NULL,
  PRIMARY KEY (`event_idEvent`,`seat_idSeat`),
  KEY `fk_seats_in_event_seat1_idx` (`seat_idSeat`),
  KEY `fk_seats_in_event_event1_idx` (`event_idEvent`),
  CONSTRAINT `fk_seats_in_event_event1` FOREIGN KEY (`event_idEvent`) REFERENCES `event` (`idEvent`),
  CONSTRAINT `fk_seats_in_event_seat1` FOREIGN KEY (`seat_idSeat`) REFERENCES `seat` (`idSeat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seats_in_event`
--

LOCK TABLES `seats_in_event` WRITE;
/*!40000 ALTER TABLE `seats_in_event` DISABLE KEYS */;
INSERT INTO `seats_in_event` VALUES (1,1,0),(1,2,0),(1,3,0),(1,4,0),(1,5,0),(1,6,1),(1,7,0),(1,8,0),(1,9,0),(1,10,2),(1,11,0),(1,12,1),(1,13,0),(1,14,2),(1,15,0),(2,1,0),(2,2,2),(2,3,0),(2,4,0),(2,5,2),(2,6,1),(2,7,1),(2,8,0),(2,9,0),(2,10,1),(2,11,1),(2,12,1),(2,13,0),(2,14,0),(2,15,1),(3,1,1),(3,2,1),(3,3,0),(3,4,1),(3,5,1),(3,6,1),(3,7,0),(3,8,1),(3,9,0),(3,10,2),(3,11,1),(3,12,1),(3,13,1),(3,14,1),(3,15,2),(4,1,1),(4,2,0),(4,3,1),(4,4,0),(4,5,1),(4,6,0),(4,7,0),(4,8,1),(4,9,1),(4,10,1),(4,11,0),(4,12,1),(4,13,0),(4,14,0),(4,15,2),(5,1,0),(5,2,0),(5,3,0),(5,4,0),(5,5,0),(5,6,0),(5,7,0),(5,8,0),(5,9,0),(5,10,0),(5,11,0),(5,12,0),(5,13,0),(5,14,0),(5,15,0);
/*!40000 ALTER TABLE `seats_in_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `idTicket` int NOT NULL,
  `idSeat` int DEFAULT NULL,
  `idEvent` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  `defaultPrice` int DEFAULT NULL,
  `idBooking` int DEFAULT NULL,
  PRIMARY KEY (`idTicket`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,16,3,0,12,NULL),(2,17,3,0,12,NULL),(3,18,3,0,12,NULL),(4,19,3,1,12,NULL),(5,20,3,1,12,NULL),(6,21,3,0,12,NULL),(7,22,3,0,12,NULL),(8,23,3,0,12,NULL),(9,24,3,0,12,NULL),(10,25,3,0,12,NULL),(11,26,3,0,12,NULL),(12,27,3,0,12,NULL),(13,28,3,0,12,NULL),(14,29,3,0,12,NULL),(15,30,3,0,12,NULL);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-24 10:53:35
