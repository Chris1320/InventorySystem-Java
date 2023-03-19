-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Mar 19, 2023 at 02:58 PM
-- Server version: 8.0.32
-- PHP Version: 8.1.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `InventorySystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `departments`
--

CREATE TABLE `departments` (
  `Dept_ID` varchar(50) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `departments`
--

INSERT INTO `departments` (`Dept_ID`) VALUES
('Administration'),
('Background Staff'),
('Sales');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `Employee_ID` int NOT NULL,
  `First_Name` varchar(25) COLLATE utf8mb4_general_ci NOT NULL,
  `Middle_Name` varchar(25) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Last_Name` varchar(25) COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(25) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(57) COLLATE utf8mb4_general_ci NOT NULL,
  `Department` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `is_admin` tinyint(1) NOT NULL,
  `image` longblob,
  `is_active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`Employee_ID`, `First_Name`, `Middle_Name`, `Last_Name`, `username`, `password`, `Department`, `is_admin`, `image`, `is_active`) VALUES
(1, 'admin', '', 'admin', 'admin', 'enl14V9EYt7GTJ9vueUIJg==|MSxYHq7CFvZLqV26M4eebQ==', 'Administration', 1, NULL, 1);
INSERT INTO `employees` (`Employee_ID`, `First_Name`, `Middle_Name`, `Last_Name`, `username`, `password`, `Department`, `is_admin`, `image`, `is_active`) VALUES
INSERT INTO `employees` (`Employee_ID`, `First_Name`, `Middle_Name`, `Last_Name`, `username`, `password`, `Department`, `is_admin`, `image`, `is_active`) VALUES
(3, 'test', 'a', 'twa', 'test', 'qmadlxf1nTEpPq/p5yX1cQ==|GlwkPSuhLdYhv4RKXH40xQ==', 'Background Staff', 0, NULL, 0),
(4, 'John', 'F', 'Doe', 'johndoe', 'pOHye05pwyy8TOSNH3g8fA==|iRan/BkUaJWFu71i6AZFLA==', 'Background Staff', 0, NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `Item_code` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `Name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `Description` text COLLATE utf8mb4_general_ci,
  `Stocks` int NOT NULL,
  `Price` double NOT NULL,
  `archived` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`Item_code`, `Name`, `Description`, `Stocks`, `Price`, `archived`) VALUES
('BK8783', 'GARDENIA SLICE BREAD', 'BREAD', 50, 45, 0),
('CC01', 'COCA COLA', 'SOFT DRINKS', 233, 65, 0),
('CC02', 'Coco Cala', 'Off-the-shelf softdrink', 14, 24.75, 1),
('DA97', 'DAIRY MILK CADBURY', 'CHOCOLATE', 109, 155, 0),
('HRT3562', 'HURST', 'TOMATO SAUCE', 45, 65, 0),
('RAM106', 'Avexir 8GB DDR RAM', 'Computer stuff', 5, 2499.99, 0),
('V71', 'AllPhone V71', 'An all-purpose smartphone', 23, 6499.75, 0),
('VCUTB', 'VCUT', 'CHIPS', 35, 15, 0),
('VN8', 'DATU PUTI VINEGAR', 'VINEGAR', 69, 35, 0);

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `Transaction_Date` timestamp NOT NULL,
  `Employee_ID` int NOT NULL,
  `Item_code` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `action` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Quantity` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`Transaction_Date`, `Employee_ID`, `Item_code`, `action`, `Quantity`) VALUES
('2023-03-19 14:16:53', 2, 'CC02', 'REMOVE', 14),
('2023-03-19 14:27:21', 2, 'RAM106', 'ADD', 6),
('2023-03-19 14:27:53', 2, 'RAM106', 'SET', 3),
('2023-03-19 14:28:36', 1, 'RAM106', 'SELL', -2),
('2023-03-19 14:31:03', 1, 'RAM106', 'SELL', -1),
('2023-03-19 14:31:41', 1, 'RAM106', 'SET', 5),
('2023-03-19 14:44:21', 2, 'V71', 'ADD', 25),
('2023-03-19 14:44:59', 2, 'V71', 'SET', 23),
('2023-03-19 14:55:11', 4, 'CC01', 'SELL', -17);

-- --------------------------------------------------------

--
-- Table structure for table `transaction_actions`
--

CREATE TABLE `transaction_actions` (
  `action` varchar(10) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaction_actions`
--

INSERT INTO `transaction_actions` (`action`) VALUES
('ADD'),
('REMOVE'),
('SELL'),
('SET');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `departments`
--
ALTER TABLE `departments`
  ADD PRIMARY KEY (`Dept_ID`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`Employee_ID`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `employees_Department_departments_Dept_ID` (`Department`);

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`Item_code`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`Transaction_Date`),
  ADD KEY `employee_fk` (`Employee_ID`),
  ADD KEY `item_fk` (`Item_code`),
  ADD KEY `action_fk` (`action`);

--
-- Indexes for table `transaction_actions`
--
ALTER TABLE `transaction_actions`
  ADD PRIMARY KEY (`action`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `Employee_ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `employees_Department_departments_Dept_ID` FOREIGN KEY (`Department`) REFERENCES `departments` (`Dept_ID`);

--
-- Constraints for table `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `action_fk` FOREIGN KEY (`action`) REFERENCES `transaction_actions` (`action`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `employee_fk` FOREIGN KEY (`Employee_ID`) REFERENCES `employees` (`Employee_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `item_fk` FOREIGN KEY (`Item_code`) REFERENCES `items` (`Item_code`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;