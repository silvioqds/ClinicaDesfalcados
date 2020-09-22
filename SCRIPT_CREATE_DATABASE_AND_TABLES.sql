SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `db_clinica` DEFAULT CHARACTER SET latin1 ;
USE `db_clinica` ;

-- -----------------------------------------------------
-- Table `db_clinica`.`servico`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_clinica`.`servico` (
  `ID_SERVICO` INT(11) NOT NULL AUTO_INCREMENT ,
  `DT_INCLUSAO` DATETIME NULL DEFAULT NULL ,
  `SERVICO` VARCHAR(255) NULL DEFAULT NULL ,
  `VALOR` DOUBLE NULL DEFAULT NULL ,
  `ID_ESPECIALIZACAO` BIGINT(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`ID_SERVICO`) )
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_clinica`.`usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_clinica`.`usuario` (
  `ID_USUARIO` INT(11) NOT NULL AUTO_INCREMENT ,
  `DT_INCLUSAO` DATETIME NULL DEFAULT NULL ,
  `FL_ADM` BIT(1) NULL DEFAULT NULL ,
  `PASSWORD` VARCHAR(255) NULL DEFAULT NULL ,
  `USERNAME` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`ID_USUARIO`) )
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_clinica`.`cargo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_clinica`.`cargo` (
  `ID_CARGO` INT(11) NOT NULL AUTO_INCREMENT ,
  `CARGO` VARCHAR(255) NULL DEFAULT NULL ,
  `VL_SALARIO` DOUBLE NULL DEFAULT NULL ,
  `FL_DENTISTA` BIT(1) NULL DEFAULT NULL ,
  `ID_ESPECIALIZACAO` BIGINT(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`ID_CARGO`) )
ENGINE = InnoDB
AUTO_INCREMENT = 40
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_clinica`.`funcionario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_clinica`.`funcionario` (
  `ID_FUNCIONARIO` INT(11) NOT NULL AUTO_INCREMENT ,
  `DT_INCLUSAO` DATETIME NULL DEFAULT NULL ,
  `DT_NASCIMENTO` DATETIME NULL DEFAULT NULL ,
  `NOME` VARCHAR(255) NULL DEFAULT NULL ,
  `ID_USUARIO` INT(11) NULL DEFAULT NULL ,
  `ID_CARGO` INT(11) NULL DEFAULT NULL ,
  `CPF` VARCHAR(255) NULL DEFAULT NULL ,
  `Sexo` VARCHAR(1) NULL DEFAULT NULL ,
  `CRO` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`ID_FUNCIONARIO`) ,
  INDEX `FKB3A9C5BB2DF1E47E` (`ID_USUARIO` ASC) ,
  INDEX `FKB3A9C5BB99D6EE1A` (`ID_CARGO` ASC) ,
  CONSTRAINT `FKB3A9C5BB2DF1E47E`
    FOREIGN KEY (`ID_USUARIO` )
    REFERENCES `db_clinica`.`usuario` (`ID_USUARIO` ),
  CONSTRAINT `FKB3A9C5BB99D6EE1A`
    FOREIGN KEY (`ID_CARGO` )
    REFERENCES `db_clinica`.`cargo` (`ID_CARGO` ))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_clinica`.`convenio`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_clinica`.`convenio` (
  `ID_CONVENIO` INT(11) NOT NULL AUTO_INCREMENT ,
  `CONVENIO` VARCHAR(255) NULL DEFAULT NULL ,
  `DT_INCLUSAO` DATETIME NULL DEFAULT NULL ,
  `DESCONTO_VALOR_SERVICO` DOUBLE NULL DEFAULT NULL ,
  PRIMARY KEY (`ID_CONVENIO`) )
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_clinica`.`paciente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_clinica`.`paciente` (
  `ID_PACIENTE` INT(11) NOT NULL AUTO_INCREMENT ,
  `CPF` VARCHAR(255) NOT NULL ,
  `NOME` VARCHAR(255) NOT NULL ,
  `NOME_MAE` VARCHAR(255) NOT NULL ,
  `NOME_PAI` VARCHAR(255) NULL DEFAULT NULL ,
  `ID_CONVENIO` INT(11) NULL DEFAULT NULL ,
  `Sexo` VARCHAR(1) NOT NULL ,
  `IDADE` INT(11) NOT NULL ,
  PRIMARY KEY (`ID_PACIENTE`) ,
  INDEX `FK3081779137CED7A4` (`ID_CONVENIO` ASC) ,
  CONSTRAINT `FK3081779137CED7A4`
    FOREIGN KEY (`ID_CONVENIO` )
    REFERENCES `db_clinica`.`convenio` (`ID_CONVENIO` ))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_clinica`.`agendamento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_clinica`.`agendamento` (
  `ID_AGENDAMENTO` INT(11) NOT NULL AUTO_INCREMENT ,
  `DT_HORA_ATENDIMENTO` DATETIME NULL DEFAULT NULL ,
  `DT_INCLUSAO` DATETIME NULL DEFAULT NULL ,
  `FL_CANCELADO` BIT(1) NULL DEFAULT NULL ,
  `MOTIVO_CANCELAMENTO` VARCHAR(255) NULL DEFAULT NULL ,
  `VL_ATENDIMENTO` DOUBLE NULL DEFAULT NULL ,
  `ID_PACIENTE` INT(11) NULL DEFAULT NULL ,
  `ID_SERVICO` INT(11) NULL DEFAULT NULL ,
  `ID_FUNCIONARIO` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`ID_AGENDAMENTO`) ,
  INDEX `FK8F03CA252A4F8BA0` (`ID_SERVICO` ASC) ,
  INDEX `FK8F03CA25D485ED00` (`ID_PACIENTE` ASC) ,
  INDEX `FK8F03CA259FF858D8` (`ID_FUNCIONARIO` ASC) ,
  CONSTRAINT `FK8F03CA252A4F8BA0`
    FOREIGN KEY (`ID_SERVICO` )
    REFERENCES `db_clinica`.`servico` (`ID_SERVICO` ),
  CONSTRAINT `FK8F03CA259FF858D8`
    FOREIGN KEY (`ID_FUNCIONARIO` )
    REFERENCES `db_clinica`.`funcionario` (`ID_FUNCIONARIO` ),
  CONSTRAINT `FK8F03CA25D485ED00`
    FOREIGN KEY (`ID_PACIENTE` )
    REFERENCES `db_clinica`.`paciente` (`ID_PACIENTE` ))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_clinica`.`especializacao`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_clinica`.`especializacao` (
  `ID_ESPECIALIZACAO` INT(11) NOT NULL AUTO_INCREMENT ,
  `ESPECIALIZACAO` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`ID_ESPECIALIZACAO`) )
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;

USE `db_clinica` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
