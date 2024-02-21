-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: db_yu_constraints
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
-- Table structure for table `tbl_breed`
--

DROP TABLE IF EXISTS `tbl_breed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_breed` (
  `breed_id` int(8) NOT NULL,
  `breed_name` varchar(20) DEFAULT NULL,
  `type_id` int(8) DEFAULT NULL,
  PRIMARY KEY (`breed_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `tbl_breed_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `tbl_type` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_breed`
--

LOCK TABLES `tbl_breed` WRITE;
/*!40000 ALTER TABLE `tbl_breed` DISABLE KEYS */;
INSERT INTO `tbl_breed` VALUES (1,'Holstein',5),(2,'Comet Goldfish',4),(3,'Golden Retriever',1),(4,'English Lop',3),(5,'Siamese',2);
/*!40000 ALTER TABLE `tbl_breed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_gender`
--

DROP TABLE IF EXISTS `tbl_gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_gender` (
  `gender_id` int(3) NOT NULL AUTO_INCREMENT,
  `gender_title` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`gender_id`),
  UNIQUE KEY `gender_title` (`gender_title`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_gender`
--

LOCK TABLES `tbl_gender` WRITE;
/*!40000 ALTER TABLE `tbl_gender` DISABLE KEYS */;
INSERT INTO `tbl_gender` VALUES (2,'Female'),(1,'Male');
/*!40000 ALTER TABLE `tbl_gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_owner`
--

DROP TABLE IF EXISTS `tbl_owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_owner` (
  `owner_id` int(8) NOT NULL,
  `owner_name` varchar(50) NOT NULL,
  `owner_age` int(3) DEFAULT 0,
  `gender_id` int(8) DEFAULT NULL,
  `owner_address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`owner_id`),
  KEY `gender_id` (`gender_id`),
  CONSTRAINT `tbl_owner_ibfk_1` FOREIGN KEY (`gender_id`) REFERENCES `tbl_gender` (`gender_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_owner`
--

LOCK TABLES `tbl_owner` WRITE;
/*!40000 ALTER TABLE `tbl_owner` DISABLE KEYS */;
INSERT INTO `tbl_owner` VALUES (101,'Rob Stark',23,NULL,NULL),(102,'The Hound',32,NULL,NULL),(103,'The Hound',32,NULL,NULL),(104,'Null',18,NULL,NULL),(105,'Ash',28,NULL,NULL),(106,'Lucifer',15,NULL,NULL),(107,'Cersei',0,NULL,NULL);
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
  `owner_id` int(8) DEFAULT NULL,
  `pet_name` varchar(50) NOT NULL,
  `pet_age` int(11) DEFAULT NULL,
  `pet_gender` int(8) DEFAULT NULL,
  `pet_price` float(10,2) DEFAULT NULL,
  `pet_breed` int(8) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`pet_id`),
  KEY `gender_id` (`pet_gender`),
  KEY `owner_id` (`owner_id`),
  KEY `pet_breed` (`pet_breed`),
  CONSTRAINT `tbl_pet_ibfk_1` FOREIGN KEY (`pet_gender`) REFERENCES `tbl_gender` (`gender_id`),
  CONSTRAINT `tbl_pet_ibfk_2` FOREIGN KEY (`owner_id`) REFERENCES `tbl_owner` (`owner_id`),
  CONSTRAINT `tbl_pet_ibfk_3` FOREIGN KEY (`pet_breed`) REFERENCES `tbl_breed` (`breed_id`),
  CONSTRAINT `CONSTRAINT_1` CHECK (`pet_price` > 100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_pet`
--

LOCK TABLES `tbl_pet` WRITE;
/*!40000 ALTER TABLE `tbl_pet` DISABLE KEYS */;
INSERT INTO `tbl_pet` VALUES (1,101,'Ubre Blanca',15,1,150.25,1,'Alive'),(2,103,'Buddy',10,1,200.50,3,'Sick'),(3,105,'Pandy',5,2,420.60,4,'Alive'),(4,106,'Whiskers',12,1,110.00,5,'Alive');
/*!40000 ALTER TABLE `tbl_pet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_type`
--

DROP TABLE IF EXISTS `tbl_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_type` (
  `type_id` int(8) NOT NULL,
  `type_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_type`
--

LOCK TABLES `tbl_type` WRITE;
/*!40000 ALTER TABLE `tbl_type` DISABLE KEYS */;
INSERT INTO `tbl_type` VALUES (1,'Dog'),(2,'Cat'),(3,'Rabbit'),(4,'Goldfish'),(5,'Cow');
/*!40000 ALTER TABLE `tbl_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-21 16:32:12
