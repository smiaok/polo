-- MySQL dump 10.13  Distrib 5.7.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: polo
-- ------------------------------------------------------
-- Server version	5.7.28

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
-- Table structure for table `mark_review`
--

DROP TABLE IF EXISTS `mark_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mark_review` (
  `mark_review_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评审任务ID',
  `marker` varchar(50) NOT NULL COMMENT '创建人',
  `project` varchar(50) DEFAULT NULL COMMENT '项目名',
  `version` varchar(255) DEFAULT NULL COMMENT '版本号',
  `file` varchar(50) DEFAULT NULL COMMENT '相对文件路径',
  `line` varchar(255) DEFAULT NULL COMMENT '评审行号',
  `type` varchar(50) DEFAULT NULL COMMENT '评审类型',
  `status` varchar(50) DEFAULT NULL COMMENT '评审任务状态',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `comment` varchar(255) DEFAULT NULL COMMENT '评审评论',
  `branch` varchar(255) DEFAULT NULL COMMENT '评审任务分支',
  PRIMARY KEY (`mark_review_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mark_review`
--

LOCK TABLES `mark_review` WRITE;
/*!40000 ALTER TABLE `mark_review` DISABLE KEYS */;
INSERT INTO `mark_review` VALUES (15,'lifan','jgit-demo','51ccc894decd005dc100dc0cadb29e8e552301b8',NULL,'169~174','bug','open','2021-05-14 15:03:41','2021-05-18 15:02:48',NULL,'dev'),(16,'lifan','jgit-demo','51ccc894decd005dc100dc0cadb29e8e552301b8','/src/main/java/Demo.java','174~176','bug','open','2021-05-14 15:11:08','2021-05-18 15:02:57',NULL,'dev'),(17,'lifan','jgit-demo','51ccc894decd005dc100dc0cadb29e8e552301b8','/src/main/java/Demo.java','201~202','bug','open','2021-05-14 15:21:49','2021-05-20 11:43:44','123\ndsdsd\n123','dev'),(18,'lifan','demo','dc24f71dbf7c3cce532b925e5e7632b7536ebefb','/src/Controller.java','3~6','bug','open','2021-05-20 11:22:08','2021-05-20 12:28:28','123','master'),(19,'lifan','jgit-demo','9bcf9e53d8ba4d2bed24bbb050c8fa502b215574','/src/main/java/Demo.java','50~52*235~238','bug','open','2021-05-20 11:45:11','2021-05-20 11:45:11','\n','dev'),(20,'smiaok','jgit-demo','9bcf9e53d8ba4d2bed24bbb050c8fa502b215574','/src/main/java/Demo.java','26~27*86~87','review','open','2021-05-20 16:25:42','2021-05-20 16:25:42','this my code\n','dev'),(21,'lifan','jgit-demo','9bcf9e53d8ba4d2bed24bbb050c8fa502b215574','/src/main/java/Demo.java','235~238','bug','open','2021-05-20 16:43:38','2021-05-20 16:43:38','this is a bug','dev');
/*!40000 ALTER TABLE `mark_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review_task`
--

DROP TABLE IF EXISTS `review_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review_task` (
  `review_task_id` int(11) NOT NULL AUTO_INCREMENT,
  `mark_review_id` int(11) NOT NULL,
  `reviewer` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`review_task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review_task`
--

LOCK TABLES `review_task` WRITE;
/*!40000 ALTER TABLE `review_task` DISABLE KEYS */;
INSERT INTO `review_task` VALUES (4,1,'smiaok'),(5,2,'smiaok'),(6,17,'smiaok'),(7,18,''),(8,19,'smiaok'),(9,20,''),(10,20,'lifan'),(11,21,'smiaok');
/*!40000 ALTER TABLE `review_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `user_user_name_uindex` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('hfm','abcdef','hfm@xbd.com','12580'),('lifan','123456','17302010008@fudan.edu.cn','15751208323'),('smiaok','smiaok','smiaok@ide.com','8788787');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-21  3:43:50
