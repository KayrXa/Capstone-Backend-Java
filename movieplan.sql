-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Počítač: 127.0.0.1
-- Vytvořeno: Úte 29. srp 2023, 22:44
-- Verze serveru: 10.4.28-MariaDB
-- Verze PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databáze: `movieplan`
--
CREATE DATABASE IF NOT EXISTS `movieplan` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `movieplan`;

-- --------------------------------------------------------

--
-- Struktura tabulky `admins`
--

CREATE TABLE `admins` (
  `aid` int(11) NOT NULL COMMENT 'admin ID',
  `adminname` varchar(255) DEFAULT NULL,
  `adminpassword` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `admins`
--

INSERT INTO `admins` (`aid`, `adminname`, `adminpassword`) VALUES
(1, 'admin', 'admin12345');

-- --------------------------------------------------------

--
-- Struktura tabulky `genres`
--

CREATE TABLE `genres` (
  `genre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `genres`
--

INSERT INTO `genres` (`genre`) VALUES
('Animation'),
('Biographic'),
('Comedy'),
('Drama'),
('Fantasy'),
('Horror'),
('Romance'),
('Thriller');

-- --------------------------------------------------------

--
-- Struktura tabulky `items`
--

CREATE TABLE `items` (
  `iid` int(11) NOT NULL COMMENT 'purchased item ID',
  `mid` int(11) NOT NULL COMMENT 'movie ID',
  `amount` int(11) NOT NULL COMMENT 'number of tickets',
  `ticketprice` double NOT NULL,
  `pid` int(11) NOT NULL COMMENT 'purchase ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `items`
--

INSERT INTO `items` (`iid`, `mid`, `amount`, `ticketprice`, `pid`) VALUES
(3, 4, 2, 13, 9),
(4, 5, 2, 10, 9),
(11, 5, 2, 10, 12),
(22, 7, 2, 12, 19),
(23, 8, 2, 12, 19),
(24, 9, 2, 12, 19),
(25, 1, 3, 10, 20),
(26, 7, 1, 12, 21),
(27, 8, 1, 12, 21);

-- --------------------------------------------------------

--
-- Struktura tabulky `languages`
--

CREATE TABLE `languages` (
  `language` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `languages`
--

INSERT INTO `languages` (`language`) VALUES
('CZ'),
('DE'),
('EN'),
('FIL'),
('FR'),
('IT');

-- --------------------------------------------------------

--
-- Struktura tabulky `movies`
--

CREATE TABLE `movies` (
  `mid` int(11) NOT NULL COMMENT 'movie ID',
  `moviename` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `ticketprice` double NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `imageurl` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `moviedate` date NOT NULL COMMENT 'movie date',
  `movietime` varchar(255) DEFAULT NULL,
  `movieenabled` tinyint(1) NOT NULL COMMENT 'movie status (enabled/disabled)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `movies`
--

INSERT INTO `movies` (`mid`, `moviename`, `language`, `ticketprice`, `description`, `imageurl`, `genre`, `moviedate`, `movietime`, `movieenabled`) VALUES
(1, 'NINJA TURTLES', 'EN', 10, 'If they hadn\'t come into contact with the mysterious green slime, they would have been ordinary canal turtles. If they hadn\'t met the mutated rat Master Shard, they wouldn\'t have become martial arts masters and namesakes of legendary Renaissance artists -', 'https://www.cinemacity.cz/xmedia-cw/repo/feats/posters/5725D2R.jpg', 'Animation', '2023-08-08', '14:00', 1),
(2, 'OPPENHEIMER', 'DE', 12, 'At a time when the Second World War still seemed inconclusive, a dramatic battle between the United States and Germany was taking place at a distance to see who would succeed in constructing the atomic bomb first and gain a decisive advantage over the ene', 'https://www.cinemacity.cz/xmedia-cw/repo/feats/posters/5297S2R.jpg', 'Biographic', '2023-08-12', '18:00', 0),
(4, 'The Nun 2', 'CZ', 16, 'The greatest evil from the world of DEMONS CAPTURED is back. 1956 - France. A priest is murdered. Evil is spreading. The sequel to the worldwide hit follows Sister Irena as she once again clashes with the demonic nun Valak.\r\n', 'https://www.cinemacity.cz/xmedia-cw/repo/feats/posters/5852S2R.jpg', 'Horror', '2023-08-09', '22:00', 1),
(7, 'Talk To Me', 'IT', 12, 'A group of friends come across a mysterious mummified hand, which they discover can temporarily connect them to the spirit world if they grasp it and say, \"Talk to me!\". The dangerous toy is becoming the main attraction at parties and generating more and ', 'https://www.cinemacity.cz/xmedia-cw/repo/feats/posters/5808S2R.jpg', 'Horror', '2023-08-04', '19:00', 1),
(8, 'Jawan', 'EN', 12, '', 'https://www.cinemacity.cz/xmedia-cw/repo/feats/posters/5944S2R.jpg', 'Thriller', '2023-08-11', '17:00', 1),
(9, 'Elemental ', 'DE', 12, 'Between the Elements from Disney and Pixar is an all-new, original feature film set in the City of the Elements, where the elements of fire, water, earth and air live together. The film follows the story of Jiskra, a spirited, inventive and passionate you', 'https://www.cinemacity.cz/xmedia-cw/repo/feats/posters/5538D2R.jpg', 'Animation', '2023-08-18', '09:00', 1),
(13, 'Test', 'CZ', 100, 'Just testing', '', 'Biographic', '2023-08-19', '20:00', 1);

-- --------------------------------------------------------

--
-- Struktura tabulky `purchases`
--

CREATE TABLE `purchases` (
  `pid` int(11) NOT NULL COMMENT 'purchase ID',
  `purchasedate` date NOT NULL DEFAULT current_timestamp() COMMENT 'purchase date',
  `createdby` varchar(255) DEFAULT NULL,
  `totalprice` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `purchases`
--

INSERT INTO `purchases` (`pid`, `purchasedate`, `createdby`, `totalprice`) VALUES
(9, '2023-07-29', 'Filcol', 46),
(12, '2023-07-30', 'neconekdo', 20),
(19, '2023-07-31', 'Filcol', 72),
(20, '2023-08-29', 'Antoata', 30),
(21, '2023-08-29', 'Antoata', 24);

-- --------------------------------------------------------

--
-- Struktura tabulky `users`
--

CREATE TABLE `users` (
  `uid` int(11) NOT NULL COMMENT 'user ID',
  `username` varchar(255) DEFAULT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `userpassword` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `users`
--

INSERT INTO `users` (`uid`, `username`, `fname`, `lname`, `email`, `userpassword`) VALUES
(1, 'Filcol', 'Filip', 'Colins', 'Filip.Colins@gmail.com', 'filcol44'),
(2, 'Antoata', 'Anton', 'Atalak', 'alak@gmail.com', 'alak55'),
(3, 'Jauznevim', 'Jau', 'Nevim', 'nevimuz@gmail.com', 'nevim7777'),
(5, 'neconekdo', 'nekdo', 'neco', 'cekdoe@gmail.com', 'kdoce11'),
(6, 'uzkonec', 'Uzasna', 'Amalie', 'Amiuzas@gmail.com', 'ami44'),
(8, 'Filcola', '', '', '', ''),
(9, 'Lemur', '', '', '', '');

--
-- Indexy pro exportované tabulky
--

--
-- Indexy pro tabulku `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`aid`);

--
-- Indexy pro tabulku `genres`
--
ALTER TABLE `genres`
  ADD PRIMARY KEY (`genre`);

--
-- Indexy pro tabulku `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`iid`),
  ADD KEY `items_ibfk_1` (`pid`),
  ADD KEY `mid` (`mid`);

--
-- Indexy pro tabulku `languages`
--
ALTER TABLE `languages`
  ADD PRIMARY KEY (`language`);

--
-- Indexy pro tabulku `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`mid`);

--
-- Indexy pro tabulku `purchases`
--
ALTER TABLE `purchases`
  ADD PRIMARY KEY (`pid`);

--
-- Indexy pro tabulku `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT pro tabulky
--

--
-- AUTO_INCREMENT pro tabulku `admins`
--
ALTER TABLE `admins`
  MODIFY `aid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'admin ID', AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pro tabulku `items`
--
ALTER TABLE `items`
  MODIFY `iid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'purchased item ID', AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT pro tabulku `movies`
--
ALTER TABLE `movies`
  MODIFY `mid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'movie ID', AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pro tabulku `purchases`
--
ALTER TABLE `purchases`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'purchase ID', AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT pro tabulku `users`
--
ALTER TABLE `users`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'user ID', AUTO_INCREMENT=10;

--
-- Omezení pro exportované tabulky
--

--
-- Omezení pro tabulku `items`
--
ALTER TABLE `items`
  ADD CONSTRAINT `items_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `purchases` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
