-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: clients
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `connectionNo` int(12) NOT NULL AUTO_INCREMENT,
  `clientName` varchar(40) DEFAULT NULL,
  `clientAddress` varchar(100) DEFAULT NULL,
  `phoneNo` int(10) DEFAULT NULL,
  `nic` char(10) DEFAULT NULL,
  `zone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`connectionNo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'P G P Prasanna','177/3 Gamagewatta Gurulana IhalaBope Padukka','117836511','905601056v','zone1'),(2,'P K G Amarasena','72, Ananda Coomaraswamy Mawatha Colombo 07','537894123','923456932v','zone1'),(3,'H M D Weerasooriya','718/7 Maradana Road Colombo 10','772384501','892005412v','zone3'),(4,'A K D Somarathna','177/3 Gamagewatta Gurulana IhalaBope Padukka','758992355','825921246v','zone4'),(5,'A K D Somarathna','177/3 Gamagewatta Gurulana IhalaBope Padukka','758992355','825921246v','zone4'),(6,'P G P Prasanna','177/3 Gamagewatta Gurulana IhalaBope Padukka','117836511','905601056v','zone1'),(7,'P K G Amarasena','72, Ananda Coomaraswamy Mawatha Colombo 07','537894123','923456932v','zone1'),(8,'H M D Weerasooriya','718/7 Maradana Road Colombo 10','772384501','892005412v','zone3'),(9,'A K D Somarathna','177/3 Gamagewatta Gurulana IhalaBope Padukka','758992355','825921246v','zone4'),(10,'T S D Karunarathna','122/A Galpahana Hettigoda','775376519','936123895v','zone1');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-26 19:26:03
