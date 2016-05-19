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
-- Table structure for table `doc`
--

DROP TABLE IF EXISTS `doc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doc` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `author` varchar(10) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `abs` varchar(100) DEFAULT NULL,
  `attachedFile` varchar(50) DEFAULT NULL,
  `uploader` varchar(45) DEFAULT NULL,
  `uploadTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `downloadTime` varchar(45) DEFAULT '0',
  `score` decimal(3,1) DEFAULT '0.0',
  `url` varchar(150) DEFAULT NULL,
  `htmlUrl` varchar(150) DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doc`
--

LOCK TABLES `doc` WRITE;
/*!40000 ALTER TABLE `doc` DISABLE KEYS */;
INSERT INTO `doc` VALUES (1,'1.txt','kk','kk','kk','l','dd','2015-04-03 16:00:00','99',9.0,'txt/1.txt',''),(9,'博客html.txt','pp','文学','pp','pp','pp','2016-04-29 00:40:33','0',5.0,'http://localhost:8080\\/doc_lib/\\txt博客html.txt',''),(11,'博客html.txt','曹雪芹','文学','宝姐姐','iiii','刘凯','2016-04-30 02:02:08','0',3.2,'http://localhost:8080/doc_lib//txt/博客html.txt',''),(12,'国创中期.txt','施耐庵','文学','梁山','567','刘凯','2016-04-30 11:28:07','0',3.0,'http://localhost:8080/doc_lib/txt/国创中期.txt',''),(13,'要做的事.txt','吴承恩','文学','西天取经','333','凯凯','2016-05-01 02:14:30','3.0',3.0,'http://localhost:8080/doc_lib/txt/要做的事.txt',''),(14,'日志0309.txt','肖洛霍夫','文学','格里高利','333','凯凯','2016-05-01 02:30:03','0',3.4,'http://localhost:8080/doc_lib/txt/日志0309.txt',''),(16,'软件工程设计文档.txt','三毛','文学','撒哈拉的爱情','随便','33','2016-05-03 13:34:04','1.0',3.3,'http://localhost:8080/doc_lib/txt/软件工程设计文档.txt',''),(20,'html.html','kaikai','工程技术','html','html','kaikai','2016-05-05 02:27:34','3.0',3.0,'http://localhost:8080/doc_lib/txt/html.html',''),(26,'日志0401.txt','凯凯','文学','44','444','kaikai','2016-05-13 08:14:06','1.0',4.0,'http://localhost:8080/doc_lib/txt/日志0401.txt',''),(27,'日志0405.txt','凯凯','文学','234','123','kaikai','2016-05-13 08:15:01','0',0.0,'http://localhost:8080/doc_lib/txt/日志0405.txt',''),(29,'日志0406.txt','凯凯','自然科学','关于虚拟机','123','kaikai','2016-05-13 08:26:27','1.0',4.0,'http://localhost:8080/doc_lib/txt/日志0406.txt',''),(30,'1.doc','恺恺','哲学','关于gc','231','kaikai','2016-05-13 08:28:10','1.0',4.0,'http://localhost:8080/doc_lib/txt/1.doc','http://localhost:8080/doc_lib/html/1.htm'),(31,'3月12日招聘会学生志愿者须知.doc','凯凯','文学','关于vm','24','kaikai','2016-05-13 08:33:01','1.0',3.0,'http://localhost:8080/doc_lib/txt/3月12日招聘会学生志愿者须知.doc','http://localhost:8080/doc_lib/html/3月12日招聘会学生志愿者须知.htm'),(35,'华南理工大学科技成果申请软件登记申请表最新.docx','凯凯','文学','123','333','333','2016-05-15 13:34:26','0',0.0,'http://localhost:8080/doc_lib/txt/华南理工大学科技成果申请软件登记申请表最新.docx','http://localhost:8080/doc_lib/html/华南理工大学科技成果申请软件登记申请表最新.htm'),(36,'','','文学','','','','2016-05-15 13:39:35','0',0.0,'',''),(37,'华南理工大学IC_Compus校园信息发布平台系统建设方案.doc','凯凯','文学','每个人的一生都有那最艰难的一年，把人生变得美好而辽阔','222','kaikai','2016-05-15 13:44:07','0',0.0,'http://localhost:8080/doc_lib/txt/华南理工大学IC_Compus校园信息发布平台系统建设方案.doc','http://localhost:8080/doc_lib/html/华南理工大学IC_Compus校园信息发布平台系统建设方案.htm');
/*!40000 ALTER TABLE `doc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-16  7:55:28
