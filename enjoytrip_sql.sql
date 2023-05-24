-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema enjoytrip
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema enjoytrip
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `enjoytrip` DEFAULT CHARACTER SET utf8mb3 ;
USE `enjoytrip` ;

-- -----------------------------------------------------
-- Table `enjoytrip`.`sido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `enjoytrip`.`sido` ;

CREATE TABLE IF NOT EXISTS `enjoytrip`.`sido` (
  `sido_code` INT NOT NULL,
  `sido_name` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`gugun`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `enjoytrip`.`gugun` ;

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
DROP TABLE IF EXISTS `enjoytrip`.`attraction_info` ;

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
DROP TABLE IF EXISTS `enjoytrip`.`attraction_description` ;

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
DROP TABLE IF EXISTS `enjoytrip`.`attraction_detail` ;

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
DROP TABLE IF EXISTS `enjoytrip`.`user` ;

CREATE TABLE IF NOT EXISTS `enjoytrip`.`user` (
  `user_id` VARCHAR(16) NOT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `user_pw` VARCHAR(200) NOT NULL,
  `email_id` VARCHAR(45) NULL DEFAULT NULL,
  `email_domain` VARCHAR(45) NULL DEFAULT NULL,
  `join_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `admin` TINYINT NULL DEFAULT NULL,
  `profile_image` VARCHAR(200) NULL DEFAULT NULL,
  `profile_url` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`hotplace`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `enjoytrip`.`hotplace` ;

CREATE TABLE IF NOT EXISTS `enjoytrip`.`hotplace` (
  `articleNo` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(16) NOT NULL,
  `imageUrl` VARCHAR(200) NOT NULL,
  `content` VARCHAR(100) NULL DEFAULT NULL,
  `heart_count` INT NOT NULL,
  `register_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `subject` VARCHAR(45) NULL DEFAULT NULL,
  `hotple_name` VARCHAR(45) NOT NULL,
  `sido_code` INT NULL DEFAULT NULL,
  PRIMARY KEY (`articleNo`),
  INDEX `hotplace_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  INDEX `hotplace_to_attraction_info_sido_code_fk_idx` (`sido_code` ASC) VISIBLE,
  CONSTRAINT `hotplace_to_attraction_info_sido_code_fk`
    FOREIGN KEY (`sido_code`)
    REFERENCES `enjoytrip`.`attraction_info` (`sido_code`),
  CONSTRAINT `hotplace_to_user_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`heartcomment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `enjoytrip`.`heartcomment` ;

CREATE TABLE IF NOT EXISTS `enjoytrip`.`heartcomment` (
  `articleNo` INT NOT NULL,
  `user_id` VARCHAR(16) NOT NULL,
  `check` CHAR(2) NOT NULL,
  PRIMARY KEY (`articleNo`, `user_id`),
  INDEX `heartComment_to_hotplace_articleNo_fk_idx` (`articleNo` ASC) VISIBLE,
  INDEX `heartComment_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `heartComment_to_hotplace_articleNo_fk`
    FOREIGN KEY (`articleNo`)
    REFERENCES `enjoytrip`.`hotplace` (`articleNo`),
  CONSTRAINT `heartComment_to_user_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`hotplacereply`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `enjoytrip`.`hotplacereply` ;

CREATE TABLE IF NOT EXISTS `enjoytrip`.`hotplacereply` (
  `replyNo` INT NOT NULL AUTO_INCREMENT,
  `articleNo` INT NOT NULL,
  `user_id` VARCHAR(16) NOT NULL,
  `content` VARCHAR(200) NULL DEFAULT NULL,
  `regiter_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `reply_depth` INT NOT NULL,
  PRIMARY KEY (`replyNo`, `articleNo`),
  INDEX `reply_to_hotplace_articleNo_fk_idx` (`articleNo` ASC) VISIBLE,
  INDEX `reply_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `reply_to_hotplace_articleNo_fk`
    FOREIGN KEY (`articleNo`)
    REFERENCES `enjoytrip`.`hotplace` (`articleNo`),
  CONSTRAINT `reply_to_user_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`notice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `enjoytrip`.`notice` ;

CREATE TABLE IF NOT EXISTS `enjoytrip`.`notice` (
  `articleNo` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(16) NOT NULL,
  `subject` VARCHAR(45) NOT NULL,
  `content` VARCHAR(300) NOT NULL,
  `hit` INT NULL DEFAULT NULL,
  `register_time` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`articleNo`),
  INDEX `notice_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `notice_to_user_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`sharetravel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `enjoytrip`.`sharetravel` ;

CREATE TABLE IF NOT EXISTS `enjoytrip`.`sharetravel` (
  `articleNo` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(45) NOT NULL,
  `subject` VARCHAR(45) NOT NULL,
  `content` VARCHAR(300) NULL DEFAULT NULL,
  `hit` INT NULL DEFAULT NULL,
  `register_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`articleNo`),
  INDEX `shareTravel_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `shareTravel_to_user_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`sharereply`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `enjoytrip`.`sharereply` ;

CREATE TABLE IF NOT EXISTS `enjoytrip`.`sharereply` (
  `replyNo` INT NOT NULL AUTO_INCREMENT,
  `articleNo` INT NOT NULL,
  `user_id` VARCHAR(16) NOT NULL,
  `reply_depth` INT NOT NULL,
  `content` VARCHAR(200) NOT NULL,
  `register_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`replyNo`),
  INDEX `shareReply_to_shareTravel_articleNo_fk_idx` (`articleNo` ASC) VISIBLE,
  INDEX `shareReply_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `shareReply_to_shareTravel_articleNo_fk`
    FOREIGN KEY (`articleNo`)
    REFERENCES `enjoytrip`.`sharetravel` (`articleNo`)
    ON DELETE CASCADE,
  CONSTRAINT `shareReply_to_user_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`travelplan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `enjoytrip`.`travelplan` ;

CREATE TABLE IF NOT EXISTS `enjoytrip`.`travelplan` (
  `articleNo` INT NOT NULL AUTO_INCREMENT,
  `start_date` TIMESTAMP NULL DEFAULT NULL,
  `end_date` TIMESTAMP NULL DEFAULT NULL,
  `subject` VARCHAR(45) NOT NULL,
  `user_id` VARCHAR(16) NOT NULL,
  `hit` INT NULL DEFAULT NULL,
  `register_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `star_count` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`articleNo`),
  INDEX `travelPlan_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `travelPlan_to_user_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`starcomment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `enjoytrip`.`starcomment` ;

CREATE TABLE IF NOT EXISTS `enjoytrip`.`starcomment` (
  `user_id` VARCHAR(16) NOT NULL,
  `articleNo` INT NOT NULL,
  `count` INT NOT NULL,
  PRIMARY KEY (`user_id`, `articleNo`),
  INDEX `starComment_to_travelPlan_articleNo_fk_idx` (`articleNo` ASC) VISIBLE,
  INDEX `starComment_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `starComment_to_travelPlan_articleNo_fk`
    FOREIGN KEY (`articleNo`)
    REFERENCES `enjoytrip`.`travelplan` (`articleNo`),
  CONSTRAINT `starComment_to_user_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`travelplaninfo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `enjoytrip`.`travelplaninfo` ;

CREATE TABLE IF NOT EXISTS `enjoytrip`.`travelplaninfo` (
`travelplan_id` INT NOT NULL auto_increment,
`articleNo` INT NOT NULL ,
  `content_id` INT NULL,  
   `title` VARCHAR(100) NULL DEFAULT NULL,
  `addr1` VARCHAR(100) NULL DEFAULT NULL,
  `first_image` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`travelplan_id`),
  INDEX `travelplan_to_travelplaninfo_fk_articleNo_idx` (`articleNo` ASC) VISIBLE,
  CONSTRAINT `travelplan_to_travelplaninfo_fk_articleNo`
    FOREIGN KEY (`articleNo`)
    REFERENCES `enjoytrip`.`travelplan` (`articleNo`)
    ON DELETE cascade
    ON UPDATE cascade)
ENGINE = InnoDB;

insert into user (user_id, user_name, user_pw, email_id, email_domain, admin)
values ('ssafy', '관리자', '1234', 'ssafy', 'naver.com', 1);

alter table `enjoytrip`.`user`
add column `token` varchar(1000) null default null after `join_date`;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;