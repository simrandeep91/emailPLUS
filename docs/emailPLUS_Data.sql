-- MySQL dump 10.13  Distrib 5.1.37, for pc-linux-gnu (i686)
--
-- Host: localhost    Database: emailplus
-- ------------------------------------------------------
-- Server version	5.1.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

drop database if exists emailplus;
create database emailplus;
use emailplus; 
--
-- Table structure for table `mailmaster`
--

DROP TABLE IF EXISTS `mailmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mailmaster` (
  `Mail_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Configuration_ID` int(11) DEFAULT NULL,
  `Mail_To` text,
  `Mail_Subject` varchar(45) DEFAULT NULL,
  `Mail_Content` text,
  `Mail_Date` datetime DEFAULT NULL,
  PRIMARY KEY (`Mail_ID`),
  KEY `fk_MailMaster_emailmanagerConfigurationMaster` (`Configuration_ID`),
  CONSTRAINT `fk_MailMaster_emailmanagerConfigurationMaster` FOREIGN KEY (`Configuration_ID`) REFERENCES `mailserverconfigurationmaster` (`Configuration_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mailmaster`
--

LOCK TABLES `mailmaster` WRITE;
/*!40000 ALTER TABLE `mailmaster` DISABLE KEYS */;
INSERT INTO `mailmaster` VALUES (1,1,'vinay.ms5@gmail.com;testingwebapplication@gmail.com','Testing Mail Manager','Hello Vinay,\n\nI am testing mail manager.\n\nThanks and Regards\n\nVineet','2010-07-28 00:00:49'),(2,1,'vinay.ms5@gmail.com','Test Mail','Hello,\nthis is a test mail.\n\nThanks and regards,\nvineet','2010-07-28 00:20:21'),(3,3,'vinay.ms5@gmail.com','Test Mail from employee','Hello \nthis is a test mail.\n\nRegards,\nRohit','2010-07-28 00:24:05');
/*!40000 ALTER TABLE `mailmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mailserverconfigurationmaster`
--

DROP TABLE IF EXISTS `mailserverconfigurationmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mailserverconfigurationmaster` (
  `Configuration_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `SMTP_Server` varchar(45) DEFAULT NULL,
  `POP_Server` varchar(45) DEFAULT NULL,
  `User_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`Configuration_ID`),
  KEY `fk_emailmanagerConfigurationMaster_UserMaster` (`User_ID`),
  CONSTRAINT `fk_emailmanagerConfigurationMaster_UserMaster` FOREIGN KEY (`User_ID`) REFERENCES `usermaster` (`User_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mailserverconfigurationmaster`
--

LOCK TABLES `mailserverconfigurationmaster` WRITE;
/*!40000 ALTER TABLE `mailserverconfigurationmaster` DISABLE KEYS */;
INSERT INTO `mailserverconfigurationmaster` VALUES (1,'alphanettechnologies@gmail.com','AlphaNet','smtp.gmail.com','pop.gmail.com',1),(2,'employee@yahoo.com','employee','plus.smtp.mail.yahoo.com','plus.pop.mail.yahoo.com',2),(3,'employee@gmail.com','employee','smtp.gmail.com','pop.gmail.com',2),(4,'admin@yahoo.com','admin','plus.smtp.mail.yahoo.com','plus.pop.mail.yahoo.com',1);
/*!40000 ALTER TABLE `mailserverconfigurationmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useractivitymaster`
--

DROP TABLE IF EXISTS `useractivitymaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useractivitymaster` (
  `Activity_ID` int(11) NOT NULL AUTO_INCREMENT,
  `User_ID` int(11) DEFAULT NULL,
  `Login_Time` datetime DEFAULT NULL,
  `Logout_Time` datetime DEFAULT NULL,
  PRIMARY KEY (`Activity_ID`),
  KEY `fk_UserActivityMaster_UserMaster` (`User_ID`),
  CONSTRAINT `fk_UserActivityMaster_UserMaster` FOREIGN KEY (`User_ID`) REFERENCES `usermaster` (`User_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useractivitymaster`
--

LOCK TABLES `useractivitymaster` WRITE;
/*!40000 ALTER TABLE `useractivitymaster` DISABLE KEYS */;
INSERT INTO `useractivitymaster` VALUES (1,1,'2011-06-22 17:02:14','2011-06-22 17:03:09'),(2,1,'2011-06-22 17:39:46','2011-06-22 17:40:16'),(3,1,'2011-06-23 10:59:17','2011-06-23 11:00:24'),(4,1,'2011-06-28 15:11:58','2011-06-28 15:35:22');
/*!40000 ALTER TABLE `useractivitymaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usermaster`
--

DROP TABLE IF EXISTS `usermaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usermaster` (
  `User_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `User_Type` varchar(20) DEFAULT NULL,
  `User_Status` varchar(20) DEFAULT NULL,
  `Security_Question` varchar(100) DEFAULT NULL,
  `Security_Answer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`User_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermaster`
--

LOCK TABLES `usermaster` WRITE;
/*!40000 ALTER TABLE `usermaster` DISABLE KEYS */;
INSERT INTO `usermaster` VALUES (1,'admin','admin','Administrator','Active','What is your hobby?','Playing hockey'),(2,'employee','employee','Employee','Active','Your favourite colour','Sky Blue');
/*!40000 ALTER TABLE `usermaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userpersonaldetail`
--

DROP TABLE IF EXISTS `userpersonaldetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userpersonaldetail` (
  `User_ID` int(11) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Date_Of_Birth` date DEFAULT NULL,
  `Address` varchar(300) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Mobile` varchar(20) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`User_ID`),
  KEY `fk_UserPersonalDetail_UserMaster` (`User_ID`),
  CONSTRAINT `fk_UserPersonalDetail_UserMaster` FOREIGN KEY (`User_ID`) REFERENCES `usermaster` (`User_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userpersonaldetail`
--

LOCK TABLES `userpersonaldetail` WRITE;
/*!40000 ALTER TABLE `userpersonaldetail` DISABLE KEYS */;
INSERT INTO `userpersonaldetail` VALUES (1,'Rohanpreet Singh','1985-05-07','# 1245\nSector 16, chandigarh, punjab, india','017261243332','7888964442','rohanpreet1@yahoo.com'),(2,'Mukesh sharma','1983-05-09','# 1222\nSector 5, chandigarh, punjab, india','01724143332','9988964442','mukesh@yahoo.com');
/*!40000 ALTER TABLE `userpersonaldetail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-06-28 15:39:51
