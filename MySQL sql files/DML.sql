-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: db_yu_activitybasicdml1
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
  `Owner_ID` int(12) DEFAULT NULL,
  `Owner_Name` varchar(12) DEFAULT NULL,
  `Owner_Address` text DEFAULT NULL,
  `Owner_Gender` varchar(12) DEFAULT NULL,
  `Owner_Contact` int(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_owner`
--

LOCK TABLES `tbl_owner` WRITE;
/*!40000 ALTER TABLE `tbl_owner` DISABLE KEYS */;
INSERT INTO `tbl_owner` VALUES (1,'Cain','Davao City','Female',2229614),(2,'Biden','Davao City','Male',3561256),(3,'Obama','Washington DC','Male',54201567),(4,'Navia','Fontaine','Female',1528640),(5,'Ian','North Carolina','Male',52526384);
/*!40000 ALTER TABLE `tbl_owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_pet`
--

DROP TABLE IF EXISTS `tbl_pet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_pet` (
  `pet_id` int(12) DEFAULT NULL,
  `pet_name` varchar(25) DEFAULT NULL,
  `pet_gender` char(6) DEFAULT NULL,
  `pet_color` varchar(25) DEFAULT NULL,
  `pet_age` tinyint(3) DEFAULT NULL,
  `pet_type` varchar(25) DEFAULT NULL,
  `pet_breed` varchar(25) DEFAULT NULL,
  `pet_price` float(8,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_pet`
--

LOCK TABLES `tbl_pet` WRITE;
/*!40000 ALTER TABLE `tbl_pet` DISABLE KEYS */;
INSERT INTO `tbl_pet` VALUES (1,'Anna','Female','Pinkish White',12,'Dog','Husky',2300.45),(2,'Whiskers','Male','Gray',10,'Cat','Abyssinian',2500.00),(3,'Obama','Male','Black',20,'Cat','Birman',2303.00),(4,'Luh Bee','Female','Orange',29,'Dog','Shiba Inu',3000.00),(5,'Escanor','Male','White',30,'Dog','Pug',3500.21),(10,'Simba','Male','Golden',3,'Cat','Maine Coon',2300.00),(1001,'Nymeria','Female','White',5,'Rabbit','American',3232.12),(1002,'Luh Kay','Female','Red',3,'Fish','Koi',3982.25),(1002,'Anna','Female','Gray',12,'Cat','British Shorthair',2245.25);
/*!40000 ALTER TABLE `tbl_pet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_pet_backup`
--

DROP TABLE IF EXISTS `tbl_pet_backup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_pet_backup` (
  `pet_id` int(12) DEFAULT NULL,
  `pet_name` varchar(25) DEFAULT NULL,
  `pet_gender` char(6) DEFAULT NULL,
  `pet_color` varchar(25) DEFAULT NULL,
  `pet_age` tinyint(3) DEFAULT NULL,
  `pet_type` varchar(25) DEFAULT NULL,
  `pet_breed` varchar(25) DEFAULT NULL,
  `pet_price` float(8,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_pet_backup`
--

LOCK TABLES `tbl_pet_backup` WRITE;
/*!40000 ALTER TABLE `tbl_pet_backup` DISABLE KEYS */;
INSERT INTO `tbl_pet_backup` VALUES (1,'Anna','Female','Pinkish White',12,'Dog','Husky',2300.45),(2,'Whiskers','Male','Gray',10,'Cat','Abyssinian',2500.00),(3,'Obama','Male','Black',20,'Cat','Birman',2303.00),(4,'Sparky','Female','Orange',29,'Dog','Shiba Inu',3000.00),(5,'Escanor','Male','White',30,'Dog','Pug',3500.21),(1001,'Nymeria','female',NULL,5,NULL,NULL,NULL),(1002,'Luh Kay',NULL,NULL,NULL,NULL,NULL,NULL),(3,'Ismael Kah Conti','female',NULL,16,NULL,NULL,NULL),(4,'Anne ann',NULL,NULL,12,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_pet_backup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_pet_backup2`
--

DROP TABLE IF EXISTS `tbl_pet_backup2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_pet_backup2` (
  `pet_id` int(12) DEFAULT NULL,
  `pet_name` varchar(25) DEFAULT NULL,
  `pet_gender` char(6) DEFAULT NULL,
  `pet_color` varchar(25) DEFAULT NULL,
  `pet_age` tinyint(3) DEFAULT NULL,
  `pet_type` varchar(25) DEFAULT NULL,
  `pet_breed` varchar(25) DEFAULT NULL,
  `pet_price` float(8,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_pet_backup2`
--

LOCK TABLES `tbl_pet_backup2` WRITE;
/*!40000 ALTER TABLE `tbl_pet_backup2` DISABLE KEYS */;
INSERT INTO `tbl_pet_backup2` VALUES (1,'Anna','Female','Pinkish White',12,'Dog','Husky',2300.45),(2,'Whiskers','Male','Gray',10,'Cat','Abyssinian',2500.00),(3,'Obama','Male','Black',20,'Cat','Birman',2303.00),(4,'Sparky','Female','Orange',29,'Dog','Shiba Inu',3000.00),(5,'Escanor','Male','White',30,'Dog','Pug',3500.21),(1001,'Nymeria','female',NULL,5,NULL,NULL,NULL),(1002,'Luh Kay',NULL,NULL,NULL,NULL,NULL,NULL),(1002,'Anna','Female',NULL,12,NULL,NULL,NULL),(10,'Simba','Male','Golden',3,'Cat','Maine Coon',2300.00);
/*!40000 ALTER TABLE `tbl_pet_backup2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_pet_backup3`
--

DROP TABLE IF EXISTS `tbl_pet_backup3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_pet_backup3` (
  `pet_id` int(12) DEFAULT NULL,
  `pet_name` varchar(25) DEFAULT NULL,
  `pet_gender` char(6) DEFAULT NULL,
  `pet_color` varchar(25) DEFAULT NULL,
  `pet_age` tinyint(3) DEFAULT NULL,
  `pet_type` varchar(25) DEFAULT NULL,
  `pet_breed` varchar(25) DEFAULT NULL,
  `pet_price` float(8,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_pet_backup3`
--

LOCK TABLES `tbl_pet_backup3` WRITE;
/*!40000 ALTER TABLE `tbl_pet_backup3` DISABLE KEYS */;
INSERT INTO `tbl_pet_backup3` VALUES (1,'Anna','Female','Pinkish White',12,'Dog','Husky',2300.45),(2,'Whiskers','Male','Gray',10,'Cat','Abyssinian',2500.00),(3,'Obama','Male','Black',20,'Cat','Birman',2303.00),(4,'Luh Bee','Female','Orange',29,'Dog','Shiba Inu',3000.00),(5,'Escanor','Male','White',30,'Dog','Pug',3500.21),(10,'Simba','Male','Golden',3,'Cat','Maine Coon',2300.00),(1001,'Nymeria','female',NULL,5,NULL,NULL,NULL),(1002,'Luh Kay',NULL,NULL,NULL,NULL,NULL,NULL),(1002,'Anna','Female',NULL,12,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_pet_backup3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_pet_new`
--

DROP TABLE IF EXISTS `tbl_pet_new`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_pet_new` (
  `pet_id` int(12) DEFAULT NULL,
  `pet_name` varchar(25) DEFAULT NULL,
  `pet_gender` char(6) DEFAULT NULL,
  `pet_color` varchar(25) DEFAULT NULL,
  `pet_age` tinyint(3) DEFAULT NULL,
  `pet_type` varchar(25) DEFAULT NULL,
  `pet_breed` varchar(25) DEFAULT NULL,
  `pet_price` float(8,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_pet_new`
--

LOCK TABLES `tbl_pet_new` WRITE;
/*!40000 ALTER TABLE `tbl_pet_new` DISABLE KEYS */;
INSERT INTO `tbl_pet_new` VALUES (1,'Anna','Female','Pinkish White',12,'Dog','Husky',2300.45),(2,'Whiskers','Male','Gray',10,'Cat','Abyssinian',2500.00),(3,'Obama','Male','Black',20,'Cat','Birman',2303.00),(4,'Sparky','Female','Orange',29,'Dog','Shiba Inu',3000.00),(5,'Escanor','Male','White',30,'Dog','Pug',3500.21),(1001,'Nymeria','female',NULL,5,NULL,NULL,NULL),(1002,'Luh Kay',NULL,NULL,NULL,NULL,NULL,NULL),(3,'Ismael Kah Conti','female',NULL,16,NULL,NULL,NULL),(4,'Anne ann',NULL,NULL,12,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_pet_new` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_pet_new_truncate`
--

DROP TABLE IF EXISTS `tbl_pet_new_truncate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_pet_new_truncate` (
  `pet_id` int(12) DEFAULT NULL,
  `pet_name` varchar(25) DEFAULT NULL,
  `pet_gender` char(6) DEFAULT NULL,
  `pet_color` varchar(25) DEFAULT NULL,
  `pet_age` tinyint(3) DEFAULT NULL,
  `pet_type` varchar(25) DEFAULT NULL,
  `pet_breed` varchar(25) DEFAULT NULL,
  `pet_price` float(8,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_pet_new_truncate`
--

LOCK TABLES `tbl_pet_new_truncate` WRITE;
/*!40000 ALTER TABLE `tbl_pet_new_truncate` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_pet_new_truncate` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-21 16:29:44
