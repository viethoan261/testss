-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: education
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `last_modified_at` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `capacity` int NOT NULL,
  `price` double NOT NULL,
  `room_no` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `last_modified_at` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `class_name` varchar(255) NOT NULL,
  `dob` date DEFAULT NULL,
  `hometown` varchar(255) DEFAULT NULL,
  `identify_card` varchar(255) NOT NULL,
  `student_no` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `last_modified_at` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `full_name` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phone_number` varchar(50) DEFAULT NULL,
  `role` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1f860ca0-0ddd-41a4-9869-67c1105df9fe','2023-11-09 10:17:23.608132','anonymousUser','2023-11-09 10:17:23.608132','anonymousUser',_binary '\0',NULL,NULL,'Admin 4','$2a$10$IQW66h9bosd8liEaf6eNJ.qaYLQjvXMtScLgRlVVgR0mMuWptgrFS',NULL,'ROLE_ADMIN','admin4',NULL,NULL),('328e0f46-a419-4049-85c7-2a57289521fb','2023-11-09 10:18:42.244994','anonymousUser','2023-11-09 10:18:42.244994','anonymousUser',_binary '\0',NULL,NULL,'Admin 5','$2a$10$We4z7nCOoq6odJzgUkjIduNQIZDShKJxozX79yhY9kLIphai4PR4y',NULL,'ROLE_ADMIN','admin5',NULL,NULL),('4247fc34-222b-402c-9ae0-3eac81fe7bac','2023-11-09 10:16:46.984113','anonymousUser','2023-11-09 10:16:46.984113','anonymousUser',_binary '\0',NULL,NULL,'Admin 3','$2a$10$W/n9uWqlOJRsgiA0Wx1x0e3G.XbVxKZoXmyN6fcS.Kdvg7pVy/nrO',NULL,'ROLE_ADMIN','admin3',NULL,NULL),('45d3a676-4f42-419f-8275-dff6064a4991','2023-11-09 10:16:01.135684','anonymousUser','2023-11-09 10:16:01.135684','anonymousUser',_binary '\0',NULL,NULL,'Admin 2','$2a$10$VAmEBAlyeYnO/BmTJLFVNuX7U9ZNWACK3GSOkYhlHHWXrv0QMakbq',NULL,'ROLE_ADMIN','admin2',NULL,NULL),('5cd46f2b-3ca1-41af-af96-646d6920959c','2023-11-09 10:14:14.635467','anonymousUser','2023-11-09 10:14:14.635467','anonymousUser',_binary '\0',NULL,NULL,'Admin','$2a$10$dj991BWQuJj7ShTvU01nvur091LAX0MwXLKqrvzuMnjApdeIXpLHG',NULL,'ROLE_GUEST','admin',NULL,NULL),('9199427d-51e6-4c72-a179-f6538a3f38d0','2023-11-09 10:15:02.391372','anonymousUser','2023-11-09 10:15:02.391372','anonymousUser',_binary '\0',NULL,NULL,'Admin 1','$2a$10$wEm5h6sJjYB.1e.tV3TSJeZuUwNH52qQR4Mys91tcr9y34ra.wska',NULL,'ROLE_ADMIN','admin1',NULL,NULL),('b49b2882-53e2-47f7-8a86-c502d61f6232','2023-11-09 10:32:36.791587','anonymousUser','2023-11-09 10:32:36.791587','anonymousUser',_binary '\0',NULL,NULL,'Admin 6','$2a$10$R1DNGZgMcuV0uMUaVKoPEuBBXbCbPMcvQuLB9.YYKfYNZVP63AHgC',NULL,'ROLE_ADMIN','admin6',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'education'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-29  0:16:26
