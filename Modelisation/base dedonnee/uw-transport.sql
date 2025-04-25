-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 22 avr. 2025 à 05:26
-- Version du serveur : 8.3.0
-- Version de PHP : 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `uw-transport`
--

-- --------------------------------------------------------

--
-- Structure de la table `chaufeur`
--

DROP TABLE IF EXISTS `chaufeur`;
CREATE TABLE IF NOT EXISTS `chaufeur` (
  `id_chaufeur` int NOT NULL AUTO_INCREMENT,
  `nom_chaufeur` varchar(20) NOT NULL,
  `prenonm_chaufeur` varchar(40) NOT NULL,
  `email_chaufeur` varchar(45) NOT NULL,
  `telephone_chaufeur` varchar(40) NOT NULL,
  `permi_conduire` varchar(45) NOT NULL,
  PRIMARY KEY (`id_chaufeur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id_client` int NOT NULL AUTO_INCREMENT,
  `nom_client` varchar(100) NOT NULL,
  `prenom_client` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `telephone_client` varchar(50) NOT NULL,
  `email_client` varchar(50) NOT NULL,
  PRIMARY KEY (`id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `exercer`
--

DROP TABLE IF EXISTS `exercer`;
CREATE TABLE IF NOT EXISTS `exercer` (
  `id_exercer` int NOT NULL AUTO_INCREMENT,
  `date_debut` varchar(50) NOT NULL,
  `matricule` varchar(100) NOT NULL,
  `id_role` int NOT NULL,
  PRIMARY KEY (`id_exercer`),
  KEY `matricule` (`matricule`),
  KEY `id_role` (`id_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id_reservation` int NOT NULL AUTO_INCREMENT,
  `date_reservation` date NOT NULL,
  `nom_place` varchar(20) NOT NULL,
  `id_voyage` int NOT NULL,
  `id_client` int NOT NULL,
  `matricule` varchar(100) NOT NULL,
  PRIMARY KEY (`id_reservation`),
  KEY `id_voyage` (`id_voyage`),
  KEY `id_client` (`id_client`),
  KEY `matricule` (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id_role` int NOT NULL AUTO_INCREMENT,
  `nom_role` varchar(100) NOT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
CREATE TABLE IF NOT EXISTS `ticket` (
  `id_ticket` int NOT NULL AUTO_INCREMENT,
  `numero_ticket` varchar(100) NOT NULL,
  `date_emission` date NOT NULL,
  `id_client` int NOT NULL,
  `id_reservation` int NOT NULL,
  PRIMARY KEY (`id_ticket`),
  KEY `id_client` (`id_client`),
  KEY `id_reservation` (`id_reservation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `trajectoire`
--

DROP TABLE IF EXISTS `trajectoire`;
CREATE TABLE IF NOT EXISTS `trajectoire` (
  `id_trajet` int NOT NULL AUTO_INCREMENT,
  `ville_depart` varchar(255) NOT NULL,
  `ville_arrive` varchar(255) NOT NULL,
  `heure_depart` time NOT NULL,
  `prix_trajet` int NOT NULL,
  `duree_estime` int NOT NULL,
  PRIMARY KEY (`id_trajet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `type_vehicule`
--

DROP TABLE IF EXISTS `type_vehicule`;
CREATE TABLE IF NOT EXISTS `type_vehicule` (
  `id_type` int NOT NULL AUTO_INCREMENT,
  `nom_type` varchar(100) NOT NULL,
  PRIMARY KEY (`id_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `matricule` varchar(100) NOT NULL,
  `nom_user` varchar(200) NOT NULL,
  `prenom_user` varchar(20) NOT NULL,
  `email_user` varchar(50) NOT NULL,
  `telephone_user` varchar(60) NOT NULL,
  `username` varchar(45) NOT NULL,
  `motdepasse` varchar(45) NOT NULL,
  PRIMARY KEY (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

DROP TABLE IF EXISTS `vehicule`;
CREATE TABLE IF NOT EXISTS `vehicule` (
  `idvehicule` int NOT NULL AUTO_INCREMENT,
  `num_matricule` varchar(20) NOT NULL,
  `marque` varchar(20) NOT NULL,
  `capacite` varchar(20) NOT NULL,
  `color` varchar(30) NOT NULL,
  `status` varchar(30) NOT NULL,
  `id_type` int NOT NULL,
  PRIMARY KEY (`idvehicule`),
  KEY `id_type` (`id_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `voyage`
--

DROP TABLE IF EXISTS `voyage`;
CREATE TABLE IF NOT EXISTS `voyage` (
  `id_voyage` int NOT NULL AUTO_INCREMENT,
  `nom_voyage` varchar(40) NOT NULL,
  `date_voyage` date NOT NULL,
  `idvehicule` int NOT NULL,
  `id_chaufeur` int NOT NULL,
  `id_trajet` int NOT NULL,
  PRIMARY KEY (`id_voyage`),
  KEY `idvehicule` (`idvehicule`),
  KEY `id_chaufeur` (`id_chaufeur`),
  KEY `id_trajet` (`id_trajet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `exercer`
--
ALTER TABLE `exercer`
  ADD CONSTRAINT `exercer_ibfk_1` FOREIGN KEY (`matricule`) REFERENCES `utilisateur` (`matricule`),
  ADD CONSTRAINT `exercer_ibfk_2` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`id_voyage`) REFERENCES `voyage` (`id_voyage`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
  ADD CONSTRAINT `reservation_ibfk_3` FOREIGN KEY (`matricule`) REFERENCES `utilisateur` (`matricule`);

--
-- Contraintes pour la table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`id_reservation`) REFERENCES `reservation` (`id_reservation`);

--
-- Contraintes pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD CONSTRAINT `vehicule_ibfk_1` FOREIGN KEY (`id_type`) REFERENCES `type_vehicule` (`id_type`);

--
-- Contraintes pour la table `voyage`
--
ALTER TABLE `voyage`
  ADD CONSTRAINT `voyage_ibfk_1` FOREIGN KEY (`idvehicule`) REFERENCES `vehicule` (`idvehicule`),
  ADD CONSTRAINT `voyage_ibfk_2` FOREIGN KEY (`id_chaufeur`) REFERENCES `chaufeur` (`id_chaufeur`),
  ADD CONSTRAINT `voyage_ibfk_3` FOREIGN KEY (`id_trajet`) REFERENCES `trajectoire` (`id_trajet`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
