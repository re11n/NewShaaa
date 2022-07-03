-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 03, 2022 at 08:03 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `newshantika`
--

-- --------------------------------------------------------

--
-- Table structure for table `busdatabase`
--

CREATE TABLE `busdatabase` (
  `NoBus` int(10) NOT NULL,
  `Asal` varchar(50) NOT NULL,
  `Tujuan` varchar(50) NOT NULL,
  `Tanggal` date NOT NULL,
  `Status` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `busdatabase`
--

INSERT INTO `busdatabase` (`NoBus`, `Asal`, `Tujuan`, `Tanggal`, `Status`) VALUES
(1, 'Bandung', 'Jakarta', '2022-06-09', 'Belum Berangkat'),
(2, 'Bandung', 'Surabaya', '2022-06-09', 'Belum Berangkat');

-- --------------------------------------------------------

--
-- Table structure for table `logindatabase`
--

CREATE TABLE `logindatabase` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `no_telp` varchar(15) NOT NULL,
  `adm` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `logindatabase`
--

INSERT INTO `logindatabase` (`id`, `username`, `password`, `nama`, `no_telp`, `adm`) VALUES
(11, 're1n', 'asd', 'Ryan David Siahaan', '0812', 'no'),
(12, 'test', 'test', 'test', '123', 'yes'),
(13, 'zxc', 'zxc', 'asd', 'asd', 'no'),
(14, '123', '123', 'suka suka', 'asd', 'no');

-- --------------------------------------------------------

--
-- Table structure for table `selected`
--

CREATE TABLE `selected` (
  `activeuser` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `selected`
--

INSERT INTO `selected` (`activeuser`) VALUES
('re1n');

-- --------------------------------------------------------

--
-- Table structure for table `tiketdatabase`
--

CREATE TABLE `tiketdatabase` (
  `user` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `no_telp` varchar(50) NOT NULL,
  `bus_dari` varchar(50) NOT NULL,
  `bus_ke` varchar(50) NOT NULL,
  `kursi` int(11) NOT NULL,
  `premium` varchar(10) NOT NULL,
  `id_tiket` int(50) NOT NULL,
  `sudah_bayar` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tiketdatabase`
--

INSERT INTO `tiketdatabase` (`user`, `nama`, `no_telp`, `bus_dari`, `bus_ke`, `kursi`, `premium`, `id_tiket`, `sudah_bayar`) VALUES
('re1n', 'dada', 'dalhf', 'Jakarta', 'Bandung', 12, 'yes', 7, 'yes'),
('re1n', 'agsgag', 'sdhdshhd', 'Surabaya', 'Jakarta', 29, 'yes', 8, 'yes'),
('re1n', 'snjdn', '0812', 'Surabaya', 'Bandung', 21, 'yes', 9, 'yes'),
('re1n', 'afsffa', '0812', 'Tangerang', 'Semarang', 0, 'no', 10, 'no'),
('re1n', 'afsasf', '0812', 'Tangerang', 'Semarang', 4, 'no', 11, 'no'),
('test', 'asasfg', '123', 'Serang', 'Jepara', 13, 'yes', 12, 'no');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `current` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`current`) VALUES
('test');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `busdatabase`
--
ALTER TABLE `busdatabase`
  ADD PRIMARY KEY (`NoBus`);

--
-- Indexes for table `logindatabase`
--
ALTER TABLE `logindatabase`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tiketdatabase`
--
ALTER TABLE `tiketdatabase`
  ADD PRIMARY KEY (`id_tiket`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `busdatabase`
--
ALTER TABLE `busdatabase`
  MODIFY `NoBus` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `logindatabase`
--
ALTER TABLE `logindatabase`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `tiketdatabase`
--
ALTER TABLE `tiketdatabase`
  MODIFY `id_tiket` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
