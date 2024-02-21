-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: db_yu_aggregate
-- ------------------------------------------------------
-- Server version	10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_owner`
--

DROP TABLE IF EXISTS `tbl_owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_owner` (
  `owner_id` int(8) NOT NULL,
  `owner_name` varchar(20) DEFAULT NULL,
  `owner_age` int(2) NOT NULL,
  `owner_gender` varchar(6) DEFAULT NULL,
  `owner_address` varchar(30) NOT NULL,
  `owner_civilStatus` varchar(30) NOT NULL,
  PRIMARY KEY (`owner_id`),
  KEY `Gender_ID` (`owner_gender`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_owner`
--

LOCK TABLES `tbl_owner` WRITE;
/*!40000 ALTER TABLE `tbl_owner` DISABLE KEYS */;
INSERT INTO `tbl_owner` VALUES (1,'Anna',15,'Male','Puan','single'),(2,'Kyle',21,'Female','Matina','single'),(3,'John',22,'Male','Matina','Deceased'),(4,'Juan',15,'Female','Matina','married'),(5,'Fatima',22,'Female','Matina','married'),(6,'Celeste',26,'Male','Bankerohan','Married'),(7,'Francis',15,'Male','Obrero','Deceased'),(8,'Jave',34,'Male','Bajada','Married'),(9,'Jeffrey',57,'Female','bankerohan','Married'),(10,'Vince',13,'Female','Obrero','Divorce'),(11,'Eugene',16,'Male','Buhangin','single'),(12,'Rona',33,'Female','Toril','Divorce'),(13,'Thelmo',20,'Male','Toril','Widowed'),(14,'Connie',12,'Female','Bankerohan','Widowed'),(15,'Mart',16,'Male','Bajada','single'),(16,'Mart',21,'Male','Bajada','single'),(17,'Melyn',24,'Male','Bajada','single'),(18,'Botchoy',50,'Female','Boulevard','single'),(19,'Chester',29,'Male','Buhangin','single'),(21,'Paul',29,'Female','Buhangin','single'),(22,'Frank',39,'Female','Buhangin','single'),(23,'Frank',93,'Female','Blvd','single'),(24,'Mel',99,'Male','Maa','single'),(25,'Justin',100,'Female','Maa','Married'),(26,'Shane',10,'Male','Maa','Married'),(27,'April',12,'Male','Maa','Married'),(28,'Mary',18,'Male','Ma-a','Married'),(29,'Marky',85,'Male','Gravahan','Widowed'),(30,'Raphy',22,'Female','Alaska','single');
/*!40000 ALTER TABLE `tbl_owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_pet`
--

DROP TABLE IF EXISTS `tbl_pet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_pet` (
  `pet_id` int(8) NOT NULL,
  `owner_id` int(8) NOT NULL,
  `pet_name` varchar(20) NOT NULL,
  `pet_age` int(2) NOT NULL,
  `pet_gender` char(6) DEFAULT NULL,
  `pet_price` double(12,2) NOT NULL,
  `pet_color` char(20) DEFAULT NULL,
  `pet_type` varchar(30) DEFAULT NULL,
  `pet_breed` varchar(30) DEFAULT NULL,
  `pet_status` varchar(30) DEFAULT NULL,
  `date_added` date DEFAULT NULL,
  PRIMARY KEY (`pet_id`),
  KEY `owner_id` (`owner_id`),
  CONSTRAINT `tbl_pet_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `tbl_owner` (`owner_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_pet`
--

LOCK TABLES `tbl_pet` WRITE;
/*!40000 ALTER TABLE `tbl_pet` DISABLE KEYS */;
INSERT INTO `tbl_pet` VALUES (1001,1,'Anjun',13,'Male',1221.34,'blue','dog','Dachshund','Active','2001-06-02'),(1002,2,'Christ',12,'Male',2342.23,'orange','Fish','Guppy','Inactive','2011-12-18'),(1003,5,'Dianne',18,'Male',1345.13,'red','Dog','Beagle','Active','2007-05-12'),(1004,21,'Roldan',28,'Male',435.10,'blue','Fish','Guppy','Inactive','2000-11-28'),(1005,13,'April',28,'Female',5435.10,'orange','cat','Persian','Active','2006-07-28'),(1006,24,'Shedi',58,'Female',5435.10,'Dirty Black','Fish','Janitor','Active','2006-01-10'),(1007,29,'Diana',58,'Male',5435.10,'brown','Dog','Labrador','Active','2010-06-04'),(1008,19,'Rhunick',12,'Female',1435.10,'Dirty Black','dog','Siberian Husky','Active','2009-12-10'),(1010,19,'Rhunick',12,'Female',1435.10,'blue','Fish','Black Mole','Active','2018-06-11'),(1011,16,'Louie',8,'Undeci',435.10,'red','Dog','Askal','deceased','2014-03-11'),(1012,15,'Nepthalie',35,'Male',785.10,'Brown','dog','Siberian Husky','Active','2015-08-18'),(1013,14,'Jairah',15,'Male',7385.10,'Sky Green','Spider','Black Widows','Active','2011-06-25'),(1014,5,'Sigrid',25,'Male',5325.10,'blue','Spider','Camel','Active','2010-07-06'),(1015,2,'Yvonne',5,'Female',8325.10,'Sky Green','Dog','Siberian Husky','Active','2018-02-13'),(1016,4,'Melanie',3,'Male',825.10,'Black','Fish','Gold Fish','Active','2010-11-14'),(1017,7,'Philip',6,'Male',85.10,'blue','Fish','Gold Fish','Active','2024-02-01'),(1018,12,'Michael',13,'Transg',185.10,'white','dog','Siberian Husky','Active','2015-07-13'),(1019,23,'Jeff',23,'Male',585.10,'blue','Fish','Cat Fish','Active','2005-05-26'),(1020,3,'Gabriel',3,'Male',55.10,'blue','cat','Siamese','deceased','2004-07-02'),(1021,11,'Lloyd',12,'Female',15.10,'blue','Fish','Pirit','Active','2006-04-25'),(1022,15,'Floro',2,'Female',135.10,'red','Dog','Labrador','Active','2018-01-25'),(1023,1,'Tahir',1,'Male',235.10,'brown','Dog','Rottweiler','Active','2023-03-16'),(1024,21,'Krizia',4,'Male',152.10,'blue','dog','Dachshund','Active','2013-08-17'),(1025,2,'Angelou',3,'Male',23215.10,'blue','Dog','Poodle','Active','2022-08-12'),(1026,4,'Lolivy',6,'Male',3215.10,'brown','cat','Persian','Active','2024-01-01'),(1027,1,'Gem',32,'Male',565.10,'blue','dog','Dachshund','Active','2003-12-21'),(1028,4,'jim',6,'Female',3215.10,'blue','cat','Persian','Active','2020-02-20'),(1029,1,'Kenneth',7,'Male',215.10,'Rainbow','Cat','Dachshund','Active','2016-06-27'),(1030,2,'Jr',5,'Female',1215.15,'Gray','dog','Dachshund','Active','2022-01-10'),(1031,2,'Francis',5,'Female',4515.10,'blue','cat','Bengal','Active','2012-06-24'),(1032,5,'Billy',15,'Male',987.10,'brown','Spider','Black Widows','Active','2020-05-30'),(1033,1,'Alfred',25,'Female',1987.10,'pink','Dog','Rottweiler','Active','2016-06-04'),(1034,1,'Bien',5,'Female',1987.10,'blue','Frog','Bull Frog','Active','2020-11-25'),(1035,7,'Cyril',4,'Male',3987.10,'red','Bird','Eagle','Active','2007-01-13'),(1036,19,'martzl',12,'Male',3123.34,'blue','cat','Ragdoll','Active','2020-08-28'),(1037,1,'karding',34,'Male',21.00,'Black','Dog','Poodle','Active','2009-11-24'),(1038,1,'dasd',23,'Male',43423.00,'blue','cat','Siamese','Active','2011-08-15'),(1039,14,'ddsa',3,'Male',34.00,'Gray','Dragon','Drake','deceased','2004-04-21'),(1040,1,'sdfs',342,'Male',4242.00,'Gray','Dragon','Great Serpent','Inactive','2010-10-07'),(1041,1,'fsdfs',344,'Male',56.00,'orange','Bird','Eagle','Active','2016-10-25'),(1042,1,'ffds',43,'Female',534.00,'blue','Dog','Askal','Inactive','2003-08-08'),(1043,1,'da',23,'Female',2342.00,'orange','Dog','Rottweiler','Inactive','2015-09-29'),(1044,18,'baste',21,'Male',500.00,'blue','Dog','Beagle','Active','2019-09-20'),(1045,18,'kyle',23,'Male',4535.00,'blue','Dog','Beagle','Active','2003-03-05'),(1046,1,'Chris',3,'Male',342.00,'Black','Spider','Daddy Longlegs','Active','2004-11-28'),(1047,1,'Evans',4,'Female',23432.00,'Black','Bird','Parrot','Active','2015-01-11'),(1048,3,'Luphy',12,'Male',23231.90,'Green','bird','ostrich','lost','2012-03-23'),(1049,10,'Sandara',12,NULL,23231.90,'Green','bird','Chicken','lost','2016-01-13'),(1050,11,'Liza',16,NULL,5231.90,'Violet','Crocodile','Salt Corcs','Borrowed','2019-05-27');
/*!40000 ALTER TABLE `tbl_pet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-21 16:31:29
