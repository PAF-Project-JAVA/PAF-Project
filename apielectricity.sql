-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2022 at 02:29 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `apielectricity`
--

-- --------------------------------------------------------

--
-- Table structure for table `billing`
--

CREATE TABLE IF NOT EXISTS `billing` (
  `Bid` int(6) NOT NULL AUTO_INCREMENT,
  `B_date` varchar(50) NOT NULL,
  `B_account` varchar(50) NOT NULL,
  `B_units` varchar(50) NOT NULL,
  `B_total` varchar(60) NOT NULL,
  PRIMARY KEY (`Bid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `inqmg`
--

CREATE TABLE IF NOT EXISTS `inqmg` (
  `inqID` int(6) NOT NULL AUTO_INCREMENT,
  `CustomerName` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Date` varchar(10) NOT NULL,
  `Reason` varchar(10) NOT NULL,
  PRIMARY KEY (`inqID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `paymg`
--

CREATE TABLE IF NOT EXISTS `paymg` (
  `pay_id` int(6) NOT NULL AUTO_INCREMENT,
  `Pay_customer_ame` varchar(100) NOT NULL,
  `Pay_acc` varchar(30) NOT NULL,
  `Pay_date` varchar(40) NOT NULL,
  `Pay_total_price` varchar(20) NOT NULL,
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Table structure for table `usermg`
--

CREATE TABLE IF NOT EXISTS `usermg` (
  `uID` int(4) NOT NULL AUTO_INCREMENT,
  `uName` varchar(50) NOT NULL,
  `uAddress` varchar(50) NOT NULL,
  `uEmail` varchar(50) NOT NULL,
  `uNIC` varchar(15) NOT NULL,
  `uPhoneNo` varchar(10) NOT NULL,
  PRIMARY KEY (`uID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
