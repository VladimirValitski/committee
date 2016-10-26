-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.5.23 - MySQL Community Server (GPL)
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных admission_committee
CREATE DATABASE IF NOT EXISTS `admission_committee` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `admission_committee`;


-- Дамп структуры для таблица admission_committee.abiturient
CREATE TABLE IF NOT EXISTS `abiturient` (
  `id_abiturienta` int(3) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(50) DEFAULT '0',
  `first_name` varchar(50) DEFAULT '0',
  `second_name` varchar(50) DEFAULT '0',
  `phone` varchar(11) DEFAULT '0',
  `pasport` varchar(50) NOT NULL DEFAULT '0',
  `user_role` int(1) NOT NULL DEFAULT '0',
  `password` int(4) NOT NULL DEFAULT '1234',
  PRIMARY KEY (`id_abiturienta`),
  KEY `FK_abiturient_statement` (`pasport`),
  CONSTRAINT `FK_abiturient_statement` FOREIGN KEY (`pasport`) REFERENCES `statement` (`pasport`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы admission_committee.abiturient: ~22 rows (приблизительно)
/*!40000 ALTER TABLE `abiturient` DISABLE KEYS */;
INSERT INTO `abiturient` (`id_abiturienta`, `last_name`, `first_name`, `second_name`, `phone`, `pasport`, `user_role`, `password`) VALUES
	(1, 'Denchik', 'Denis', 'Denisovich', '80292277454', 'ab1234243', 0, 1234),
	(2, 'Vakolin ', 'Vlad', 'Viktorovich', '80293453456', 'ab1233245', 0, 1234),
	(3, 'Payne', 'Maxim', 'Petrovich', '80294454556', 'ab2345434', 0, 1234),
	(4, 'Vaserman', 'Isia', 'Isakovich', '80254454556', 'ab3450987', 0, 1234),
	(5, 'Beturin', 'Karl', 'Iosifovich', '80334477556', 'ab3456789', 0, 1234),
	(6, 'Soroko', 'Dmitrii', 'Stanislavovich', '80294454999', 'ab5678923', 0, 1234),
	(7, 'Semutov', 'Pavel', 'Stanislavovich', '80334114556', 'kb2348756', 0, 1234),
	(8, 'Dzerman', 'Aleksei', 'Ivanovich', '80331114533', 'mc3459890', 0, 1234),
	(9, 'Misalik', 'Alena', 'Vitalevna', '80335515533', 'mc8674532', 0, 1234),
	(10, 'Nadina', 'Galina', 'Viktorovna', '80295665533', 'mc9567834', 0, 1234),
	(11, 'Vikar', 'Oleg', 'Olegovich', '80335888533', 'mp1232312', 0, 1234),
	(12, 'Bertosh', 'Anna', 'Olegovna', '80335519999', 'mp3450909', 0, 1234),
	(13, 'Mishin', 'Petr', 'Petrovich', '80334415773', 'rh5463452', 0, 1234),
	(14, 'Bertosh', 'Svetlana', 'Olegovna', '80295512331', 'mp3454334', 0, 1234),
	(15, 'Pikulina', 'Alesia', 'Sergeevna', '80295455386', 'mp5467576', 0, 1234),
	(16, 'Yudina', 'Viktoria', 'Ivanovna', '80298455586', 'mp5545456', 0, 1234),
	(17, 'Urchik', 'Dmitriy', 'Olegovich', '80295457689', 'mp6573462', 0, 1234),
	(18, 'Kononovich', 'Aleksandr', 'Aleksandrovich', '80295325381', 'mp6574578', 0, 1234),
	(19, 'Valitski', 'Vladimir', 'Viktorovich', '80295411116', 'rh2343456', 0, 1234),
	(20, 'Svetlakov', 'Pavel', 'Sergeevich', '80295455355', 'rh5346345', 0, 1234),
	(21, 'Sobolev', 'Ivan', 'Ivanovich', '80295256686', 'ab1001010', 0, 1234),
	(25, 'admin', '0', '0', '0', 'admin', 1, 1111);
/*!40000 ALTER TABLE `abiturient` ENABLE KEYS */;


-- Дамп структуры для таблица admission_committee.faculty
CREATE TABLE IF NOT EXISTS `faculty` (
  `id_faculty` tinyint(3) NOT NULL AUTO_INCREMENT,
  `name_faculty` varchar(50) DEFAULT NULL,
  `enrollment` tinyint(3) DEFAULT NULL,
  PRIMARY KEY (`id_faculty`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы admission_committee.faculty: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` (`id_faculty`, `name_faculty`, `enrollment`) VALUES
	(1, 'FITR', 5),
	(2, 'AF', 6),
	(3, 'ATF', 5),
	(4, 'EF', 4);
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;


-- Дамп структуры для таблица admission_committee.result
CREATE TABLE IF NOT EXISTS `result` (
  `pasport` varchar(50) NOT NULL,
  `accept` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pasport`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы admission_committee.result: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
/*!40000 ALTER TABLE `result` ENABLE KEYS */;


-- Дамп структуры для таблица admission_committee.statement
CREATE TABLE IF NOT EXISTS `statement` (
  `pasport` varchar(50) NOT NULL,
  `subject_one` tinyint(3) DEFAULT NULL,
  `subject_two` tinyint(3) DEFAULT NULL,
  `school_certificate` tinyint(3) DEFAULT NULL,
  `total_score` mediumint(9) DEFAULT NULL,
  `id_faculty` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`pasport`),
  KEY `FK_statement_faculty` (`id_faculty`),
  CONSTRAINT `FK_statement_faculty` FOREIGN KEY (`id_faculty`) REFERENCES `faculty` (`id_faculty`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы admission_committee.statement: ~22 rows (приблизительно)
/*!40000 ALTER TABLE `statement` DISABLE KEYS */;
INSERT INTO `statement` (`pasport`, `subject_one`, `subject_two`, `school_certificate`, `total_score`, `id_faculty`) VALUES
	('ab1001010', 85, 76, 89, 250, 3),
	('ab1233245', 56, 67, 76, 199, 3),
	('ab1234243', 76, 78, 80, 234, 3),
	('ab2345434', 78, 89, 90, 257, 1),
	('ab3450987', 49, 67, 93, 209, 3),
	('ab3456789', 72, 63, 74, 209, 3),
	('ab5678923', 56, 89, 54, 199, 3),
	('admin', NULL, NULL, NULL, NULL, NULL),
	('kb2348756', 87, 75, 92, 254, 2),
	('mc3459890', 78, 89, 98, 265, 4),
	('mc8674532', 83, 74, 90, 247, 1),
	('mc9567834', 93, 87, 92, 272, 2),
	('mp1232312', 98, 97, 100, 295, 1),
	('mp3450909', 90, 91, 98, 279, 2),
	('mp3454334', 95, 96, 99, 290, 1),
	('mp5467576', 87, 87, 96, 270, 2),
	('mp5545456', 54, 76, 87, 217, 4),
	('mp6573462', 94, 96, 90, 280, 2),
	('mp6574578', 90, 98, 99, 287, 1),
	('rh2343456', 87, 98, 9, 194, 2),
	('rh5346345', 85, 84, 90, 259, 1),
	('rh5463452', 82, 84, 89, 255, 2);
/*!40000 ALTER TABLE `statement` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
