-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema theatrebooking
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema theatrebooking
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `theatrebooking` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema new_schema1
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema theatre
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema theatre
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `theatre` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `theatrebooking` ;

-- -----------------------------------------------------
-- Table `theatrebooking`.`showProduction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theatrebooking`.`showProduction` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `showName` VARCHAR(45) NULL,
  `showDescription` MEDIUMTEXT NULL,
  `duration` INT NULL,
  `language` ENUM('English', 'Spanish', 'Italian') NULL,
  `typeID` ENUM('Musical', 'Opera', 'Theatre', 'Concert') NOT NULL,
  `liveAccompaniment` TINYINT NULL,
  `circlePrice` DOUBLE NOT NULL,
  `stallPrice` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theatrebooking`.`performance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theatrebooking`.`performance` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `showDate` DATE NULL,
  `showStartTime` TIME NULL,
  `totalAvailibilityStalls` INT NULL,
  `totalAvailibilityCircle` INT NULL,
  `showProductionID` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `showProductionID_idx` (`showProductionID` ASC) VISIBLE,
  CONSTRAINT `showProductionID`
    FOREIGN KEY (`showProductionID`)
    REFERENCES `theatrebooking`.`showProduction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theatrebooking`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theatrebooking`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `addressLine1` VARCHAR(45) NULL,
  `addressLine2` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `postcode` VARCHAR(9) NULL,
  `email` VARCHAR(45) NULL,
  `phoneNumber` VARCHAR(45) NULL,
  `creditCard` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theatrebooking`.`musicPerformer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theatrebooking`.`musicPerformer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `performanceID` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `performanceID_idx` (`performanceID` ASC) VISIBLE,
  CONSTRAINT `performance1ID`
    FOREIGN KEY (`performanceID`)
    REFERENCES `theatrebooking`.`performance` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theatrebooking`.`performerRegular`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theatrebooking`.`performerRegular` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `performanceID` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `performanceID_idx` (`performanceID` ASC) VISIBLE,
  CONSTRAINT `performance2ID`
    FOREIGN KEY (`performanceID`)
    REFERENCES `theatrebooking`.`performance` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theatrebooking`.`concessionID`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theatrebooking`.`concessionID` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` ENUM('Student', 'Under 16') NULL,
  `discount` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theatrebooking`.`transactionID`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theatrebooking`.`transactionID` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `timestamp` DATETIME NULL,
  `customerID` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `customerID_idx` (`customerID` ASC) VISIBLE,
  CONSTRAINT `customerID`
    FOREIGN KEY (`customerID`)
    REFERENCES `theatrebooking`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theatrebooking`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theatrebooking`.`ticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `transactionID` INT NULL,
  `performanceID` INT NULL,
  `concessionID` INT NULL,
  `collectionID` ENUM('Posted', 'BoxOffice', 'PrintAtHome') NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `transactionID_idx` (`transactionID` ASC) INVISIBLE,
  INDEX `performanceID_idx` (`performanceID` ASC) VISIBLE,
  INDEX `concessionID_idx` (`concessionID` ASC) VISIBLE,
  CONSTRAINT `transactionID`
    FOREIGN KEY (`transactionID`)
    REFERENCES `theatrebooking`.`transactionID` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `performance3ID`
    FOREIGN KEY (`performanceID`)
    REFERENCES `theatrebooking`.`performance` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `concessionID`
    FOREIGN KEY (`concessionID`)
    REFERENCES `theatrebooking`.`concessionID` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `theatre` ;

-- -----------------------------------------------------
-- Table `theatre`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theatre`.`customer` (
  `customerID` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(25) NULL DEFAULT NULL,
  `middle_name` VARCHAR(25) NULL DEFAULT NULL,
  `last_name` VARCHAR(50) NULL DEFAULT NULL,
  `address_no` VARCHAR(5) NULL DEFAULT NULL,
  `address_st` VARCHAR(25) NULL DEFAULT NULL,
  `address_postcode` VARCHAR(8) NULL DEFAULT NULL,
  `customer_email` VARCHAR(50) NULL DEFAULT NULL,
  `cust_history` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`customerID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `theatre`.`performance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theatre`.`performance` (
  `perfID` INT NOT NULL,
  `SID` INT NULL DEFAULT NULL,
  `perf_date` DATETIME NULL DEFAULT NULL,
  `seats_circle` INT NULL DEFAULT NULL,
  `seats_stall` INT NULL DEFAULT NULL,
  PRIMARY KEY (`perfID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `theatre`.`show_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theatre`.`show_details` (
  `SID` INT NOT NULL,
  `show_ticketPrice` DOUBLE NULL DEFAULT NULL,
  `show_performer` VARCHAR(100) NULL DEFAULT NULL,
  `show_title` VARCHAR(100) NULL DEFAULT NULL,
  `show_description` VARCHAR(500) NULL DEFAULT NULL,
  `show_genre` VARCHAR(50) NULL DEFAULT NULL,
  `primary_language` VARCHAR(50) NULL DEFAULT NULL,
  `show_live_music` TINYINT(1) NULL DEFAULT NULL,
  `show_duration` INT NULL DEFAULT NULL,
  `show_runlength` INT NULL DEFAULT NULL,
  PRIMARY KEY (`SID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `theatre`.`tickets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theatre`.`tickets` (
  `customerID` INT NULL DEFAULT NULL,
  `perfID` INT NULL DEFAULT NULL,
  `stall` INT NULL DEFAULT NULL,
  `circle` INT NULL DEFAULT NULL,
  `post` INT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
