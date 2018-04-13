-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 13-Abr-2018 às 22:08
-- Versão do servidor: 5.7.17
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bdempregado`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `assalariado`
--

CREATE TABLE `assalariado` (
  `ID` int(11) NOT NULL,
  `salario` float NOT NULL,
  `ID_empregado` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `assalariado`
--

INSERT INTO `assalariado` (`ID`, `salario`, `ID_empregado`) VALUES
(1, 2000, 1),
(2, 2000, 6),
(3, 2000, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `comissionado`
--

CREATE TABLE `comissionado` (
  `ID` int(11) NOT NULL,
  `totalVenda` float NOT NULL,
  `taxaComissao` float NOT NULL,
  `ID_empregado` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `comissionado`
--

INSERT INTO `comissionado` (`ID`, `totalVenda`, `taxaComissao`, `ID_empregado`) VALUES
(1, 2000, 10.1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `empregado`
--

CREATE TABLE `empregado` (
  `ID` int(11) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Sobrenome` varchar(50) NOT NULL,
  `CPF` varchar(14) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `empregado`
--

INSERT INTO `empregado` (`ID`, `Nome`, `Sobrenome`, `CPF`) VALUES
(1, 'José renan', 'Alcântara lopes', '34468715863'),
(2, 'José renan', 'Alcântara lopes', '34468715863');

-- --------------------------------------------------------

--
-- Estrutura da tabela `horista`
--

CREATE TABLE `horista` (
  `ID` int(11) NOT NULL,
  `precoHora` float NOT NULL,
  `horasTrabalhadas` float NOT NULL,
  `ID_empregado` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `horista`
--

INSERT INTO `horista` (`ID`, `precoHora`, `horasTrabalhadas`, `ID_empregado`) VALUES
(1, 50, 10.5, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assalariado`
--
ALTER TABLE `assalariado`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_empregado` (`ID_empregado`);

--
-- Indexes for table `comissionado`
--
ALTER TABLE `comissionado`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_empregado` (`ID_empregado`);

--
-- Indexes for table `empregado`
--
ALTER TABLE `empregado`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `horista`
--
ALTER TABLE `horista`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_empregado` (`ID_empregado`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `assalariado`
--
ALTER TABLE `assalariado`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `comissionado`
--
ALTER TABLE `comissionado`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `empregado`
--
ALTER TABLE `empregado`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `horista`
--
ALTER TABLE `horista`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
