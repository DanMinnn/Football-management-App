-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ungdungsanbong
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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `iD_admin` int NOT NULL AUTO_INCREMENT,
  `TenDangNhap` varchar(50) NOT NULL,
  `MatKhau` varchar(50) NOT NULL,
  `iD_coso` varchar(10) DEFAULT NULL,
  `iD_NhanVien` varchar(10) DEFAULT NULL,
  `ID_SDT_KH` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`iD_admin`),
  KEY `iD_coso` (`iD_coso`),
  KEY `iD_NhanVien` (`iD_NhanVien`),
  KEY `ID_SDT_KH` (`ID_SDT_KH`),
  CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`iD_coso`) REFERENCES `coso` (`iD_CoSo`),
  CONSTRAINT `admin_ibfk_2` FOREIGN KEY (`iD_NhanVien`) REFERENCES `nhanvien` (`iD_NhanVien`),
  CONSTRAINT `admin_ibfk_3` FOREIGN KEY (`ID_SDT_KH`) REFERENCES `khachhang` (`ID_SDT_KH`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coso`
--

DROP TABLE IF EXISTS `coso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coso` (
  `iD_CoSo` varchar(10) NOT NULL,
  `TenCoSo` varchar(50) NOT NULL,
  `DiaChi` varchar(50) NOT NULL,
  PRIMARY KEY (`iD_CoSo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coso`
--

LOCK TABLES `coso` WRITE;
/*!40000 ALTER TABLE `coso` DISABLE KEYS */;
INSERT INTO `coso` VALUES ('1','Minh','Nguyễn Xiển'),('2','Kha','Đình Phong Phú'),('3','Lợi Anh','Võ Văn Ngân');
/*!40000 ALTER TABLE `coso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `ID_SDT_KH` varchar(15) NOT NULL,
  `HoTen` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_SDT_KH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES ('0336701719','ý thiên'),('034129856','Minh'),('0356215745','Hoàng Anh'),('035875125','Kha'),('0851237264','Lợi Nguyễn'),('0888123756','Hoàng Anh'),('0972236703','Kha Võ'),('0984437426','Lợi');
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lichdat`
--

DROP TABLE IF EXISTS `lichdat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lichdat` (
  `iD_CoSo` varchar(10) DEFAULT NULL,
  `iD_SanBong` varchar(10) DEFAULT NULL,
  `TenSan` varchar(20) NOT NULL,
  `LoaiSan` varchar(10) NOT NULL,
  `NgayDa` date NOT NULL,
  `TgBatDau` time(6) DEFAULT NULL,
  `TgKetThuc` time(6) DEFAULT NULL,
  `ID_SDT_KH` varchar(15) NOT NULL,
  PRIMARY KEY (`ID_SDT_KH`),
  KEY `iD_CoSo` (`iD_CoSo`),
  KEY `iD_SanBong` (`iD_SanBong`),
  CONSTRAINT `lichdat_ibfk_1` FOREIGN KEY (`iD_CoSo`) REFERENCES `coso` (`iD_CoSo`),
  CONSTRAINT `lichdat_ibfk_2` FOREIGN KEY (`iD_SanBong`) REFERENCES `sanbong` (`iD_SanBong`),
  CONSTRAINT `lichdat_ibfk_3` FOREIGN KEY (`ID_SDT_KH`) REFERENCES `khachhang` (`ID_SDT_KH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lichdat`
--

LOCK TABLES `lichdat` WRITE;
/*!40000 ALTER TABLE `lichdat` DISABLE KEYS */;
INSERT INTO `lichdat` VALUES ('1','5','FNB','7 người','2023-05-25','18:42:00.000000','20:42:00.000000','0336701719'),('1','6','Rose Bowl','7 người','2023-05-23','18:00:00.000000','19:30:00.000000','0356215745'),('2','11','Borg El Arab','7 người','2023-05-24','17:30:00.000000','19:30:00.000000','0851237264'),('1','1','Michigan','5 người','2023-05-23','19:30:00.000000','20:30:00.000000','0972236703');
/*!40000 ALTER TABLE `lichdat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `iD_NhanVien` varchar(10) NOT NULL,
  `HoTen` varchar(50) DEFAULT NULL,
  `GioiTinh` varchar(10) DEFAULT NULL,
  `NamSinh` date DEFAULT NULL,
  `SDT` varchar(15) NOT NULL,
  `DiaChi` varchar(50) NOT NULL,
  `iD_CoSo` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`iD_NhanVien`),
  KEY `iD_CoSo` (`iD_CoSo`),
  CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`iD_CoSo`) REFERENCES `coso` (`iD_CoSo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES ('BN97','Bạch Nhật','Nam','2002-10-12','0382574797','Gò Vấp','1'),('DS45','Đình Sang','Nam','2000-11-12','0971235745','Đình Phong Phú','2'),('LB45','Lê Bảo','Nam','2000-11-12','0382574845','Lê Văn Việt','1'),('LD98','Lý Đức','Nam','1999-07-07','0971235698','Đình Phong Phú','2'),('NH89','Nhật Hoàng','Nam','2003-04-30','0978421189','Làng Tăng Phú','3'),('NH93','Nhật Hạ','Nữ','2002-10-12','0382574393','Quận 9','1'),('NP47','Nhật Phú','Nam','2003-04-30','0978421356','Làng Tăng Phú','3'),('NV','Hà Vi','Nam','2004-05-07','0892361425','Nguyễn Xiển','3'),('TH03','Thiên Hoàng','Nam','2001-01-06','0972236703','Lê Văn Việt','2');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanbong`
--

DROP TABLE IF EXISTS `sanbong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanbong` (
  `iD_SanBong` varchar(10) NOT NULL,
  `TenSan` varchar(50) NOT NULL,
  `LoaiSan` varchar(10) NOT NULL,
  `GiaTien` float NOT NULL,
  `iD_CoSo` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`iD_SanBong`),
  KEY `iD_CoSo` (`iD_CoSo`),
  CONSTRAINT `sanbong_ibfk_1` FOREIGN KEY (`iD_CoSo`) REFERENCES `coso` (`iD_CoSo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanbong`
--

LOCK TABLES `sanbong` WRITE;
/*!40000 ALTER TABLE `sanbong` DISABLE KEYS */;
INSERT INTO `sanbong` VALUES ('1','Michigan','5 người',250000,'1'),('10','Lusail Iconi','7 người',300000,'2'),('11','Borg El Arab','7 người',300000,'2'),('12','Australia','7 người',300000,'2'),('13','MetLife','5 người',250000,'3'),('14','Croke Park','5 người',250000,'3'),('15','Jakarta','5 người',250000,'3'),('16','FedExField','7 người',300000,'3'),('17','Luzhniki','7 người',300000,'3'),('18','Martyrs','7 người',300000,'3'),('2','Cricket','5 người',250000,'1'),('3','Ground','5 người',250000,'1'),('4','Camp Nou ','7 người',300000,'1'),('5','FNB','7 người',300000,'1'),('6','Rose Bowl','7 người',300000,'1'),('7','Wembley','5 người',250000,'2'),('8','Azteca ','5 người',250000,'2'),('9','Bukit Jalil ','5 người',250000,'2');
/*!40000 ALTER TABLE `sanbong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `sbcotrandau`
--

DROP TABLE IF EXISTS `sbcotrandau`;
/*!50001 DROP VIEW IF EXISTS `sbcotrandau`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `sbcotrandau` AS SELECT 
 1 AS `iD_SanBong`,
 1 AS `TenSan`,
 1 AS `Số Lượng trận đấu`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `signin_user`
--

DROP TABLE IF EXISTS `signin_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signin_user` (
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `SDT` varchar(15) NOT NULL,
  PRIMARY KEY (`SDT`),
  UNIQUE KEY `Username` (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signin_user`
--

LOCK TABLES `signin_user` WRITE;
/*!40000 ALTER TABLE `signin_user` DISABLE KEYS */;
INSERT INTO `signin_user` VALUES ('anhvu','Anhvu2003','0336701719'),('Đặng Minh','minhdang','0356789423'),('Kha Võ','khavo','0378125458');
/*!40000 ALTER TABLE `signin_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `view_lichdat`
--

DROP TABLE IF EXISTS `view_lichdat`;
/*!50001 DROP VIEW IF EXISTS `view_lichdat`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_lichdat` AS SELECT 
 1 AS `iD_SanBong`,
 1 AS `TenSan`,
 1 AS `NgayDa`,
 1 AS `TgBatDau`,
 1 AS `TgKetThuc`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `sbcotrandau`
--

/*!50001 DROP VIEW IF EXISTS `sbcotrandau`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `sbcotrandau` AS select `sb`.`iD_SanBong` AS `iD_SanBong`,`sb`.`TenSan` AS `TenSan`,count(0) AS `Số Lượng trận đấu` from (`sanbong` `sb` join `lichdat` `ld`) where (`sb`.`iD_SanBong` = `ld`.`iD_SanBong`) group by `sb`.`iD_SanBong`,`sb`.`TenSan` having (count(0) > 0) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_lichdat`
--

/*!50001 DROP VIEW IF EXISTS `view_lichdat`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_lichdat` AS select `sb`.`iD_SanBong` AS `iD_SanBong`,`sb`.`TenSan` AS `TenSan`,`ld`.`NgayDa` AS `NgayDa`,`ld`.`TgBatDau` AS `TgBatDau`,`ld`.`TgKetThuc` AS `TgKetThuc` from (`sanbong` `sb` join `lichdat` `ld`) where (`sb`.`iD_SanBong` = `ld`.`iD_SanBong`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-24 22:04:37
