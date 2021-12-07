-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 09, 2020 at 08:19 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `attd_mng_sys`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `Aid` int(11) NOT NULL,
  `Stime` timestamp(6) NULL DEFAULT NULL,
  `Etime` timestamp(6) NULL DEFAULT NULL,
  `PID` varchar(20) NOT NULL,
  `Suid` int(11) NOT NULL,
  `Status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`Aid`, `Stime`, `Etime`, `PID`, `Suid`, `Status`) VALUES
(1, '2019-10-25 03:30:00.000000', '2019-10-25 04:30:00.000000', '182009', 1, 1),
(2, '2019-10-25 03:30:00.000000', '2019-10-25 04:30:00.000000', '182007', 1, 0),
(3, '2019-10-24 04:30:00.000000', '2019-10-24 05:30:00.000000', '182007', 2, 1),
(4, '2019-10-24 04:30:00.000000', '2019-10-24 05:30:00.000000', '182009', 2, 0),
(6, '2019-10-25 05:30:00.000000', '2019-10-25 06:30:00.000000', '182007', 1, 1),
(7, '2019-10-25 05:30:00.000000', '2019-10-25 06:30:00.000000', '182007', 1, 1),
(8, '2019-10-29 03:30:00.000000', '2019-10-29 04:30:00.000000', '182010', 2, 1),
(9, '2019-10-29 03:30:00.000000', '2019-10-29 04:30:00.000000', '182010', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `PID` varchar(20) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`PID`, `Name`, `Password`) VALUES
('182001', 'Someone', '12345'),
('182007', 'Mru', '12'),
('182009', 'Alm', '123'),
('182010', 'Ne', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `Suid` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`Suid`, `Name`) VALUES
(1, 'DLDA'),
(2, 'AM'),
(3, 'DIM');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `PID` varchar(20) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`PID`, `Name`, `Password`) VALUES
('162071', 'Priya', '123'),
('162073', 'Sweedal', '123'),
('162076', 'Tejal', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`Aid`),
  ADD KEY `PID` (`PID`),
  ADD KEY `Suid` (`Suid`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`PID`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`Suid`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`PID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `Aid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `Suid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`PID`) REFERENCES `student` (`PID`),
  ADD CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`Suid`) REFERENCES `subject` (`Suid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
