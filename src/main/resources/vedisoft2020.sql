CREATE DATABASE  IF NOT EXISTS `vedisoft2020` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `vedisoft2020`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: vedisoft2020
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `batch`
--

DROP TABLE IF EXISTS `batch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `batch` (
  `batch_id` int(7) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `faculty_id` int(7) DEFAULT NULL,
  `course_id` int(7) DEFAULT NULL,
  `timings` varchar(20) DEFAULT NULL,
  `sdate` date DEFAULT NULL,
  `days` varchar(20) DEFAULT NULL,
  `enddate` varchar(20) DEFAULT NULL,
  `session_id` int(7) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `last_updated_by` int(11) DEFAULT NULL,
  `last_updation_date` date DEFAULT NULL,
  `status` varchar(20) DEFAULT 'false',
  `branch_id` int(7) DEFAULT NULL,
  PRIMARY KEY (`batch_id`),
  KEY `FKlyo26rvg0hs090cwqxgxrw0xn` (`course_id`),
  KEY `FKqqkqw9inkx96xpy8glctrjal` (`session_id`),
  CONSTRAINT `FK53ym4fhkxur42j72bk78dvwwu` FOREIGN KEY (`batch_id`) REFERENCES `branches` (`branch_id`),
  CONSTRAINT `FKlyo26rvg0hs090cwqxgxrw0xn` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `FKqqkqw9inkx96xpy8glctrjal` FOREIGN KEY (`session_id`) REFERENCES `session` (`session_id`)
) ENGINE=InnoDB AUTO_INCREMENT=855 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch`
--

LOCK TABLES `batch` WRITE;
/*!40000 ALTER TABLE `batch` DISABLE KEYS */;
/*!40000 ALTER TABLE `batch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `branches`
--

DROP TABLE IF EXISTS `branches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branches` (
  `branch_id` int(7) NOT NULL AUTO_INCREMENT,
  `branch_name` varchar(20) DEFAULT NULL,
  `branch_prefix` varchar(20) DEFAULT NULL,
  `plot_no` varchar(20) DEFAULT NULL,
  `locality` varchar(20) DEFAULT NULL,
  `street` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `branch_manager_id` int(7) DEFAULT '0',
  `branch_contact_no` varchar(20) DEFAULT NULL,
  `multiple_courses` varchar(1000) DEFAULT NULL,
  `estb_date` date DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `last_updated_by` int(11) DEFAULT NULL,
  `last_updation_date` date DEFAULT NULL,
  `extra1` varchar(20) DEFAULT NULL,
  `extra2` int(7) DEFAULT NULL,
  `lat` varchar(45) DEFAULT NULL,
  `longi` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branches`
--

LOCK TABLES `branches` WRITE;
/*!40000 ALTER TABLE `branches` DISABLE KEYS */;
/*!40000 ALTER TABLE `branches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificate_request`
--

DROP TABLE IF EXISTS `certificate_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `certificate_request` (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `batch_code` int(7) unsigned DEFAULT NULL,
  `regno` varchar(20) DEFAULT NULL,
  `request_date` date DEFAULT '1111-11-11',
  `prepared` varchar(20) DEFAULT 'no',
  `delivered_date` date DEFAULT '1111-11-11',
  `branch_id` int(7) DEFAULT '0',
  `delivered_to_name` varchar(200) DEFAULT NULL,
  `delivered_to_contactno` varchar(200) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `last_created_by` int(11) DEFAULT NULL,
  `last_creation_date` date DEFAULT NULL,
  `delivery_status` varchar(20) DEFAULT 'no',
  `addedby` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrc5r5qt20lr8vqj32qocbohxv` (`branch_id`),
  CONSTRAINT `FKrc5r5qt20lr8vqj32qocbohxv` FOREIGN KEY (`branch_id`) REFERENCES `branches` (`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2103 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificate_request`
--

LOCK TABLES `certificate_request` WRITE;
/*!40000 ALTER TABLE `certificate_request` DISABLE KEYS */;
/*!40000 ALTER TABLE `certificate_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `college_list`
--

DROP TABLE IF EXISTS `college_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `college_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `prefix` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `group` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `college_list`
--

LOCK TABLES `college_list` WRITE;
/*!40000 ALTER TABLE `college_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `college_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `prefix` varchar(20) DEFAULT NULL,
  `certi_title` varchar(1000) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fees`
--

DROP TABLE IF EXISTS `fees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fees` (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `batch_id` int(7) DEFAULT '0',
  `famt` float(7,2) DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `mode1` varchar(20) DEFAULT NULL,
  `branch_id` int(7) DEFAULT '0',
  `created_by` int(11) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `last_creation_by` int(11) DEFAULT NULL,
  `last_creation_date` date DEFAULT NULL,
  `extra1` varchar(20) DEFAULT NULL,
  `extra2` int(7) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK83cx53uws8x9vw5wp1pl29lp5` (`branch_id`),
  KEY `FKp2f1dli3xylm8cjb26q372sgs` (`batch_id`),
  CONSTRAINT `FK83cx53uws8x9vw5wp1pl29lp5` FOREIGN KEY (`branch_id`) REFERENCES `branches` (`branch_id`),
  CONSTRAINT `FKp2f1dli3xylm8cjb26q372sgs` FOREIGN KEY (`batch_id`) REFERENCES `batch` (`batch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1069 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fees`
--

LOCK TABLES `fees` WRITE;
/*!40000 ALTER TABLE `fees` DISABLE KEYS */;
/*!40000 ALTER TABLE `fees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequences`
--

DROP TABLE IF EXISTS `hibernate_sequences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) NOT NULL,
  `sequence_next_hi_value` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequences`
--

LOCK TABLES `hibernate_sequences` WRITE;
/*!40000 ALTER TABLE `hibernate_sequences` DISABLE KEYS */;
/*!40000 ALTER TABLE `hibernate_sequences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `installment`
--

DROP TABLE IF EXISTS `installment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `installment` (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `receipt_no` int(20) unsigned DEFAULT '0',
  `reg_no` varchar(45) DEFAULT NULL,
  `inst_date` date DEFAULT NULL,
  `amt` float(7,2) DEFAULT NULL,
  `batch_id` int(7) NOT NULL DEFAULT '0',
  `mode1` varchar(20) DEFAULT NULL,
  `chq_no` int(20) DEFAULT NULL,
  `bank` varchar(20) DEFAULT NULL,
  `chq_date` date DEFAULT '1111-11-11',
  `staff_id` int(7) NOT NULL DEFAULT '0',
  `branch_id` int(7) NOT NULL DEFAULT '0',
  `created_by` int(11) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `last_created_by` int(11) DEFAULT NULL,
  `last_creation_date` date DEFAULT NULL,
  `sgst` float DEFAULT NULL,
  `cgst` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnf7j7e2cfdo0l04vfwmlnkfjm` (`batch_id`),
  KEY `FKt966t4223h5ubqmgr1do0bgc1` (`branch_id`),
  KEY `FKma8150gtjxy4v69soytlq7sya` (`staff_id`),
  CONSTRAINT `FKma8150gtjxy4v69soytlq7sya` FOREIGN KEY (`staff_id`) REFERENCES `person` (`person_id`),
  CONSTRAINT `FKnf7j7e2cfdo0l04vfwmlnkfjm` FOREIGN KEY (`batch_id`) REFERENCES `batch` (`batch_id`),
  CONSTRAINT `FKt966t4223h5ubqmgr1do0bgc1` FOREIGN KEY (`branch_id`) REFERENCES `branches` (`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30189 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `installment`
--

LOCK TABLES `installment` WRITE;
/*!40000 ALTER TABLE `installment` DISABLE KEYS */;
/*!40000 ALTER TABLE `installment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `person_id` int(7) NOT NULL AUTO_INCREMENT,
  `person_type_id` varchar(45) DEFAULT NULL,
  `person_name` varchar(20) DEFAULT NULL,
  `designation` varchar(20) DEFAULT NULL,
  `branch_id` int(7) DEFAULT NULL,
  `contact_no` varchar(20) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `plot_no` varchar(200) DEFAULT NULL,
  `street` varchar(200) DEFAULT NULL,
  `locality` varchar(200) DEFAULT NULL,
  `city` varchar(200) DEFAULT NULL,
  `state` varchar(200) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `doj` date DEFAULT NULL,
  `dol` date DEFAULT '1111-11-11',
  `email` varchar(40) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `key1` varchar(20) DEFAULT NULL,
  `active` tinyint(4) DEFAULT NULL,
  `card_no` varchar(20) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `last_updated_by` int(11) DEFAULT NULL,
  `last_updated_date` date DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  KEY `FK24cd7xd1k53egm5vpw3jsgmxv` (`branch_id`),
  KEY `FKrv80qoye1tq4e4130myn7nsqd` (`person_type_id`),
  KEY `FKedyxnqaser12tdgscf2f02hoc` (`pid`),
  CONSTRAINT `FK24cd7xd1k53egm5vpw3jsgmxv` FOREIGN KEY (`branch_id`) REFERENCES `branches` (`branch_id`),
  CONSTRAINT `FKedyxnqaser12tdgscf2f02hoc` FOREIGN KEY (`pid`) REFERENCES `person_type` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'ab','Aashray Jain','developer',NULL,'7389330515','katni','402','df','bhopal','bhopal','mp','1999-09-10','2016-06-12','1111-11-11','aashrayjainkatni@gmail.com','aashrayjain','$2a$10$fQS861GqtmQWU8GGgFuFt.58dfydVCAyjmiElSvXgIgjUn.BXoza6','admin',1,'as',12,'2016-06-12',12,'2016-06-12',NULL);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_type`
--

DROP TABLE IF EXISTS `person_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_type` (
  `person_type_id` varchar(45) DEFAULT NULL,
  `person_type` varchar(20) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `last_updated_by` int(11) DEFAULT NULL,
  `last_updated_date` date DEFAULT NULL,
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_type`
--

LOCK TABLES `person_type` WRITE;
/*!40000 ALTER TABLE `person_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `person_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `session`
--

DROP TABLE IF EXISTS `session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `session` (
  `session_id` int(7) NOT NULL AUTO_INCREMENT,
  `session_name` varchar(20) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `last_updated_by` int(11) DEFAULT NULL,
  `last_updation_date` date DEFAULT NULL,
  `extra` varchar(20) DEFAULT NULL,
  `command` varchar(255) DEFAULT NULL,
  `conn_id` decimal(19,2) DEFAULT NULL,
  `current_memory` longtext,
  `current_statement` longtext,
  `db` varchar(255) DEFAULT NULL,
  `full_scan` varchar(255) DEFAULT NULL,
  `last_statement` longtext,
  `last_statement_latency` longtext,
  `last_wait` varchar(255) DEFAULT NULL,
  `last_wait_latency` longtext,
  `lock_latency` longtext,
  `pid` varchar(255) DEFAULT NULL,
  `program_name` varchar(255) DEFAULT NULL,
  `progress` decimal(19,2) DEFAULT NULL,
  `rows_affected` decimal(19,2) DEFAULT NULL,
  `rows_examined` decimal(19,2) DEFAULT NULL,
  `rows_sent` decimal(19,2) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `statement_latency` longtext,
  `thd_id` decimal(19,2) DEFAULT NULL,
  `time` decimal(19,2) DEFAULT NULL,
  `tmp_disk_tables` decimal(19,2) DEFAULT NULL,
  `tmp_tables` decimal(19,2) DEFAULT NULL,
  `trx_autocommit` varchar(255) DEFAULT NULL,
  `trx_latency` longtext,
  `trx_state` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`session_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session`
--

LOCK TABLES `session` WRITE;
/*!40000 ALTER TABLE `session` DISABLE KEYS */;
/*!40000 ALTER TABLE `session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `registration_id` int(7) NOT NULL AUTO_INCREMENT,
  `registration_date` date DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `course` varchar(20) DEFAULT NULL,
  `sem` varchar(20) DEFAULT NULL,
  `laddress` varchar(100) DEFAULT NULL,
  `paddress` varchar(100) DEFAULT NULL,
  `flag` varchar(20) DEFAULT 'yes',
  `dob` date DEFAULT NULL,
  `mno` varchar(20) DEFAULT NULL,
  `whatsapp_no` varchar(20) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `campus` varchar(20) DEFAULT NULL,
  `doj` date DEFAULT '1111-11-11',
  `package1` varchar(20) DEFAULT '11111',
  `enquiry_id` int(7) DEFAULT NULL,
  `branch` varchar(20) DEFAULT NULL,
  `college_id` int(7) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `branch_id` int(7) DEFAULT NULL,
  `card_no` int(7) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `last_updated_by` varchar(20) DEFAULT NULL,
  `last_updation_date` date DEFAULT NULL,
  `reg_id` varchar(145) DEFAULT NULL,
  `company` varchar(20) DEFAULT 'AAAA',
  `extra3` varchar(120) DEFAULT '0',
  `father_name` varchar(45) DEFAULT NULL,
  `parent_occupation` varchar(45) DEFAULT NULL,
  `pno` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`registration_id`),
  KEY `FKd0ada08nji7l9tpoqqeq3fsfo` (`branch_id`),
  KEY `FKad8k2y991820i6c5yygen7vc2` (`college_id`),
  CONSTRAINT `FKad8k2y991820i6c5yygen7vc2` FOREIGN KEY (`college_id`) REFERENCES `college_list` (`id`),
  CONSTRAINT `FKd0ada08nji7l9tpoqqeq3fsfo` FOREIGN KEY (`branch_id`) REFERENCES `branches` (`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19785 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_batch`
--

DROP TABLE IF EXISTS `student_batch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_batch` (
  `sb_id` int(7) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(200) DEFAULT NULL,
  `batch_id` int(10) unsigned DEFAULT '0',
  `flag` varchar(20) DEFAULT 'yes',
  `created_by` int(11) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `last_updated_by` int(11) DEFAULT NULL,
  `last_updated_date` date DEFAULT NULL,
  `joined` varchar(45) NOT NULL DEFAULT '0',
  `certificate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`sb_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22978 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_batch`
--

LOCK TABLES `student_batch` WRITE;
/*!40000 ALTER TABLE `student_batch` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_batch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `uid` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `current_connections` decimal(19,2) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` tinyint(4) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `total_connections` decimal(19,2) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `acid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
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

-- Dump completed on 2020-02-04 13:09:57
