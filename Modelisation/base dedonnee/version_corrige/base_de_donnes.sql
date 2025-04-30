-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 30 avr. 2025 à 09:13
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
  `prenom_chaufeur` varchar(40) NOT NULL,
  `email_chaufeur` varchar(45) NOT NULL,
  `telephone_chaufeur` varchar(40) NOT NULL,
  `permi_conduire` varchar(45) NOT NULL,
  PRIMARY KEY (`id_chaufeur`)
);

--
-- Déchargement des données de la table `chaufeur`
--

INSERT INTO `chaufeur` (`id_chaufeur`, `nom_chaufeur`, `prenom_chaufeur`, `email_chaufeur`, `telephone_chaufeur`, `permi_conduire`) VALUES
(1, 'SHIMA', 'Keith', 'shima@gmail.com', '684025899', 'H54-4585/089'),
(2, 'NDUWAMUNGU', 'Egide', 'egide@gmail.com', '68402589', 'fdsfsda878-dfd8'),
(3, 'kwizera', 'Nelly', 'nelly@gmail.com', '68794103', 'DGGHD-58-H2C'),
(4, 'NIKWIGIZE', 'Rose', 'nikwigize@gmail.com', '75457890', 'WR5-225T-8P');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id_client` int NOT NULL AUTO_INCREMENT,
  `nom_client` varchar(100) NOT NULL,
  `prenom_client` varchar(50) NOT NULL,
  `telephone_client` varchar(50) NOT NULL,
  `email_client` varchar(50) NOT NULL,
  PRIMARY KEY (`id_client`)
) ;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id_client`, `nom_client`, `prenom_client`, `telephone_client`, `email_client`) VALUES
(1, 'kamana', 'audry', '68402589', 'kamana@gmail.com'),
(2, 'ngendakumana', 'minani', '78402589', 'minani@gmail.com');

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
);

--
-- Déchargement des données de la table `exercer`
--

INSERT INTO `exercer` (`id_exercer`, `date_debut`, `matricule`, `id_role`) VALUES
(1, '2025-03-05', 'BIU-EED-11-123-2023', 1),
(2, '2025-04-02', 'BIU-EED-11-041-2023', 2);

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
);

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id_reservation`, `date_reservation`, `nom_place`, `id_voyage`, `id_client`, `matricule`) VALUES
(1, '2025-05-07', 'TUGENDE', 2, 1, 'BIU-EED-11-041-2023'),
(2, '2025-04-09', 'ASDASF', 2, 2, 'BIU-EED-11-123-2023');

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id_role` int NOT NULL AUTO_INCREMENT,
  `nom_role` varchar(100) NOT NULL,
  PRIMARY KEY (`id_role`)
);

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id_role`, `nom_role`) VALUES
(1, 'DG'),
(2, 'Assistant');

-- --------------------------------------------------------

--
-- Structure de la table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
CREATE TABLE IF NOT EXISTS `ticket` (
  `id_ticket` int NOT NULL AUTO_INCREMENT,
  `numero_ticket` varchar(100) NOT NULL,
  `date_emission` date NOT NULL,
  `id_reservation` int NOT NULL,
  PRIMARY KEY (`id_ticket`),
  KEY `id_reservation` (`id_reservation`)
) ;

--
-- Déchargement des données de la table `ticket`
--

INSERT INTO `ticket` (`id_ticket`, `numero_ticket`, `date_emission`, `id_reservation`) VALUES
(1, '5555', '2025-04-22', 1),
(2, '58RRR', '2025-04-24', 2);

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
) ;

--
-- Déchargement des données de la table `trajectoire`
--

INSERT INTO `trajectoire` (`id_trajet`, `ville_depart`, `ville_arrive`, `heure_depart`, `prix_trajet`, `duree_estime`) VALUES
(1, 'BUJUMBURA', 'MAKAMBA', '15:50:36', 60000, 45),
(2, 'KANYOSHA', 'MUKAZA', '15:12:37', 5000, 1);

-- --------------------------------------------------------

--
-- Structure de la table `type_vehicule`
--

DROP TABLE IF EXISTS `type_vehicule`;
CREATE TABLE IF NOT EXISTS `type_vehicule` (
  `id_type` int NOT NULL AUTO_INCREMENT,
  `nom_type` varchar(100) NOT NULL,
  PRIMARY KEY (`id_type`)
);

--
-- Déchargement des données de la table `type_vehicule`
--

INSERT INTO `type_vehicule` (`id_type`, `nom_type`) VALUES
(1, 'toyota'),
(2, 'tesla');

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
) ;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`matricule`, `nom_user`, `prenom_user`, `email_user`, `telephone_user`, `username`, `motdepasse`) VALUES
('BIU-EED-11-041-2023', 'NDUWIMANA', 'Audry', 'audry007@gmail.com', '684105289', 'wakanda', 'wakanda'),
('BIU-EED-11-123-2023', 'KAMANA', 'urbain', 'kamanaurbain12@gmail.com', '68402589', 'kamana', 'kamana');

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
) ;

--
-- Déchargement des données de la table `vehicule`
--

INSERT INTO `vehicule` (`idvehicule`, `num_matricule`, `marque`, `capacite`, `color`, `status`, `id_type`) VALUES
(1, 'K7729A', 'AXIO', '8', 'black', 'disponible', 1),
(2, 'K87902A', 'PROBOS', '6', 'white', 'dispo', 1);

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
) ;

--
-- Déchargement des données de la table `voyage`
--

INSERT INTO `voyage` (`id_voyage`, `nom_voyage`, `date_voyage`, `idvehicule`, `id_chaufeur`, `id_trajet`) VALUES
(1, 'URUGENDO', '2025-04-19', 1, 2, 1),
(2, 'BURAGANE', '2025-04-30', 2, 1, 1);

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
