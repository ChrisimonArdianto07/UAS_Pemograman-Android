-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.18-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for db_catatan
CREATE DATABASE IF NOT EXISTS `db_catatan` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `db_catatan`;

-- Dumping structure for table db_catatan.tb_catatan
CREATE TABLE IF NOT EXISTS `tb_catatan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `judul` varchar(50) DEFAULT NULL,
  `catatan` varchar(5000) DEFAULT NULL,
  `tgl` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_catatan.tb_catatan: ~0 rows (approximately)
/*!40000 ALTER TABLE `tb_catatan` DISABLE KEYS */;
INSERT INTO `tb_catatan` (`id`, `judul`, `catatan`, `tgl`) VALUES
	(5, 'Belanja Sayur', 'singkong\nDaun\nWortel', 'Rabu, 10 April 2022'),
	(6, 'Deadline', 'Android ', 'minggu, 26 juni 2022');
/*!40000 ALTER TABLE `tb_catatan` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
