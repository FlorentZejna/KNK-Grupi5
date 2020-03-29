-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2019 at 12:48 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projektiknk`
--

-- --------------------------------------------------------

--
-- Table structure for table `orari`
--

CREATE TABLE `orari` (
  `id` int(11) NOT NULL,
  `titlenda` varchar(35) DEFAULT NULL,
  `ects` int(11) DEFAULT NULL,
  `profcol` varchar(35) DEFAULT NULL,
  `asscol` varchar(35) DEFAULT NULL,
  `ldita` varchar(35) DEFAULT NULL,
  `lora` varchar(35) DEFAULT NULL,
  `lsalla` int(11) DEFAULT NULL,
  `udita` varchar(35) DEFAULT NULL,
  `uora` varchar(35) DEFAULT NULL,
  `usalla` int(11) DEFAULT NULL,
  `nstud` varchar(35) DEFAULT NULL,
  `departamenti` varchar(35) DEFAULT NULL,
  `sem` varchar(35) DEFAULT NULL,
  `grupi` varchar(35) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orari`
--

INSERT INTO `orari` (`id`, `titlenda`, `ects`, `profcol`, `asscol`, `ldita`, `lora`, `lsalla`, `udita`, `uora`, `usalla`, `nstud`, `departamenti`, `sem`, `grupi`) VALUES
(8, 'Rrjeta Kompjuterike', 5, 'Blerim Rexhaj', 'Haxhi Lajqi', 'E Marte', '08:15 - 09:45', 621, 'E Enjte', '17:00 - 18:30', 625, 'Bachelor', 'Kompjuterike', 'IV', '1'),
(9, 'KNK', 5, 'Isak Shabani', 'Endrit Ilazi', 'E Hene', '13:15 - 14:45', 621, 'E Hene', '17:00 - 18:30', 625, 'Bachelor', 'Kompjuterike', 'IV', '1'),
(10, 'PHP', 5, 'Lule Ahmedi', 'Dardan Shabani', 'E Hene', '08:15 - 09:45', 621, 'E Marte', '12:15 - 13:45', 621, 'Bachelor', 'Kompjuterike', 'IV', '1'),
(11, 'Siguria e te dhenave', 5, 'Blerim Rexhaj', 'Edon Gashi', 'E merkure', '08:15 - 09:45', 621, 'E Hene', '10:00 - 11:30', 615, 'Bachelor', 'Kompjuterike', 'IV', '1'),
(12, 'Menaxhim Projekti', 5, 'Ruzhdi Sefa', 'E zbrazet', 'E Enjte', '13:15 - 14:45', 408, 'E zbrazet', 'E zbrazet', 0, 'Bachelor', 'Kompjuterike', 'IV', '1'),
(13, 'Arkitektura e Kompjutereve', 5, 'Adnan Maxhuni', 'Edon Gashi', 'E Merkure', '12:15 - 13:45', 621, 'E Enjte', '10:00 - 11:30', 615, 'Bachelor', 'Kompjuterike', 'IV', '1');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `emri` varchar(35) NOT NULL,
  `mbiemri` varchar(35) NOT NULL,
  `numriID` bigint(20) NOT NULL,
  `password` varchar(65) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `emri`, `mbiemri`, `numriID`, `password`) VALUES
(1, 'lirim', 'maloku', 160714100069, '827ccb0eea8a706c4c34a16891f84e7b'),
(2, 'admin', 'admin', 1, '63a9f0ea7bb98050796b649e85481845');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `orari`
--
ALTER TABLE `orari`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orari`
--
ALTER TABLE `orari`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
