-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 27, 2014 at 11:03 AM
-- Server version: 5.5.25a
-- PHP Version: 5.4.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `custommenu`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_menujson`
--

CREATE TABLE IF NOT EXISTS `tbl_menujson` (
  `menu_json` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_menujson`
--

INSERT INTO `tbl_menujson` (`menu_json`) VALUES
('[{"id":"hihiih33","children":[{"id":"hihiih33asdfasf"},{"id":"hihiih33asdfasfasfas"}]},{"id":"hihiih33asdfasffasf"},{"id":"Home","children":[{"id":"asdasd"},{"id":"Search","children":[{"id":"hihiih33asdfasffasfasd"},{"id":"Contact","children":[{"id":"About us","children":[{"id":"hihiih"},{"id":"hihiih33asdfasfasfasasfasf"}]}]}]}]}]');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
