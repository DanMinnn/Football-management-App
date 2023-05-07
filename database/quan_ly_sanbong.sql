-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sanbong
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `co_so`
--

DROP TABLE IF EXISTS `co_so`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `co_so` (
  `tenCS` varchar(100) NOT NULL,
  `maCS` varchar(20) NOT NULL,
  PRIMARY KEY (`maCS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `co_so`
--

LOCK TABLES `co_so` WRITE;
/*!40000 ALTER TABLE `co_so` DISABLE KEYS */;
INSERT INTO `co_so` VALUES ('Cơ sở 1','1'),('Cơ sở 2','2'),('Cơ sở 3','3');
/*!40000 ALTER TABLE `co_so` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dat_san`
--

DROP TABLE IF EXISTS `dat_san`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dat_san` (
  `ma_san` varchar(45) NOT NULL,
  `sdt` varchar(45) NOT NULL,
  `maCS` varchar(45) NOT NULL,
  `thoi_gian_da` datetime NOT NULL,
  PRIMARY KEY (`thoi_gian_da`),
  UNIQUE KEY `thoi_gian_da_UNIQUE` (`thoi_gian_da`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dat_san`
--

LOCK TABLES `dat_san` WRITE;
/*!40000 ALTER TABLE `dat_san` DISABLE KEYS */;
/*!40000 ALTER TABLE `dat_san` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khach_hang`
--

DROP TABLE IF EXISTS `khach_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khach_hang` (
  `ten_khach_hang` varchar(100) NOT NULL,
  `sdt` varchar(10) NOT NULL,
  PRIMARY KEY (`sdt`),
  UNIQUE KEY `sdt_UNIQUE` (`sdt`)
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
  `ma_san` varchar(45) NOT NULL,
  `ten_san` varchar(45) NOT NULL,
  `loai_san` varchar(45) NOT NULL,
  `maCS` varchar(45) NOT NULL,
  PRIMARY KEY (`ma_san`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `san_bong`
--

LOCK TABLES `san_bong` WRITE;
/*!40000 ALTER TABLE `san_bong` DISABLE KEYS */;
INSERT INTO `san_bong` VALUES ('1.1','1','5 người','1'),('1.2','2','5 người','1'),('1.3','3','5 người','1'),('2.1','1','5 người','2'),('3.1','1','5 người','3');
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
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sign_in_user`
--

LOCK TABLES `sign_in_user` WRITE;
/*!40000 ALTER TABLE `sign_in_user` DISABLE KEYS */;
INSERT INTO `sign_in_user` VALUES ('kha0603','123lol456'),('khavo123','123'),('vivo','1234'),('vominhkha','12345');
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

-- Dump completed on 2023-05-07 14:45:32
