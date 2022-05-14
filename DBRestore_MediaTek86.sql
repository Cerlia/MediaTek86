-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 12 mai 2022 à 13:27
-- Version du serveur : 8.0.27
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `mediatek86`
--
CREATE DATABASE IF NOT EXISTS `mediatek86` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
CREATE USER 'mtmanager'@'%' IDENTIFIED BY 'Aga,Ajtp86';
GRANT USAGE ON *.* TO 'mtmanager'@'%';
GRANT ALL PRIVILEGES ON `mediatek86`.* TO 'mtmanager'@'%';
USE `mediatek86`;

-- --------------------------------------------------------

--
-- Structure de la table `absence`
--

DROP TABLE IF EXISTS `absence`;
CREATE TABLE IF NOT EXISTS `absence` (
  `idpersonnel` int NOT NULL,
  `datedebut` date NOT NULL,
  `idmotif` int NOT NULL,
  `datefin` date DEFAULT NULL,
  PRIMARY KEY (`idpersonnel`,`datedebut`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `absence`
--

INSERT INTO `absence` (`idpersonnel`, `datedebut`, `idmotif`, `datefin`) VALUES
(1, '2019-03-12', 4, '2019-04-03'),
(1, '2020-07-08', 2, '2020-08-11'),
(2, '2019-09-30', 1, '2019-10-23'),
(2, '2020-04-27', 3, '2020-04-28'),
(2, '2020-06-04', 1, '2020-06-24'),
(2, '2020-08-06', 2, '2020-08-18'),
(2, '2021-03-02', 2, '2021-03-04'),
(2, '2022-01-21', 3, '2022-01-24'),
(2, '2022-03-27', 2, '2022-04-15'),
(4, '2018-05-01', 4, '2018-10-12'),
(4, '2019-01-14', 1, '2019-01-18'),
(4, '2020-02-03', 3, '2020-02-05'),
(4, '2021-03-08', 3, '2021-03-11'),
(4, '2022-01-01', 2, '2022-01-06'),
(4, '2022-01-24', 1, '2022-01-26'),
(5, '2019-02-20', 4, '2019-11-09'),
(5, '2022-02-21', 1, '2022-02-26'),
(5, '2022-04-15', 3, '2022-04-16'),
(5, '2022-05-04', 3, '2022-05-05'),
(6, '2019-05-28', 1, '2019-06-12'),
(6, '2020-03-13', 1, '2020-03-25'),
(6, '2020-11-20', 2, '2020-11-26'),
(6, '2021-12-04', 3, '2021-12-06'),
(6, '2022-01-29', 4, '2022-04-08'),
(6, '2022-05-02', 2, '2022-05-05'),
(7, '2019-08-16', 1, '2019-09-09'),
(7, '2020-07-24', 3, '2020-07-25'),
(7, '2020-08-03', 4, '2020-10-30'),
(7, '2020-12-09', 2, '2020-12-11'),
(7, '2021-06-27', 2, '2021-07-15'),
(7, '2021-11-22', 4, '2021-12-10'),
(8, '2019-03-05', 1, '2019-03-08'),
(8, '2019-05-08', 4, '2021-01-19'),
(8, '2020-03-10', 1, '2020-04-03'),
(8, '2020-08-03', 1, '2020-08-21'),
(8, '2020-12-14', 3, '2020-12-16'),
(8, '2021-05-09', 4, '2021-08-13'),
(8, '2021-08-23', 1, '2021-09-03'),
(8, '2021-10-21', 1, '2021-10-27'),
(9, '2019-02-21', 4, '2019-02-26'),
(9, '2019-03-11', 3, '2019-03-13'),
(9, '2020-11-30', 3, '2020-12-01'),
(9, '2021-08-17', 2, '2021-09-05'),
(9, '2021-10-11', 1, '2021-10-15'),
(9, '2022-01-10', 1, '2022-01-18'),
(9, '2022-02-03', 3, '2023-02-03'),
(10, '2019-06-24', 2, '2019-06-26'),
(12, '2019-10-11', 2, '2019-10-17'),
(12, '2020-05-04', 1, '2020-05-15'),
(12, '2021-06-15', 4, '2021-09-30'),
(12, '2022-02-17', 2, '2022-02-19'),
(12, '2022-05-02', 1, '2022-05-05');

-- --------------------------------------------------------

--
-- Structure de la table `motif`
--

DROP TABLE IF EXISTS `motif`;
CREATE TABLE IF NOT EXISTS `motif` (
  `idmotif` int NOT NULL AUTO_INCREMENT,
  `libelle` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idmotif`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `motif`
--

INSERT INTO `motif` (`idmotif`, `libelle`) VALUES
(1, 'vacances'),
(2, 'maladie'),
(3, 'motif familial'),
(4, 'congé parental');

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

DROP TABLE IF EXISTS `personnel`;
CREATE TABLE IF NOT EXISTS `personnel` (
  `idpersonnel` int NOT NULL AUTO_INCREMENT,
  `idservice` int NOT NULL,
  `nom` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prenom` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tel` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mail` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idpersonnel`),
  KEY `FK_personnel_service` (`idservice`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `personnel`
--

INSERT INTO `personnel` (`idpersonnel`, `idservice`, `nom`, `prenom`, `tel`, `mail`) VALUES
(1, 1, 'Leloup', 'Georges', '02 03 22 52 56', 'g.leloup@gmail.com'),
(2, 1, 'Cooper', 'Daffney', '06 25 44 58 55', 'enim.lo@aol.edu'),
(4, 3, 'Blackwell', 'Erica', '04 66 71 58 89', 'neque.sed@hotmail.net'),
(5, 1, 'McCullough', 'Maggie', '06 18 25 79 63', 'eu.enim@aol.edu'),
(6, 1, 'Williamson', 'Haviva', '03 29 16 23 21', 'purus.ac@icloud.org'),
(7, 3, 'Goodman', 'Hilda', '02 61 58 03 02', 'mauris.integer.sem@google.com'),
(8, 2, 'Dice', 'Joséphine', '02 24 61 88 91', 'enim@hotmail.couk'),
(9, 3, 'Duffy', 'Danielle', '06 47 00 81 30', 'amet@protonmail.couk'),
(10, 1, 'Burch', 'Ezrah', '02 16 04 05 32', 'proin@outlook.net'),
(12, 1, 'Bennett', 'Vanessa', '02 02 01 02 02', 'vbennett@aol.gr');

-- --------------------------------------------------------

--
-- Structure de la table `responsable`
--

DROP TABLE IF EXISTS `responsable`;
CREATE TABLE IF NOT EXISTS `responsable` (
  `login` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `pwd` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`login`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `responsable`
--

INSERT INTO `responsable` (`login`, `pwd`) VALUES
('StaCla', '206b96a69fe2f822e973e36054bb71eb516bce7d8ad3c40c90678154362cdb24');

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE IF NOT EXISTS `service` (
  `idservice` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idservice`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `service`
--

INSERT INTO `service` (`idservice`, `nom`) VALUES
(1, 'administratif'),
(2, 'médiation culturelle'),
(3, 'prêt');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `personnel`
--
ALTER TABLE `personnel`
  ADD CONSTRAINT `personnel_ibfk_1` FOREIGN KEY (`idservice`) REFERENCES `service` (`idservice`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
