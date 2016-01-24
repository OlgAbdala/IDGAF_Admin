-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost:8889
-- Généré le :  Dim 24 Janvier 2016 à 12:11
-- Version du serveur :  5.5.42
-- Version de PHP :  5.6.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `soa_administration`
--

-- --------------------------------------------------------

--
-- Structure de la table `Administrators`
--

CREATE TABLE `Administrators` (
  `ID` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Administrators`
--

INSERT INTO `Administrators` (`ID`, `login`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `Requests`
--

CREATE TABLE `Requests` (
  `ID` int(11) NOT NULL,
  `companyID` int(11) NOT NULL,
  `studentID` int(11) NOT NULL,
  `internshipID` int(11) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Requests`
--

INSERT INTO `Requests` (`ID`, `companyID`, `studentID`, `internshipID`, `status`) VALUES
(1, 1, 1, 1, 'APPLICATION_SENT_TO_COMPANY'),
(10, 1, 1, 1, 'ACCEPTED_BY_COMPANY'),
(11, 1, 1, 1, 'ACCEPTED_BY_COMPANY');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Administrators`
--
ALTER TABLE `Administrators`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `Requests`
--
ALTER TABLE `Requests`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Administrators`
--
ALTER TABLE `Administrators`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `Requests`
--
ALTER TABLE `Requests`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
