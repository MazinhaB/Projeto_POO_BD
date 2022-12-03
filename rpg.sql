-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema rpg
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema rpg
-- -----------------------------------------------------
drop database cadastroRPG;
CREATE SCHEMA IF NOT EXISTS `cadastroRPG` DEFAULT CHARACTER SET utf8mb3 ;
USE `cadastroRPG` ;

-- -----------------------------------------------------
-- Table `rpg`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadastroRPG`.`item` ;

CREATE TABLE IF NOT EXISTS `cadastroRPG`.`item` (
  `idItem` INT UNSIGNED NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idItem`),
  UNIQUE INDEX `idItem_UNIQUE` (`idItem` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `rpg`.`mundo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadastroRPG`.`mundo` ;

CREATE TABLE IF NOT EXISTS `cadastroRPG`.`mundo` (
  `idMundo` INT UNSIGNED NOT NULL,
  `nomeMundo` VARCHAR(45) NOT NULL,
  `tipoMundo` VARCHAR(45) NOT NULL,
  `nomeMestre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMundo`),
  UNIQUE INDEX `idMundo_UNIQUE` (`idMundo` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `rpg`.`personagem`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadastroRPG`.`personagem` ;

CREATE TABLE IF NOT EXISTS `cadastroRPG`.`personagem` (
  `idPersonagem` INT UNSIGNED NOT NULL,
  `nomeJogador` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `classe` VARCHAR(45) NOT NULL,
  `raca` VARCHAR(45) NOT NULL,
  `nivel` INT UNSIGNED NOT NULL,
  `destreza` INT UNSIGNED NOT NULL,
  `forca` INT UNSIGNED NOT NULL,
  `constituicao` INT UNSIGNED NOT NULL,
  `sabedoria` INT UNSIGNED NOT NULL,
  `inteligencia` INT UNSIGNED NOT NULL,
  `carisma` INT UNSIGNED NOT NULL,
  `modDestreza` INT NOT NULL,
  `modForca` INT NOT NULL,
  `modConstituicao` INT NOT NULL,
  `modSabedoria` INT NOT NULL,
  `modInteligencia` INT NOT NULL,
  `modCarisma` INT NOT NULL,
  `pvAtual` INT UNSIGNED NOT NULL,
  `pvMax` INT UNSIGNED NULL DEFAULT NULL,
  `mundo_idMundo` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idPersonagem`, `mundo_idMundo`),
  UNIQUE INDEX `idPersonagem_UNIQUE` (`idPersonagem` ASC) VISIBLE,
  INDEX `fk_personagem_mundo1_idx` (`mundo_idMundo` ASC) VISIBLE,
  CONSTRAINT `fk_personagem_mundo1`
    FOREIGN KEY (`mundo_idMundo`)
    REFERENCES `cadastroRPG`.`mundo` (`idMundo`)
    ON DELETE CASCADE
	ON UPDATE CASCADE
    )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `rpg`.`arma`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadastroRPG`.`arma` ;

CREATE TABLE IF NOT EXISTS `cadastroRPG`.`arma` (
  `idArma` INT UNSIGNED NOT NULL,
  `dadoDano` VARCHAR(45) NOT NULL,
  `municao` INT UNSIGNED ZEROFILL NOT NULL,
  `bonusDano` INT UNSIGNED ZEROFILL NOT NULL,
  `Item_idItem` INT UNSIGNED NOT NULL,
  `Personagem_idPersonagem` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idArma`, `Item_idItem`),
  UNIQUE INDEX `idArma_UNIQUE` (`idArma` ASC) VISIBLE,
  INDEX `fk_Arma_Item1_idx` (`Item_idItem` ASC) VISIBLE,
  INDEX `fk_Arma_Personagem1_idx` (`Personagem_idPersonagem` ASC) VISIBLE,
  CONSTRAINT `fk_Arma_Item1`
    FOREIGN KEY (`Item_idItem`)
    REFERENCES `cadastroRPG`.`item` (`idItem`)
    ON DELETE CASCADE
	ON UPDATE CASCADE,
  CONSTRAINT `fk_Arma_Personagem1`
    FOREIGN KEY (`Personagem_idPersonagem`)
    REFERENCES `cadastroRPG`.`personagem` (`idPersonagem`)
    ON DELETE CASCADE
	ON UPDATE CASCADE
    )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `rpg`.`armadura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadastroRPG`.`armadura` ;

CREATE TABLE IF NOT EXISTS `cadastroRPG`.`armadura` (
  `idArmadura` INT UNSIGNED NOT NULL,
  `ca` INT UNSIGNED ZEROFILL NOT NULL,
  `Item_idItem` INT UNSIGNED NOT NULL,
  `personagem_idPersonagem` INT UNSIGNED NOT NULL,
  `personagem_mundo_idMundo` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idArmadura`, `Item_idItem`),
  UNIQUE INDEX `idArmadura_UNIQUE` (`idArmadura` ASC) VISIBLE,
  INDEX `fk_Armadura_Item1_idx` (`Item_idItem` ASC) VISIBLE,
  INDEX `fk_armadura_personagem1_idx` (`personagem_idPersonagem` ASC, `personagem_mundo_idMundo` ASC) VISIBLE,
  CONSTRAINT `fk_Armadura_Item1`
    FOREIGN KEY (`Item_idItem`)
    REFERENCES `cadastroRPG`.`item` (`idItem`)
    ON DELETE CASCADE
	ON UPDATE CASCADE,
  CONSTRAINT `fk_armadura_personagem1`
    FOREIGN KEY (`personagem_idPersonagem` , `personagem_mundo_idMundo`)
    REFERENCES `cadastroRPG`.`personagem` (`idPersonagem` , `mundo_idMundo`)
    ON DELETE CASCADE
	ON UPDATE CASCADE
    )
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `rpg`.`personagem_andacom_personagem`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadastroRPG`.`personagem_andacom_personagem` ;

CREATE TABLE IF NOT EXISTS `cadastroRPG`.`personagem_andacom_personagem` (
  `Personagem_idPersonagem` INT UNSIGNED NOT NULL,
  `Personagem_idPersonagem1` INT UNSIGNED NOT NULL,
  `nomeEquipe` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Personagem_idPersonagem`, `Personagem_idPersonagem1`),
  INDEX `fk_Personagem_has_Personagem_Personagem1_idx` (`Personagem_idPersonagem1` ASC) VISIBLE,
  INDEX `fk_Personagem_has_Personagem_Personagem_idx` (`Personagem_idPersonagem` ASC) VISIBLE,
  CONSTRAINT `fk_Personagem_has_Personagem_Personagem`
    FOREIGN KEY (`Personagem_idPersonagem`)
    REFERENCES `cadastroRPG`.`personagem` (`idPersonagem`),
  CONSTRAINT `fk_Personagem_has_Personagem_Personagem1`
    FOREIGN KEY (`Personagem_idPersonagem1`)
    REFERENCES `cadastroRPG`.`personagem` (`idPersonagem`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

INSERT INTO Mundo VALUES (2, "Dragoes", "Medieval", "Dju");
INSERT INTO Personagem VALUES (2, "Jesus", "Feng", "Monge", "Humano", 3, 20, 15, 14, 10, 10, 10, 5, 2, 2, 0, 0, 0, 20, 31, 2);
INSERT INTO Item VALUES (3, "Dardo", "Perfurante", "Dardinho de monge");
INSERT INTO Item VALUES (4, "Escudo", "Defesa", "Escudo de metal");
INSERT INTO Arma VALUES (2, "d4", 15, 7, 3, 2);
INSERT INTO Armadura VALUES (2, 14, 4, 2, 2);
SELECT * FROM Mundo;
SELECT * FROM Arma;
SELECT * FROM Armadura;
SELECT * FROM Item;
SELECT * FROM Personagem;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
