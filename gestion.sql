-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 05 août 2022 à 13:16
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion`
--

-- --------------------------------------------------------

--
-- Structure de la table `classes`
--

CREATE TABLE `classes` (
  `id` varchar(20) NOT NULL,
  `classe` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `classes`
--

INSERT INTO `classes` (`id`, `classe`) VALUES
('01', 'Licence 1'),
('02', 'Licence 2'),
('03', 'Licence 3'),
('04', 'Master 1'),
('05', 'Master 2');

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE `cours` (
  `id` varchar(20) NOT NULL,
  `classe` varchar(50) NOT NULL,
  `idmatiere` varchar(255) NOT NULL,
  `jour` varchar(50) NOT NULL,
  `heure` varchar(50) NOT NULL,
  `matProf` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`id`, `classe`, `idmatiere`, `jour`, `heure`, `matProf`) VALUES
('001', 'Licence 2', 'JEE', 'LUNDI', '1 Heure', 'Prof1'),
('002', 'Licence 3', 'Réseau', 'MARDI', '2 Heures', 'Prof2'),
('003', 'Licence 1', 'UML', 'LUNDI', '1 Heure', 'Prof3'),
('004', 'Licence 1', 'AGILE', 'LUNDI', '1 Heure', 'Prof1');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `matricule` varchar(20) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `naissance` varchar(15) DEFAULT NULL,
  `inscription` varchar(15) DEFAULT NULL,
  `sexe` varchar(10) NOT NULL,
  `adresse` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`matricule`, `nom`, `naissance`, `inscription`, `sexe`, `adresse`) VALUES
('19INF107P', 'DIARRA Tiècoura', '0000-00-00 00:0', '0000-00-00', 'M', 'Bamako'),
('19INF108P', 'MAIGA Abasse', '0000-00-00 00:0', '0000-00-00', 'M', 'Kalaban'),
('19INF101P', 'TRAORE Mary', '0000-00-00 00:0', '0000-00-00', 'M', 'Bko');

-- --------------------------------------------------------

--
-- Structure de la table `login`
--

CREATE TABLE `login` (
  `ref` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `mdp` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `login`
--

INSERT INTO `login` (`ref`, `nom`, `mdp`) VALUES
(1, 'admin', 'admin'),
(2, 'tiec', 'tiec');

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

CREATE TABLE `matiere` (
  `id` varchar(50) NOT NULL,
  `appellation` varchar(255) NOT NULL,
  `filiere` varchar(50) NOT NULL,
  `niveau` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `matieres`
--

CREATE TABLE `matieres` (
  `idmatiere` varchar(50) NOT NULL,
  `appellation` varchar(255) NOT NULL,
  `filiere` varchar(50) NOT NULL,
  `niveau` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `matieres`
--

INSERT INTO `matieres` (`idmatiere`, `appellation`, `filiere`, `niveau`) VALUES
('ALGO 1', 'ALGORITHME 1', 'GI', 'Licence 1'),
('JPOO', 'JAVA PRO-OR-OBJET', 'GI', 'Licence 2'),
('H&S', 'HTML & CSS', 'GI', 'Licence 1'),
('PHP', 'PHP AVANCE', 'GI', 'Licence 3'),
('UML', 'MODELISATION', 'GI', 'Licence 1'),
('AGILE', 'AGILITE', 'GI', 'Licence 1');

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

CREATE TABLE `note` (
  `noteID` varchar(20) NOT NULL,
  `matricule` varchar(50) NOT NULL,
  `matiere` varchar(100) NOT NULL,
  `controle` varchar(50) NOT NULL,
  `examen` varchar(50) NOT NULL,
  `tp` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `note`
--

INSERT INTO `note` (`noteID`, `matricule`, `matiere`, `controle`, `examen`, `tp`) VALUES
('1', '19INF101P', 'ALGO 1', '17.00', '16.00', '15.00'),
('2', '19INF110P', 'JEE', '18.50', '19.50', '17.00');

-- --------------------------------------------------------

--
-- Structure de la table `professeur`
--

CREATE TABLE `professeur` (
  `matProf` varchar(20) NOT NULL,
  `nomPrenom` varchar(255) NOT NULL,
  `specialite` varchar(255) NOT NULL,
  `contact` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `professeur`
--

INSERT INTO `professeur` (`matProf`, `nomPrenom`, `specialite`, `contact`) VALUES
('Prof1', 'SYLLA Néné', 'ALGO 1', '20202020'),
('Prof2', 'KEITA Fodé', 'Réseau', '21221202'),
('Prof3', 'KALOGA Fatoumata ', 'UML', '21020215');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `mdp` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `mdp` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `nom`, `mdp`) VALUES
(1, 'user', 'user'),
(2, 'tiec', 'tiec'),
(3, 'mary', 'mary');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `cours`
--
ALTER TABLE `cours`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1` (`matProf`),
  ADD KEY `fk2` (`idmatiere`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`matricule`);

--
-- Index pour la table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`ref`);

--
-- Index pour la table `matiere`
--
ALTER TABLE `matiere`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `matieres`
--
ALTER TABLE `matieres`
  ADD PRIMARY KEY (`idmatiere`);

--
-- Index pour la table `note`
--
ALTER TABLE `note`
  ADD PRIMARY KEY (`noteID`);

--
-- Index pour la table `professeur`
--
ALTER TABLE `professeur`
  ADD PRIMARY KEY (`matProf`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `login`
--
ALTER TABLE `login`
  MODIFY `ref` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
