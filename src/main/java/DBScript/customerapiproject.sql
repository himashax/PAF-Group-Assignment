-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2021 at 06:47 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `customerapiproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `name` varchar(60) NOT NULL,
  `address` varchar(60) NOT NULL,
  `phoneno` int(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `occupation` varchar(30) NOT NULL,
  `needproduct` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name`, `address`, `phoneno`, `email`, `occupation`, `needproduct`) VALUES
(1, 'kavindu', 'kelaniya', 123478666, 'kavindu@gmaila.com', 'manager', 'websystem'),
(2, 'udara', 'horana', 94771156, 'kavindu@gmaila.com', 'manager', 'websystem'),
(4, 'pasindu', 'nugegoda', 94771156, 'kavindu@gmaila.com', 'manager', 'websystem'),
(6, 'kasun', 'aggona', 12345, 'sandamali@gmaila.com', 'mdsdsd', 'websystem'),
(7, 'mandakini', 'nugegoda', 94771156, 'kavindu@gmaila.com', 'manager', 'websystem'),
(10, 'sunimal', 'papiliyane', 12121212, 'sunimal@gmaila.com', 'manager', 'websystem'),
(11, 'pawan', 'papiliyane', 878878, 'sunimal@gmaila.com', 'manager', 'websystem'),
(12, 'pawan', 'papiliyane', 878878, 'sunimal@gmaila.com', 'manager', 'websystem');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
