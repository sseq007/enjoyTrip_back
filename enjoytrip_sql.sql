-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema enjoytrip
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `enjoytrip` ;

-- -----------------------------------------------------
-- Schema enjoytrip
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `enjoytrip` DEFAULT CHARACTER SET utf8mb3 ;
USE `enjoytrip` ;

-- -----------------------------------------------------
-- Table `enjoytrip`.`sido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`sido` (
  `sido_code` INT NOT NULL,
  `sido_name` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`gugun`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`gugun` (
  `gugun_code` INT NOT NULL,
  `gugun_name` VARCHAR(30) NULL DEFAULT NULL,
  `sido_code` INT NOT NULL,
  PRIMARY KEY (`gugun_code`, `sido_code`),
  INDEX `gugun_to_sido_sido_code_fk_idx` (`sido_code` ASC) VISIBLE,
  CONSTRAINT `gugun_to_sido_sido_code_fk`
    FOREIGN KEY (`sido_code`)
    REFERENCES `enjoytrip`.`sido` (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`attraction_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`attraction_info` (
  `content_id` INT NOT NULL,
  `content_type_id` INT NULL DEFAULT NULL,
  `title` VARCHAR(100) NULL DEFAULT NULL,
  `addr1` VARCHAR(100) NULL DEFAULT NULL,
  `addr2` VARCHAR(50) NULL DEFAULT NULL,
  `zipcode` VARCHAR(50) NULL DEFAULT NULL,
  `tel` VARCHAR(50) NULL DEFAULT NULL,
  `first_image` VARCHAR(200) NULL DEFAULT NULL,
  `first_image2` VARCHAR(200) NULL DEFAULT NULL,
  `readcount` INT NULL DEFAULT NULL,
  `sido_code` INT NULL DEFAULT NULL,
  `gugun_code` INT NULL DEFAULT NULL,
  `latitude` DECIMAL(20,17) NULL DEFAULT NULL,
  `longitude` DECIMAL(20,17) NULL DEFAULT NULL,
  `mlevel` VARCHAR(2) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  INDEX `attraction_to_content_type_id_fk_idx` (`content_type_id` ASC) VISIBLE,
  INDEX `attraction_to_sido_code_fk_idx` (`sido_code` ASC) VISIBLE,
  INDEX `attraction_to_gugun_code_fk_idx` (`gugun_code` ASC) VISIBLE,
  CONSTRAINT `attraction_to_content_type_id_fk`
    FOREIGN KEY (`content_type_id`)
    REFERENCES `enjoytrip`.`content_type` (`content_type_id`),
  CONSTRAINT `attraction_to_gugun_code_fk`
    FOREIGN KEY (`gugun_code`)
    REFERENCES `enjoytrip`.`gugun` (`gugun_code`),
  CONSTRAINT `attraction_to_sido_code_fk`
    FOREIGN KEY (`sido_code`)
    REFERENCES `enjoytrip`.`sido` (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`attraction_description`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`attraction_description` (
  `content_id` INT NOT NULL,
  `homepage` VARCHAR(100) NULL DEFAULT NULL,
  `overview` VARCHAR(10000) NULL DEFAULT NULL,
  `telname` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  CONSTRAINT `attraction_detail_to_attraciton_id_fk`
    FOREIGN KEY (`content_id`)
    REFERENCES `enjoytrip`.`attraction_info` (`content_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`attraction_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`attraction_detail` (
  `content_id` INT NOT NULL,
  `cat1` VARCHAR(3) NULL DEFAULT NULL,
  `cat2` VARCHAR(5) NULL DEFAULT NULL,
  `cat3` VARCHAR(9) NULL DEFAULT NULL,
  `created_time` VARCHAR(14) NULL DEFAULT NULL,
  `modified_time` VARCHAR(14) NULL DEFAULT NULL,
  `booktour` VARCHAR(5) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  CONSTRAINT `attraction_detail_to_basic_content_id_fk`
    FOREIGN KEY (`content_id`)
    REFERENCES `enjoytrip`.`attraction_info` (`content_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`user` (
  `user_id` VARCHAR(16) NOT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `user_pw` VARCHAR(200) NOT NULL,
  `email_id` VARCHAR(45) NULL DEFAULT NULL,
  `email_domain` VARCHAR(45) NULL DEFAULT NULL,
  `join_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `admin` TINYINT NULL DEFAULT NULL,
  `profile_image` VARCHAR(200) NULL,
  `profile_url` VARCHAR(200) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`travelPlan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`travelPlan` (
  `articleNo` INT NOT NULL AUTO_INCREMENT,
  `content_id` INT NOT NULL,
  `start_date` TIMESTAMP NULL,
  `end_date` TIMESTAMP NULL,
  `subject` VARCHAR(45) NOT NULL,
  `user_id` VARCHAR(16) NOT NULL,
  `register_time` TIMESTAMP NULL DEFAULT current_timestamp,
  `star_count` double NULL,
  PRIMARY KEY (`articleNo`, `content_id`),
  INDEX `travelPlan_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  INDEX `travelPaln_to_attraction_info_content_id_fk_idx` (`content_id` ASC) VISIBLE,
  CONSTRAINT `travelPlan_to_user_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `travelPaln_to_attraction_info_content_id_fk`
    FOREIGN KEY (`content_id`)
    REFERENCES `enjoytrip`.`attraction_info` (`content_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `enjoytrip`.`starComment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`starComment` (
  `user_id` VARCHAR(16) NOT NULL,
  `articleNo` INT NOT NULL,
  `count` INT NOT NULL,
  PRIMARY KEY (`user_id`, `articleNo`),
  INDEX `starComment_to_travelPlan_articleNo_fk_idx` (`articleNo` ASC) VISIBLE,
  INDEX `starComment_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `starComment_to_travelPlan_articleNo_fk`
    FOREIGN KEY (`articleNo`)
    REFERENCES `enjoytrip`.`travelPlan` (`articleNo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `starComment_to_user_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `enjoytrip`.`hotplace`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`hotplace` (
  `articleNo` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(16) NOT NULL,
  `imageUrl` VARCHAR(200) NOT NULL,
  `content` VARCHAR(100) NULL,
  `heart_count` INT NOT NULL,
  `register_time` TIMESTAMP NULL DEFAULT current_timestamp,
  `subject` VARCHAR(45) NULL,
  `hotple_name` VARCHAR(45) NOT NULL,
  `sido_code` INT NULL,
  PRIMARY KEY (`articleNo`),
  INDEX `hotplace_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  INDEX `hotplace_to_attraction_info_sido_code_fk_idx` (`sido_code` ASC) VISIBLE,
  CONSTRAINT `hotplace_to_user_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `hotplace_to_attraction_info_sido_code_fk`
    FOREIGN KEY (`sido_code`)
    REFERENCES `enjoytrip`.`attraction_info` (`sido_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `enjoytrip`.`hotplaceReply`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`hotplaceReply` (
  `replyNo` INT NOT NULL AUTO_INCREMENT,
  `articleNo` INT NOT NULL,
  `user_id` VARCHAR(16) NOT NULL,
  `content` VARCHAR(200) NULL,
  `regiter_time` TIMESTAMP NULL DEFAULT current_timestamp,
  `reply_depth` INT NOT NULL,
  PRIMARY KEY (`replyNo`, `articleNo`),
  INDEX `reply_to_hotplace_articleNo_fk_idx` (`articleNo` ASC) VISIBLE,
  INDEX `reply_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `reply_to_hotplace_articleNo_fk`
    FOREIGN KEY (`articleNo`)
    REFERENCES `enjoytrip`.`hotplace` (`articleNo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `reply_to_user_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `enjoytrip`.`heartComment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`heartComment` (
  `articleNo` INT NOT NULL,
  `user_id` VARCHAR(16) NOT NULL,
  `check` CHAR(2) NOT NULL,
  PRIMARY KEY (`articleNo`, `user_id`),
  INDEX `heartComment_to_hotplace_articleNo_fk_idx` (`articleNo` ASC) VISIBLE,
  INDEX `heartComment_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `heartComment_to_hotplace_articleNo_fk`
    FOREIGN KEY (`articleNo`)
    REFERENCES `enjoytrip`.`hotplace` (`articleNo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `heartComment_to_user_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `enjoytrip`.`notice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`notice` (
  `articleNo` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(16) NOT NULL,
  `subject` VARCHAR(45) NOT NULL,
  `content` VARCHAR(300) NOT NULL,
  `register_time` TIMESTAMP NULL,
  PRIMARY KEY (`articleNo`),
  INDEX `notice_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `notice_to_user_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `enjoytrip`.`shareTravel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`shareTravel` (
  `articleNo` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(45) NOT NULL,
  `subject` VARCHAR(45) NOT NULL,
  `content` VARCHAR(300) NULL,
  `hit` INT NULL,
  `register_time` TIMESTAMP NULL DEFAULT current_timestamp,
  PRIMARY KEY (`articleNo`),
  INDEX `shareTravel_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `shareTravel_to_user_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `enjoytrip`.`shareReply`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`shareReply` (
  `replyNo` INT NOT NULL AUTO_INCREMENT,
  `articleNo` INT NOT NULL,
  `user_id` VARCHAR(16) NOT NULL,
  `reply_depth` INT NOT NULL,
  `content` VARCHAR(200) NOT NULL,
  `register_time` TIMESTAMP NULL DEFAULT current_timestamp,
  PRIMARY KEY (`replyNo`),
  INDEX `shareReply_to_shareTravel_articleNo_fk_idx` (`articleNo` ASC) VISIBLE,
  INDEX `shareReply_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `shareReply_to_shareTravel_articleNo_fk`
    FOREIGN KEY (`articleNo`)
    REFERENCES `enjoytrip`.`shareTravel` (`articleNo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `shareReply_to_user_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;