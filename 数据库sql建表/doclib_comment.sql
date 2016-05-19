-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: doclib
-- ------------------------------------------------------
-- Server version	5.7.12-log

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

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userAccount` varchar(45) NOT NULL,
  `docId` int(5) NOT NULL,
  `message` varchar(300) NOT NULL,
  `score` decimal(3,1) DEFAULT NULL,
  `sendTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `userAccount_idx` (`userAccount`),
  KEY `docID_idx` (`docId`),
  CONSTRAINT `docID` FOREIGN KEY (`docId`) REFERENCES `doc` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `userAccount` FOREIGN KEY (`userAccount`) REFERENCES `user` (`userAccount`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'kaikai',1,'挺好',3.0,'2015-09-08 16:00:00'),(2,'kaikai',1,'不错',3.0,'2016-05-04 16:00:00'),(3,'kaikai',11,'很好',4.0,'2016-07-07 16:00:00'),(4,'kaikai',11,'不错',4.0,'2016-09-07 16:00:00'),(5,'kaikai',12,'很好',5.0,'2016-04-04 16:00:00'),(6,'kaikai',13,'不错',3.0,'2016-09-08 16:00:00'),(7,'kaikai',14,'很好',4.0,'2016-04-02 16:00:00'),(9,'kaikai',12,'测试测试',3.0,'2016-05-03 07:28:46'),(12,'kaikai',13,'改变',4.0,'2016-05-03 07:50:10'),(36,'kaikai',13,'最后一次了吗',0.0,'2016-05-04 02:38:35'),(37,'kaikai',13,'再发一次',0.0,'2016-05-04 02:43:59'),(38,'kaikai',12,'5月4号测试第一次',4.0,'2016-05-04 02:56:39'),(39,'kaikai',12,'再发一次',4.0,'2016-05-04 03:06:31'),(40,'kaikai',13,'评论',2.0,'2016-05-04 09:24:30'),(43,'kaikai',12,'测试评分',3.0,'2016-05-04 12:26:43'),(44,'kaikai',11,'测试评分',1.0,'2016-05-04 12:27:38'),(45,'kaikai',9,'第一次打分',2.0,'2016-05-04 12:45:47'),(46,'kaikai',9,'第二次打分',5.0,'2016-05-04 12:45:59'),(47,'kaikai',11,'再试试',4.0,'2016-05-04 12:51:18'),(48,'kaikai',11,'评分',5.0,'2016-05-04 12:53:52'),(49,'kaikai',11,'很好',4.0,'2016-05-04 12:56:06'),(50,'kaikai',16,'评论一下',4.0,'2016-05-04 23:20:58'),(52,'kaikai',14,'评论一下',5.0,'2016-05-04 23:22:52'),(53,'kaikai',14,'评论一下',3.0,'2016-05-04 23:28:04'),(55,'kaikai',20,'不错',3.0,'2016-05-12 02:52:27'),(59,'liukaikai',26,'还不错',4.0,'2016-05-13 08:24:53'),(60,'liukaikai',29,'评价一下，还不错哦',4.0,'2016-05-13 08:27:06'),(61,'liukaikai',30,'评论一下',4.0,'2016-05-13 08:29:08'),(62,'ddlorry',31,'很完整',3.0,'2016-05-14 23:41:13'),(63,'ddlorry',31,'123',5.0,'2016-05-14 23:42:06'),(64,'kaikai',31,'',1.0,'2016-05-15 03:07:59'),(65,'kaikai11',31,'还不错哦',3.0,'2016-05-15 12:33:48');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-16  7:55:25
