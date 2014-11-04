SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `SGFP` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `SGFP` ;

-- -----------------------------------------------------
-- Table `SGFP`.`Conta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGFP`.`Conta` ;

CREATE TABLE IF NOT EXISTS `SGFP`.`Conta` (
  `idConta` INT NOT NULL AUTO_INCREMENT,
  `nomeConta` VARCHAR(50) NULL,
  `senhaConta` VARCHAR(50) NOT NULL,
  `quantidadeInicialConta` DOUBLE NULL DEFAULT 0,
  `saldoConta` DOUBLE NULL DEFAULT 0,
  PRIMARY KEY (`idConta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGFP`.`Transacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGFP`.`Transacao` ;

CREATE TABLE IF NOT EXISTS `SGFP`.`Transacao` (
  `idTransacao` INT NOT NULL AUTO_INCREMENT,
  `descricaoTransacao` VARCHAR(50) NULL,
  `categoriaTransacao` VARCHAR(45) NOT NULL,
  `valorTransacao` VARCHAR(20) NULL DEFAULT 0,
  `dataTransacao` VARCHAR(20) NULL,
  `statusTransacao` CHAR(1) NULL,
  `tipoTransacao` CHAR(1) NULL,
  `Conta_idConta` INT NOT NULL,
  PRIMARY KEY (`idTransacao`),
  INDEX `fk_Transacao_Conta_idx` (`Conta_idConta` ASC),
  CONSTRAINT `fk_Transacao_Conta`
    FOREIGN KEY (`Conta_idConta`)
    REFERENCES `SGFP`.`Conta` (`idConta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGFP`.`GrupoTtansacoes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGFP`.`GrupoTtansacoes` ;

CREATE TABLE IF NOT EXISTS `SGFP`.`GrupoTtansacoes` (
  `idGrupoTtansacoes` INT NOT NULL AUTO_INCREMENT,
  `nomeGrupoTtansacoes` VARCHAR(50) NULL,
  `saldoGrupoTtansacoes` DOUBLE NULL,
  PRIMARY KEY (`idGrupoTtansacoes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGFP`.`GrupoTtansacoes_has_Transacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGFP`.`GrupoTtansacoes_has_Transacao` ;

CREATE TABLE IF NOT EXISTS `SGFP`.`GrupoTtansacoes_has_Transacao` (
  `GrupoTtansacoes_idGrupoTtansacoes` INT NOT NULL,
  `Transacao_idTransacao` INT NOT NULL,
  PRIMARY KEY (`GrupoTtansacoes_idGrupoTtansacoes`, `Transacao_idTransacao`),
  INDEX `fk_GrupoTtansacoes_has_Transacao_Transacao1_idx` (`Transacao_idTransacao` ASC),
  INDEX `fk_GrupoTtansacoes_has_Transacao_GrupoTtansacoes1_idx` (`GrupoTtansacoes_idGrupoTtansacoes` ASC),
  CONSTRAINT `fk_GrupoTtansacoes_has_Transacao_GrupoTtansacoes1`
    FOREIGN KEY (`GrupoTtansacoes_idGrupoTtansacoes`)
    REFERENCES `SGFP`.`GrupoTtansacoes` (`idGrupoTtansacoes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_GrupoTtansacoes_has_Transacao_Transacao1`
    FOREIGN KEY (`Transacao_idTransacao`)
    REFERENCES `SGFP`.`Transacao` (`idTransacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
