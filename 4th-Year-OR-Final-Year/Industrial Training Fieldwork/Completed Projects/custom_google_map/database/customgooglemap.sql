-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 26, 2014 at 02:12 PM
-- Server version: 5.5.25a
-- PHP Version: 5.4.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `customgooglemap`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_markers`
--

CREATE TABLE IF NOT EXISTS `tbl_markers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `address` varchar(80) NOT NULL,
  `lat` float(10,6) NOT NULL,
  `lng` float(10,6) NOT NULL,
  `contact` varchar(30) NOT NULL,
  `type` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Dumping data for table `tbl_markers`
--

INSERT INTO `tbl_markers` (`id`, `name`, `address`, `lat`, `lng`, `contact`, `type`) VALUES
(14, 'Dangerous Dentist', '12/3 An road Dahaka', 23.703636, 90.374908, '01923585801', 6),
(13, 'Khulna University Medicine Center', '1st accademic building, Khulna University, Khulna 9208', 23.729256, 90.392075, '041-731475', 7),
(15, 'sdfdsf', 'dsfdsfsdf', 23.709846, 90.383232, 'dsfdsfdsf', 5),
(16, 'Khulna University', 'Divitional University, KHULNA 9208', 22.799803, 89.534111, '041731415', 5),
(17, 'Khulna  University Medical Center', 'Khulna University, khulna 9208', 22.802414, 89.535179, '01788589632', 7),
(18, 'school 1', 'This is our head office', 23.711340, 90.377998, '25252', 1),
(19, 'school 2', 'fdfdsf', 23.715897, 90.387093, '24234', 1),
(20, 'college 1', 'college 1', 23.718410, 90.394821, '3434232', 3),
(21, 'college 2', 'college 1', 23.713776, 90.399200, 'college 1', 3);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_marker_type`
--

CREATE TABLE IF NOT EXISTS `tbl_marker_type` (
  `type` int(3) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(50) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `tbl_marker_type`
--

INSERT INTO `tbl_marker_type` (`type`, `type_name`) VALUES
(1, 'Primary School'),
(2, 'High School'),
(3, 'College'),
(4, 'Dispensary '),
(5, 'University'),
(6, 'Dentist'),
(7, 'Health Care'),
(8, 'Hospitals'),
(9, 'Medical College'),
(10, 'Banks'),
(11, 'ATM'),
(12, 'Software Companies');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_setting`
--

CREATE TABLE IF NOT EXISTS `tbl_setting` (
  `key` varchar(10000) NOT NULL,
  `value` varchar(10000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_setting`
--

INSERT INTO `tbl_setting` (`key`, `value`) VALUES
('latitude', '60.440963'),
('longitude', '23.093262');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
