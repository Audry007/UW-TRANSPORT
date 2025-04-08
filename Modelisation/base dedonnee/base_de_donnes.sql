-- Corrigé du fichier SQL pour la base de données `uw-transport`

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

-- --------------------------------------------------------
-- Table `type_vehicule`
DROP TABLE IF EXISTS `type_vehicule`;
CREATE TABLE `type_vehicule` (
  `id_type` INT NOT NULL AUTO_INCREMENT,
  `nom_type` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------
-- Table `vehicule`
DROP TABLE IF EXISTS `vehicule`;
CREATE TABLE `vehicule` (
  `idvehicule` INT NOT NULL AUTO_INCREMENT,
  `num_matricule` VARCHAR(20) NOT NULL,
  `marque` VARCHAR(20) NOT NULL,
  `capacite` VARCHAR(20) NOT NULL,
  `color` VARCHAR(30) NOT NULL,
  `status` VARCHAR(30) NOT NULL,
  `id_type` INT NOT NULL,
  PRIMARY KEY (`idvehicule`),
  FOREIGN KEY (`id_type`) REFERENCES type_vehicule(`id_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------
-- Table `trajectoire`
DROP TABLE IF EXISTS `trajectoire`;
CREATE TABLE `trajectoire` (
  `id_trajet` INT NOT NULL AUTO_INCREMENT,
  `ville_depart` VARCHAR(255) NOT NULL,
  `ville_arrive` VARCHAR(255) NOT NULL,
  `heure_depart` TIME NOT NULL,
  `prix_trajet` INT NOT NULL,
  `duree_estime` INT NOT NULL,
  PRIMARY KEY (`id_trajet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------
-- Table `chaufeur`
DROP TABLE IF EXISTS `chaufeur`;
CREATE TABLE `chaufeur` (
  `id_chaufeur` INT NOT NULL AUTO_INCREMENT,
  `nom_chaufeur` VARCHAR(20) NOT NULL,
  `prenonm_chaufeur` VARCHAR(40) NOT NULL,
  `email_chaufeur` VARCHAR(45) NOT NULL,
  `telephone_chaufeur` VARCHAR(40) NOT NULL,
  `permi_conduire` VARCHAR(45) NOT NULL,
  `idvehicule` INT NOT NULL,
  PRIMARY KEY (`id_chaufeur`),
  FOREIGN KEY (`idvehicule`) REFERENCES vehicule(`idvehicule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------
-- Table `voyage`
DROP TABLE IF EXISTS `voyage`;
CREATE TABLE `voyage` (
  `id_voyage` INT NOT NULL AUTO_INCREMENT,
  `date_voyage` DATE NOT NULL,
  `idvehicule` INT NOT NULL,
  `id_chaufeur` INT NOT NULL,
  `id_trajet` INT NOT NULL,
  PRIMARY KEY (`id_voyage`),
  FOREIGN KEY (`idvehicule`) REFERENCES vehicule(`idvehicule`),
  FOREIGN KEY (`id_chaufeur`) REFERENCES chaufeur(`id_chaufeur`),
  FOREIGN KEY (`id_trajet`) REFERENCES trajectoire(`id_trajet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------
-- Table `client`
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `id_client` INT NOT NULL AUTO_INCREMENT,
  `nom_client` VARCHAR(100) NOT NULL,
  `prenom_emission` VARCHAR(50) NOT NULL,
  `telephone_client` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `adresse_client` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------
-- Table `utilisateur`
DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE `utilisateur` (
  `matricule` VARCHAR(100) NOT NULL,
  `nom_user` VARCHAR(200) NOT NULL,
  `prenom_user` VARCHAR(20) NOT NULL,
  `email_user` VARCHAR(50) NOT NULL,
  `telephone_user` VARCHAR(60) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `motdepasse` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------
-- Table `reservation`
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
  `id_reservation` INT NOT NULL AUTO_INCREMENT,
  `date_reservation` DATE NOT NULL,
  `nom_place` VARCHAR(20) NOT NULL,
  `id_voyage` INT NOT NULL,
  `id_client` INT NOT NULL,
  `matricule` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_reservation`),
  FOREIGN KEY (`id_voyage`) REFERENCES voyage(`id_voyage`),
  FOREIGN KEY (`id_client`) REFERENCES client(`id_client`),
  FOREIGN KEY (`matricule`) REFERENCES utilisateur(`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------
-- Table `ticket`
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `id_ticket` INT NOT NULL AUTO_INCREMENT,
  `numero_ticket` VARCHAR(100) NOT NULL,
  `date_emission` DATE NOT NULL,
  `id_client` INT NOT NULL,
  `id_reservation` INT NOT NULL,
  PRIMARY KEY (`id_ticket`),
  FOREIGN KEY (`id_client`) REFERENCES client(`id_client`),
  FOREIGN KEY (`id_reservation`) REFERENCES reservation(`id_reservation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------
-- Table `role`
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id_role` INT NOT NULL AUTO_INCREMENT,
  `nom_role` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------
-- Table `exercer`
DROP TABLE IF EXISTS `exercer`;
CREATE TABLE `exercer` (
  `id_exercer` INT NOT NULL AUTO_INCREMENT,
  `matricule` VARCHAR(100) NOT NULL,
  `id_role` INT NOT NULL,
  PRIMARY KEY (`id_exercer`),
  FOREIGN KEY (`matricule`) REFERENCES utilisateur(`matricule`),
  FOREIGN KEY (`id_role`) REFERENCES role(`id_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
