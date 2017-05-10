-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2016-11-15 04:06:41
-- 服务器版本： 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project`
--

-- --------------------------------------------------------

--
-- 表的结构 `administrator`
--

CREATE TABLE `administrator` (
  `admin_name` varchar(10) NOT NULL,
  `admin_password` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `administrator`
--

INSERT INTO `administrator` (`admin_name`, `admin_password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- 表的结构 `businesscustomer`
--

CREATE TABLE `businesscustomer` (
  `username` varchar(20) NOT NULL,
  `userpassword` varchar(30) DEFAULT NULL,
  `company_name` varchar(30) DEFAULT NULL,
  `street` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `zipcode` varchar(10) DEFAULT NULL,
  `business_category` varchar(10) DEFAULT NULL,
  `company_income` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `businesscustomer`
--

INSERT INTO `businesscustomer` (`username`, `userpassword`, `company_name`, `street`, `city`, `state`, `zipcode`, `business_category`, `company_income`) VALUES
('firstcompany', '123456', 'firstcompany', 'Fifth', 'Pittsburgh', 'PA', '15001', 'IT', 2000000),
('secondcompany', '654321', ' secondcompany ', 'Fifth', 'Pittsburgh', 'PA', '15001', 'Media', 500000);

-- --------------------------------------------------------

--
-- 表的结构 `contactus`
--

CREATE TABLE `contactus` (
  `username` varchar(10) NOT NULL,
  `firstname` varchar(10) DEFAULT NULL,
  `lastname` varchar(10) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `message` varchar(150) DEFAULT NULL,
  `message_date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `customer`
--

CREATE TABLE `customer` (
  `customerID` varchar(20) NOT NULL,
  `firstname` varchar(10) DEFAULT NULL,
  `lastname` varchar(10) DEFAULT NULL,
  `street` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `zipcode` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `customer`
--

INSERT INTO `customer` (`customerID`, `firstname`, `lastname`, `street`, `city`, `state`, `zipcode`) VALUES
('10001', 'Bob', 'Walk', 'Fifth', 'Pittsburgh', 'PA', '15001'),
('10002', 'David', 'White', 'Sixth', 'Pittsburgh', 'PA', '15012');

-- --------------------------------------------------------

--
-- 表的结构 `homecustomer`
--

CREATE TABLE `homecustomer` (
  `username` varchar(20) NOT NULL,
  `userpassword` varchar(30) DEFAULT NULL,
  `firstname` varchar(10) DEFAULT NULL,
  `lastname` varchar(10) DEFAULT NULL,
  `street` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `zipcode` varchar(10) DEFAULT NULL,
  `marriage_status` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `income` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `homecustomer`
--

INSERT INTO `homecustomer` (`username`, `userpassword`, `firstname`, `lastname`, `street`, `city`, `state`, `zipcode`, `marriage_status`, `gender`, `age`, `income`) VALUES
('10002', '123123', 'David', 'White', 'Sixth', 'Pittsburgh', 'PA', '15012', 'married', 'male', 38, 50000),
('10004', '321321', 'Casey', 'Green', 'Forbes', 'Pittsburgh', 'PA', '15052', 'unmarried', 'female', 21, 18000);

-- --------------------------------------------------------

--
-- 表的结构 `orders`
--

CREATE TABLE `orders` (
  `orderID` varchar(10) NOT NULL,
  `customer` varchar(20) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `total` double DEFAULT NULL,
  `shipping_address` varchar(80) DEFAULT NULL,
  `card_details` varchar(40) DEFAULT NULL,
  `shipping_method` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `products`
--

CREATE TABLE `products` (
  `productID` varchar(10) NOT NULL,
  `product_name` varchar(10) DEFAULT NULL,
  `inventory_amount` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `brand` varchar(20) DEFAULT NULL,
  `product_description` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `products`
--

INSERT INTO `products` (`productID`, `product_name`, `inventory_amount`, `price`, `brand`, `product_description`) VALUES
('001', 'iphone4', 20, 300, 'Apple', 'This is a phone from Apple'),
('002', 'Galaxy3', 50, 200, 'Samsung', 'This is a phone from Samsung');

-- --------------------------------------------------------

--
-- 表的结构 `region`
--

CREATE TABLE `region` (
  `regionID` varchar(10) NOT NULL,
  `region_name` varchar(20) DEFAULT NULL,
  `region_manager` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `salesperson`
--

CREATE TABLE `salesperson` (
  `sales_username` varchar(10) NOT NULL,
  `sales_password` varchar(30) DEFAULT NULL,
  `sales_name` varchar(15) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `job_title` varchar(15) DEFAULT NULL,
  `store_assigned` varchar(10) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `salesperson`
--

INSERT INTO `salesperson` (`sales_username`, `sales_password`, `sales_name`, `address`, `email`, `job_title`, `store_assigned`, `salary`) VALUES
('001', '123123', 'Joey', 'Penn', 'joey@gmail.com', 'salesman', '01', 1200),
('002', '123123', 'Pheobe', 'Penn', 'Pheobe@gmail.com', 'manager', '01', 1800),
('003', '123123', 'Monica', 'Penn', 'monica@gmail.com', 'region manager', '01', 2500),
('004', '123123', 'Rachel', 'Centre', 'rachel@gmail.com', 'salesman', '02', 1300);

-- --------------------------------------------------------

--
-- 表的结构 `shoppingcart`
--

CREATE TABLE `shoppingcart` (
  `productID` varchar(10) NOT NULL,
  `product_name` varchar(10) DEFAULT NULL,
  `customerID` varchar(20) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `store`
--

CREATE TABLE `store` (
  `storeID` varchar(10) NOT NULL,
  `address` varchar(20) DEFAULT NULL,
  `manager` varchar(10) DEFAULT NULL,
  `num_of_salespersons` int(11) DEFAULT NULL,
  `region` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `store`
--

INSERT INTO `store` (`storeID`, `address`, `manager`, `num_of_salespersons`, `region`) VALUES
('01', 'Penn', 'Pheobe', 8, 'shadyside'),
('02', 'Centre', NULL, 12, 'shadyside');

-- --------------------------------------------------------

--
-- 表的结构 `transaction`
--

CREATE TABLE `transaction` (
  `orderID` varchar(10) NOT NULL,
  `productID` varchar(10) NOT NULL,
  `salesperson` varchar(10) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `customer` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`admin_name`);

--
-- Indexes for table `businesscustomer`
--
ALTER TABLE `businesscustomer`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `contactus`
--
ALTER TABLE `contactus`
  ADD PRIMARY KEY (`username`,`message_date`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerID`);

--
-- Indexes for table `homecustomer`
--
ALTER TABLE `homecustomer`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`orderID`),
  ADD KEY `customer` (`customer`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`productID`);

--
-- Indexes for table `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`regionID`),
  ADD KEY `region_manager` (`region_manager`);

--
-- Indexes for table `salesperson`
--
ALTER TABLE `salesperson`
  ADD PRIMARY KEY (`sales_username`),
  ADD KEY `store_assigned` (`store_assigned`);

--
-- Indexes for table `shoppingcart`
--
ALTER TABLE `shoppingcart`
  ADD PRIMARY KEY (`customerID`,`productID`),
  ADD KEY `productID` (`productID`);

--
-- Indexes for table `store`
--
ALTER TABLE `store`
  ADD PRIMARY KEY (`storeID`),
  ADD KEY `manager` (`manager`),
  ADD KEY `region` (`region`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`orderID`,`productID`),
  ADD KEY `productID` (`productID`),
  ADD KEY `salesperson` (`salesperson`),
  ADD KEY `customer` (`customer`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
