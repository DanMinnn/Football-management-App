-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: sanbong
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `co_so`
--

DROP TABLE IF EXISTS `co_so`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `co_so` (
  `tenCS` varchar(100) NOT NULL,
  `maCS` int NOT NULL,
  PRIMARY KEY (`maCS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `co_so`
--

LOCK TABLES `co_so` WRITE;
/*!40000 ALTER TABLE `co_so` DISABLE KEYS */;
INSERT INTO `co_so` VALUES ('Cơ sở 1',1),('Cơ sở 2',2),('Cơ sở 3',3);
/*!40000 ALTER TABLE `co_so` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khach_hang`
--

DROP TABLE IF EXISTS `khach_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khach_hang` (
  `username` varchar(100) NOT NULL,
  `sdt` varchar(10) NOT NULL,
  `so_tk` varchar(100) NOT NULL,
  PRIMARY KEY (`sdt`,`username`),
  UNIQUE KEY `sdt_UNIQUE` (`sdt`),
  UNIQUE KEY `so_tk_UNIQUE` (`so_tk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khach_hang`
--

LOCK TABLES `khach_hang` WRITE;
/*!40000 ALTER TABLE `khach_hang` DISABLE KEYS */;
/*!40000 ALTER TABLE `khach_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `san_bong`
--

DROP TABLE IF EXISTS `san_bong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `san_bong` (
  `maCS` int NOT NULL,
  `ten_san` varchar(45) NOT NULL,
  `loai_san` int NOT NULL,
  `ngay_Da` date DEFAULT NULL,
  `thoi_gian` datetime DEFAULT NULL,
  `trang_thai` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `san_bong`
--

LOCK TABLES `san_bong` WRITE;
/*!40000 ALTER TABLE `san_bong` DISABLE KEYS */;
INSERT INTO `san_bong` VALUES (1,'Sân 1',5,NULL,NULL,'Trống'),(2,'Sân 2',5,NULL,NULL,'Bận'),(2,'Sân 3',7,NULL,NULL,'Bận'),(3,'Sân 4',7,NULL,NULL,'Trống');
/*!40000 ALTER TABLE `san_bong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sign_in_user`
--

DROP TABLE IF EXISTS `sign_in_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sign_in_user` (
  `username` varchar(50) NOT NULL,
  `sdt` varchar(45) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`sdt`),
  UNIQUE KEY `sdt_UNIQUE` (`sdt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sign_in_user`
--

LOCK TABLES `sign_in_user` WRITE;
/*!40000 ALTER TABLE `sign_in_user` DISABLE KEYS */;
INSERT INTO `sign_in_user` VALUES ('vivo','0762567673','1234'),('vominhkha','0765131567','12345'),('kha0603','0903654735','123lol456'),('khavo123','0935933212','123');
/*!40000 ALTER TABLE `sign_in_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-20 14:30:09
