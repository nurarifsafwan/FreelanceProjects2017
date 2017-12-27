-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 18, 2017 at 06:24 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tutortoyou`
--

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE IF NOT EXISTS `class` (
`idclass` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL,
  `region` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `idstudent` int(11) NOT NULL,
  `idtutor` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`idclass`, `name`, `description`, `region`, `phone`, `idstudent`, `idtutor`) VALUES
(1, 'Database I', 'A class about database system and query', '0102233456', 'Perak', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
`idstudent` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(200) NOT NULL,
  `email` varchar(150) NOT NULL,
  `phone` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`idstudent`, `username`, `password`, `name`, `email`, `phone`) VALUES
(1, 'nurarifsafwan', 'pass123', 'Nur Arif Safwan Abdullah', 'safwan@gmail.com', '112233442'),
(2, 'arsenewenger', 'pass123', 'Arsene Wenger', 'arsene@gmail.com', '0112345432'),
(3, 'amalina', '1234', 'amalinazahari', 'amalina@gmail.com', '0123456789'),
(4, 'amalina', '1234', 'amalinazahari', 'amalina@gmail.com', '0123456789');

-- --------------------------------------------------------

--
-- Table structure for table `tutor`
--

CREATE TABLE IF NOT EXISTS `tutor` (
`idtutor` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(200) NOT NULL,
  `email` varchar(150) NOT NULL,
  `phone` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tutor`
--

INSERT INTO `tutor` (`idtutor`, `username`, `password`, `name`, `email`, `phone`) VALUES
(1, 'hidayahalinlod', 'pass123', 'Hidayah Alinlod', 'hidayahalinlod@gmail.com', '0102233456'),
(4, 'amalina', 'pass1234', 'amalina', 'amalina@gmail.com', '0123344565'),
(7, 'josemourinho', 'pass123', 'Jose Mourinho', 'jose@gmail.com', '0123324567'),
(8, 'amalina', '1234', 'amalinazahari', 'amalina@gmail.com', '0123456789'),
(9, 'amalina', '1234', 'amalinazahari', 'amalina@gmail.com', '0123456789');

-- --------------------------------------------------------

--
-- Table structure for table `unclass`
--

CREATE TABLE IF NOT EXISTS `unclass` (
`idunclass` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL,
  `idtutor` int(11) NOT NULL,
  `region` varchar(200) NOT NULL,
  `phone` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `unclass`
--

INSERT INTO `unclass` (`idunclass`, `name`, `description`, `idtutor`, `region`, `phone`) VALUES
(1, 'Programming I', 'Programmers write code to create software programs They return the program designs created by software developers and engineers into instructions that a computer can follow.', 2, 'Perak', '0112233454'),
(2, 'Database I', 'A class about database system and query', 1, 'Perak', '0102233456'),
(3, 'System Administration', 'This is a class on system administration that teaches us to manage system', 1, 'Johor', '0102233456'),
(4, 'Web Programming', 'Design Web', 1, 'Bangi', '0123456789'),
(7, 'Business Intelligence', 'IT', 1, 'Perak', '0123456789');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `class`
--
ALTER TABLE `class`
 ADD PRIMARY KEY (`idclass`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
 ADD PRIMARY KEY (`idstudent`);

--
-- Indexes for table `tutor`
--
ALTER TABLE `tutor`
 ADD PRIMARY KEY (`idtutor`);

--
-- Indexes for table `unclass`
--
ALTER TABLE `unclass`
 ADD PRIMARY KEY (`idunclass`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
MODIFY `idclass` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
MODIFY `idstudent` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tutor`
--
ALTER TABLE `tutor`
MODIFY `idtutor` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `unclass`
--
ALTER TABLE `unclass`
MODIFY `idunclass` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
