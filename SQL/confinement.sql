-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 18, 2017 at 06:21 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `confinement`
--

-- --------------------------------------------------------

--
-- Table structure for table `lady`
--

CREATE TABLE IF NOT EXISTS `lady` (
`idlady` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `address` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lady`
--

INSERT INTO `lady` (`idlady`, `username`, `password`, `name`, `phone`, `address`) VALUES
(1, 'jua', 'jua1234', 'jua khan', '0112929019', 'jalan dua blok 3'),
(7, 'elia', 'elia1234', 'elia salim', '01126530453', 'jalan tengguru'),
(8, 'syahmi', 'syahmi1234', 'syahmi affandy', '0123929201', 'jalan ikram'),
(15, 'syahmi', 'syahmi1234', 'syahmi affandy', '0123929201', 'jalan ikram'),
(16, 'siti', 'siti1234', 'siti aisyah', '12929719', '56 jalan durian'),
(17, 'aminah', 'aminah1234', 'aminah ali', '912891927', 'jalan bakar');

-- --------------------------------------------------------

--
-- Table structure for table `package`
--

CREATE TABLE IF NOT EXISTS `package` (
`idpackage` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL,
  `region` varchar(100) NOT NULL,
  `idlady` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  `phone` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `package`
--

INSERT INTO `package` (`idpackage`, `name`, `description`, `region`, `idlady`, `iduser`, `phone`) VALUES
(1, 'package diamond', 'massage, cooking', 'Perak', 1, 1, '01126530453'),
(2, 'Intimate Package', 'This package only includes a massage service. Special ointment will be included by the Lady. Massage include a whole body massage', 'Kuala Lumpur, WP Kuala Lumpur', 4, 1, '0122233456'),
(3, 'Intimate Package', 'This package only includes a massage service. Special ointment will be included by the Lady. Massage include a whole body massage', 'Kuala Lumpur, WP Kuala Lumpur', 4, 1, '0122233456'),
(4, 'Merdeka Package', 'This is a promotional package that includes all services. Coooking, Massage and taking care of services. Special price will be provided by the lady after negotiations', 'Prai, Penang', 11, 1, '0143321234');

-- --------------------------------------------------------

--
-- Table structure for table `unpackage`
--

CREATE TABLE IF NOT EXISTS `unpackage` (
`idunpackage` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL,
  `region` varchar(100) NOT NULL,
  `idlady` int(11) NOT NULL,
  `phone` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `unpackage`
--

INSERT INTO `unpackage` (`idunpackage`, `name`, `description`, `region`, `idlady`, `phone`) VALUES
(1, 'Diamond Package', 'This package includes cooking, massaging, and taking care all throughout the post pregnancy period', 'Ipoh, Perak', 1, '01126530453'),
(2, 'Gold Package', 'This package only includes cooking and massaging. Cooking will be done on selected variety of menu only', 'Bangi, Selangor', 1, '0123343213'),
(3, 'Platinum Package', 'This package only includes cooking. Cooking will covered for only Malay cuisine. Other cuisine will not be tolerated', 'Kluang, Johor', 1, '0123344212'),
(4, 'Intimate Package', 'This package only includes a massage service. Special ointment will be included by the Lady. Massage include a whole body massage', 'Kuala Lumpur, WP Kuala Lumpur', 4, '0122233456'),
(5, 'Merdeka Package', 'This is a promotional package that includes all services. Coooking, Massage and taking care of services. Special price will be provided by the lady after negotiations', 'Prai, Penang', 11, '0143321234');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
`iduser` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `address` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`iduser`, `username`, `password`, `name`, `phone`, `address`) VALUES
(1, 'nurarifsafwan', 'pass123', 'Nur Arif Safwan Abdullah', '01133445641', 'Street 1. City 2, Province 3, State 4'),
(2, 'piqa', 'piqa1234', 'piqa hamdan', '0123920201', 'jalan siakap'),
(3, 'piqa', 'piqa1234', 'piqa hamdan', '0123920201', 'jalan siakap'),
(4, 'bani', 'bani1234', 'thabarani', '019801830291', 'blok amanah'),
(5, 'riza', 'riza1234', 'riza fitri', '01930910921', 'jalan muamalat'),
(6, 'yaal', 'yaal1234', 'yaalarasi', '0123929291', '34 jalan idris'),
(7, 'ali', 'ali1234', 'ali mohd', '0128392810', '34 jalan murni'),
(8, 'ali', 'ali1234', 'ali mohd', '0128392810', '34 jalan murni');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `lady`
--
ALTER TABLE `lady`
 ADD PRIMARY KEY (`idlady`);

--
-- Indexes for table `package`
--
ALTER TABLE `package`
 ADD PRIMARY KEY (`idpackage`);

--
-- Indexes for table `unpackage`
--
ALTER TABLE `unpackage`
 ADD PRIMARY KEY (`idunpackage`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`iduser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `lady`
--
ALTER TABLE `lady`
MODIFY `idlady` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `package`
--
ALTER TABLE `package`
MODIFY `idpackage` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `unpackage`
--
ALTER TABLE `unpackage`
MODIFY `idunpackage` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
