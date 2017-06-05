-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.17 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.3.0.5027
-- --------------------------------------------------------


CREATE DATABASE IF NOT EXISTS `dictionary` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dictionary`;

CREATE TABLE IF NOT EXISTS `words` (
  `id` int(150) NOT NULL AUTO_INCREMENT,
  `word` varchar(255) DEFAULT NULL,
  `meaning` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
); 

DELETE FROM `words`;

INSERT INTO `words` (`id`, `word`, `meaning`) VALUES
	(1, 'Hola', 'Hello'),
	(2, 'Adios', 'Bye');
	
	