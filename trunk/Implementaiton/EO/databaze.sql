-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Počítač: localhost
-- Vygenerováno: Středa 15. prosince 2010, 22:06
-- Verze MySQL: 5.1.36
-- Verze PHP: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Databáze: `eo`
--


-- Struktura tabulky `ukol`
--

CREATE TABLE IF NOT EXISTS `ukol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datumPrijeti` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  `datumSplneni` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  `nadpis` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  `textUkolu` text COLLATE utf8_czech_ci NOT NULL,
  `stavUkolu` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  `uzivatelID` int(11) NOT NULL,
  `resitelID` int(11) NOT NULL,
  `kategorieID` int(11) NOT NULL,
  `instituceID` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci AUTO_INCREMENT=1 ;

--
-- Vypisuji data pro tabulku `ukol`
--
INSERT INTO `ukol` (`id`, `datumPrijeti`, `datumSplneni`, `nadpis`, `textUkolu`, `stavUkolu`,`uzivatelID`,`resitelID`,`kategorieID`,`instituceID` ) VALUES
(1, '2009.10.10','*****' , 'Problem', 'vyresit', 'vytvoren',1,0,1,1),
(2, '2009.10.10','*****' , 'Problem2', 'vyresit', 'neschvalen',1,0,1,1),
(3, '2009.10.10','*****' , 'Problem3', 'vyresit', 'vytvoren',1,0,1,1),
(4, '2009.10.10','*****' , 'Problem4', 'vyresit', 'vytvoren',1,0,1,1),
(5, '2009.10.10','*****' , 'Problem5', 'vyresit', 'vytvoren',1,0,5,3),
(6, '2009.10.10','*****' , 'Problem6', 'vyresit', 'vytvoren',1,0,5,3);


CREATE TABLE IF NOT EXISTS `instituce` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nazev` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci AUTO_INCREMENT=1 ;

INSERT INTO `instituce` (`id`, `nazev`) VALUES
(1, 'Policie'),
(3, 'CVUT');

CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nazev` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci AUTO_INCREMENT=1 ;


CREATE TABLE IF NOT EXISTS `kategorie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nazev` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  `instituceID` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci AUTO_INCREMENT=1 ;




INSERT INTO `kategorie` (`id`, `nazev`,`instituceID`) VALUES
(1, 'první',1),
(2, 'druhá',1),
(3, 'třetí',1);

CREATE TABLE IF NOT EXISTS `resitel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  `heslo` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  `jmeno` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  `prijmeni` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  `kategorieID` int(11) NOT NULL,
 `stavUctu` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  `instituceID` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci AUTO_INCREMENT=1 ;

INSERT INTO `resitel` (`id`, `login`, `heslo`, `jmeno`, `prijmeni`,`kategorieID`,`stavUctu`,`instituceID`) VALUES
(1, 'resitel', 'resi', 'Václav Klaus', 'vasek@hrad.cz',1, 'existuje',1),
(2, 'resitel', 'resi', 'Václav Klaus', 'vasek@hrad.cz',1, 'existuje',1),
(3, 'resitel', 'resi', 'Václav Klaus', 'vasek@hrad.cz',1, 'existuje',1),
(4, 'Ombudsman', 'test', 'ombudsman', 'vasek@hrad.cz',3, 'existuje',1),
(5, 'Ombudsman', 'test', 'ombudsman', 'vasek@hrad.cz',3, 'existuje',3);
-- --------------------------------------------------------

-- --------------------------------------------------------

--
-- Struktura tabulky `uzivatel`
--

CREATE TABLE IF NOT EXISTS `uzivatel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  `heslo` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  `jmeno` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  `prijmeni` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  `stavUctu` varchar(255) COLLATE utf8_czech_ci NOT NULL,
 `roleID` int(11) NOT NULL,
  `instituceID` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci AUTO_INCREMENT=1 ;

--
-- Vypisuji data pro tabulku `uzivatel`
--

INSERT INTO `uzivatel` (`id`, `login`, `heslo`, `jmeno`, `prijmeni`,`stavUctu`,`roleID`,`instituceID`) VALUES
(1, 'vašek', 'test', 'Václav Klaus', 'vasek@hrad.cz', 'existuje',1,1),
(2, 'dinosaurus', 'test', 'Miroslav Kalousek', 'mirek@top09.cz', 'existuje',1,1),
(3, 'Admin', 'admin', 'Administrator', 'mirek@top09.cz', 'aktivní',2,1),
(4, 'doktor', 'test', 'doc. MUDr.Leoš Heger, CSc.', 'leos@mares.cz', 'existuje',1,1),
(5, 'test', 'test', 'Jina Instituce', 'leos@mares.cz', 'existuje',1,3),
(6, 'Admin', 'admin', 'Administrator', 'mirek@top09.cz', 'existuje',2,3);

CREATE TABLE IF NOT EXISTS `poznamka` (
  `uzivatelID` int(11) NOT NULL,
  `ukolID` int(11) NOT NULL,
  `nazev` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  PRIMARY KEY (`ukolID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `zadost` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datumZadani` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  `datumVyrizeni` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  `textZadosti` text COLLATE utf8_czech_ci NOT NULL,
  `stavZadosti` varchar(255) COLLATE utf8_czech_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci AUTO_INCREMENT=1 ;
-- --------------------------------------------------------