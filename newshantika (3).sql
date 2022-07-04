-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 04, 2022 at 07:44 AM
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
  `tipe` varchar(50) NOT NULL,
  `Status` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `busdatabase`
--

INSERT INTO `busdatabase` (`NoBus`, `Asal`, `Tujuan`, `Tanggal`, `tipe`, `Status`) VALUES
(12, 'Jakarta', 'Jepara', '2022-07-14', 'Executive', 'Belum Berangkat'),
(77, 'Jakarta', 'Semarang', '2022-07-25', 'Super Executive', 'Belum Berangkat'),
(112, 'Tangerang', 'Semarang', '2022-07-27', 'Executive', 'Belum Berangkat');

-- --------------------------------------------------------

--
-- Table structure for table `hargadatabase`
--

CREATE TABLE `hargadatabase` (
  `asal_bus` varchar(50) NOT NULL,
  `ke_bus` varchar(50) NOT NULL,
  `tipe` varchar(20) NOT NULL,
  `harga` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hargadatabase`
--

INSERT INTO `hargadatabase` (`asal_bus`, `ke_bus`, `tipe`, `harga`) VALUES
('Tangerang', 'Semarang', 'Executive', 220000),
('Jakarta', 'Semarang', 'Executive', 210000),
('Jakarta', 'Semarang', 'Royal Big Top', 230000),
('Jakarta', 'Semarang', 'Super Executive', 250000),
('Jakarta', 'Jepara', 'Executive', 210000),
('Jakarta', 'Jepara', 'Royal Big Top', 230000),
('Jakarta', 'Jepara', 'Super Executive', 250000),
('Tangerang', 'Kudus', 'Executive', 220000),
('Tangerang', 'Jepara', 'Executive', 220000),
('Bekasi', 'Semarang', 'Executive', 210000),
('Bekasi', 'Semarang', 'Royal Big Top', 230000),
('Bekasi', 'Semarang', 'Super Executive', 250000),
('Bekasi', 'Kudus', 'Executive', 210000),
('Bekasi', 'Kudus', 'Royal Big Top', 230000),
('Bekasi', 'Kudus', 'Super Executive', 250000),
('Bekasi', 'Jepara', 'Executive', 210000),
('Bekasi', 'Jepara', 'Royal Big Top', 230000),
('Bekasi', 'Jepara', 'Super Executive', 250000),
('Bogor', 'Semarang', 'Executive', 220000),
('Bogor', 'Kudus', 'Executive', 220000),
('Bogor', 'Jepara', 'Executive', 220000),
('Serang', 'Semarang', 'Executive', 250000),
('Serang', 'Kudus', 'Executive', 250000),
('Serang', 'Jepara', 'Executive', 250000),
('Merak', 'Serang', 'Executive', 250000),
('Merak', 'Jepara', 'Executive', 250000),
('Cilegon', 'Semarang', 'Executive', 250000),
('Cilegon', 'Kudus', 'Executive', 250000),
('Cilegon', 'Jepara', 'Executive', 250000),
('Bandung', 'Semarang', 'Executive', 250000),
('Bandung', 'Kudus', 'Executive', 250000),
('Bandung', 'Jepara', 'Executive', 250000),
('Pulo Gading', 'Jepara', 'Executive', 190000),
('Semarang', 'Jakarta', 'Executive', 210000),
('Semarang', 'Jakarta', 'Royal Big Top', 230000),
('Semarang', 'Jakarta', 'Super Executive', 250000),
('Jepara', 'Jakarta', 'Executive', 210000),
('Jepara', 'Jakarta', 'Royal Big Top', 230000),
('Jepara', 'Jakarta', 'Super Executive', 250000),
('Semarang', 'Tangerang', 'Executive', 220000),
('Kudus', 'Tangerang', 'Executive', 220000),
('Jepara', 'Tangerang', 'Executive', 220000),
('Jepara', 'Bekasi', 'Executive', 210000),
(' Kudus', 'Bekasi', 'Executive', 210000),
('Semarang', 'Bekasi', 'Executive', 210000),
('Jepara', 'Bekasi', 'Royal Big Top', 230000),
(' Kudus', 'Bekasi', 'Royal Big Top', 230000),
('Semarang', 'Bekasi', 'Royal Big Top', 230000),
('Semarang', 'Bekasi', 'Super Executive', 250000),
('Kudus', 'Bekasi', 'Super Executive', 250000),
('Jepara', 'Bekasi', 'Super Executive', 250000),
('Jepara', 'Bogor', 'Executive', 220000),
('Kudus', 'Bogor', 'Executive', 220000),
('Semarang', 'Bogor', 'Executive', 220000),
('Jepara', 'Serang ', 'Executive', 250000),
('Kudus', 'Serang ', 'Executive', 250000),
('Semarang', 'Serang ', 'Executive', 250000),
('Jepara', 'Merak', 'Executive', 250000),
('Kudus', 'Merak', 'Executive', 250000),
('Jepara', 'Cilegon', 'Executive', 250000),
('Kudus', 'Cilegon', 'Executive', 250000),
('Semarang', 'Cilegon', 'Executive', 250000);

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
('123');

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
  `tipe` varchar(50) NOT NULL,
  `premium` varchar(10) NOT NULL,
  `id_tiket` int(50) NOT NULL,
  `sudah_bayar` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tiketdatabase`
--

INSERT INTO `tiketdatabase` (`user`, `nama`, `no_telp`, `bus_dari`, `bus_ke`, `kursi`, `tipe`, `premium`, `id_tiket`, `sudah_bayar`) VALUES
('test', 'asasfg', '123', 'Serang', 'Jepara', 13, '0', 'yes', 12, 'no'),
('re1n', 'tyuet ', 'asfasf', 'Jakarta', 'Semarang', 31, 'Super Executive', 'yes', 14, 'yes'),
('re1n', 'ashhiap', '1244', 'Tangerang', 'Semarang', 32, 'Executive', 'yes', 15, 'yes'),
('re1n', 'djj jgj', '724724', 'Jakarta', 'Semarang', 8, 'Super Executive', 'yes', 16, 'no');

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
('re1n');

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
-- AUTO_INCREMENT for table `logindatabase`
--
ALTER TABLE `logindatabase`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `tiketdatabase`
--
ALTER TABLE `tiketdatabase`
  MODIFY `id_tiket` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
