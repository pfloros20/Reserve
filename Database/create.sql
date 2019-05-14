# RUN FIRST ON ROOT WITH NEXT 2 LINES UNCOMMENTED TO CREATE A NEW USER
# THEN USE THAT NEW USER AND COMMENT THE LINES AGAIN.

# CREATE USER IF NOT EXISTS softeng@'localhost' IDENTIFIED BY 'softeng';
# GRANT ALL PRIVILEGES ON RESERVE.* TO 'softeng'@'localhost';

CREATE DATABASE IF NOT EXISTS `RESERVE` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `RESERVE`;

DROP TABLE IF EXISTS `ADMIN`;
DROP TABLE IF EXISTS `RES_TABLES`;
DROP TABLE IF EXISTS `VISITED`;
DROP TABLE IF EXISTS `REPORT`;
DROP TABLE IF EXISTS `EVENT`;
DROP TABLE IF EXISTS `TABLE`;
DROP TABLE IF EXISTS `RESERVATION`;
DROP TABLE IF EXISTS `REVIEW`;
DROP TABLE IF EXISTS `STORE`;
DROP TABLE IF EXISTS `OWNER`;
DROP TABLE IF EXISTS `USER`;

CREATE TABLE `ADMIN`(
	ID INT UNSIGNED AUTO_INCREMENT,
	USERNAME VARCHAR(50) NOT NULL UNIQUE,
	PASSWORD VARCHAR(50) NOT NULL,
	PRIMARY KEY(ID)
)Engine=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `OWNER`(
	ID INT UNSIGNED AUTO_INCREMENT,
	USERNAME VARCHAR(50) NOT NULL UNIQUE,
	PASSWORD VARCHAR(50) NOT NULL,
	PRIMARY KEY(ID)
)Engine=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `USER`(
	ID INT UNSIGNED AUTO_INCREMENT,
	USERNAME VARCHAR(50) NOT NULL UNIQUE,
	PASSWORD VARCHAR(50) NOT NULL,
	X FLOAT,
	Y FLOAT,
	PRIMARY KEY(ID)
)Engine=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `STORE`(
	ID INT UNSIGNED AUTO_INCREMENT,
	OWNER_ID INT UNSIGNED NOT NULL,
	CAPACITY INT UNSIGNED NOT NULL,
	CURRENT_AVAILABILITY INT UNSIGNED NOT NULL,
	DESCRIPTION VARCHAR(500) NOT NULL,
	VISIBLE BOOLEAN DEFAULT FALSE NOT NULL,
	TYPE VARCHAR(50) NOT NULL,
	PRIMARY KEY(ID),
	CONSTRAINT OWNER_ID
		FOREIGN KEY(OWNER_ID) REFERENCES `OWNER`(ID)
		ON UPDATE CASCADE ON DELETE CASCADE
)Engine=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `TABLE`(
	ID INT UNSIGNED AUTO_INCREMENT,
	STORE_ID INT UNSIGNED NOT NULL,
	CAPACITY INT UNSIGNED NOT NULL,
	AVAILABILITY ENUM('FREE', 'BOOKED', 'TAKEN') NOT NULL,
	PRIMARY KEY(ID),
	CONSTRAINT TABLE_STORE_ID
		FOREIGN KEY(STORE_ID) REFERENCES `STORE`(ID)
		ON UPDATE CASCADE ON DELETE CASCADE
)Engine=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `RESERVATION`(
	ID INT UNSIGNED AUTO_INCREMENT,
	SUBMITTED_BY INT UNSIGNED NOT NULL,
	STORE_ID INT UNSIGNED NOT NULL,
	STATE ENUM('ACCEPTED', 'DENIED') NOT NULL,
	PRIMARY KEY(ID),
	CONSTRAINT RESERVATION_SUBMITTED_BY
		FOREIGN KEY(SUBMITTED_BY) REFERENCES `USER`(ID)
		ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT RESERVATION_STORE_ID
		FOREIGN KEY(STORE_ID) REFERENCES `STORE`(ID)
		ON UPDATE CASCADE ON DELETE CASCADE
)Engine=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `RES_TABLES`(
	ID INT UNSIGNED AUTO_INCREMENT,
	RESERVATION_ID INT UNSIGNED NOT NULL,
	TABLE_ID INT UNSIGNED NOT NULL,
	PRIMARY KEY(ID),
	CONSTRAINT RES_TABLES_RESERVATION_ID
		FOREIGN KEY(RESERVATION_ID) REFERENCES `RESERVATION`(ID)
		ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT RES_TABLES_TABLE_ID
		FOREIGN KEY(TABLE_ID) REFERENCES `TABLE`(ID)
		ON UPDATE CASCADE ON DELETE CASCADE
)Engine=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `VISITED`(
	ID INT UNSIGNED AUTO_INCREMENT,
	STORE_ID INT UNSIGNED NOT NULL,
	USER_ID INT UNSIGNED NOT NULL,
	PRIMARY KEY(ID),
	CONSTRAINT VISITED_STORE_ID
		FOREIGN KEY(STORE_ID) REFERENCES `STORE`(ID)
		ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT VISITED_USER_ID
		FOREIGN KEY(USER_ID) REFERENCES `USER`(ID)
		ON UPDATE CASCADE ON DELETE CASCADE
)Engine=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `EVENT`(
	ID INT UNSIGNED AUTO_INCREMENT,
	STORE_ID INT UNSIGNED NOT NULL,
	START_DATE DATE NOT NULL,
	END_DATE DATE NOT NULL,
	DESCRIPTION VARCHAR(500) NOT NULL,
	PRIMARY KEY(ID),
	CONSTRAINT EVENT_STORE_ID
		FOREIGN KEY(STORE_ID) REFERENCES `STORE`(ID)
		ON UPDATE CASCADE ON DELETE CASCADE
)Engine=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `REVIEW`(
	ID INT UNSIGNED AUTO_INCREMENT NOT NULL,
	SUBMITTED_BY INT UNSIGNED NOT NULL,
	STORE_ID INT UNSIGNED NOT NULL,
	STARS INT UNSIGNED NOT NULL,
	DESCRIPTION VARCHAR(500) NOT NULL,
	PRIMARY KEY(ID),
	CONSTRAINT REVIEW_STORE_ID
		FOREIGN KEY(STORE_ID) REFERENCES `STORE`(ID)
		ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT REVIEW_SUBMITED_BY
		FOREIGN KEY(SUBMITTED_BY) REFERENCES `USER`(ID)
		ON UPDATE CASCADE ON DELETE CASCADE
)Engine=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `REPORT`(
	ID INT UNSIGNED AUTO_INCREMENT,
	SUBMITTED_BY INT UNSIGNED NOT NULL,
	TARGET INT UNSIGNED NOT NULL,
	REVIEW INT UNSIGNED NOT NULL,
	DESCRIPTION VARCHAR(500) NOT NULL,
	CLAIMS SET("HATE_SPEECH", "INAPPROPRIATE_NAME", "SPAMMING", "OTHER"),
	PRIMARY KEY(ID),
	CONSTRAINT REPORT_SUBMITTED_BY
		FOREIGN KEY(SUBMITTED_BY) REFERENCES `USER`(ID)
		ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT REPORT_TARGET
		FOREIGN KEY(TARGET) REFERENCES `USER`(ID)
		ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT REPORT_REVIEW
		FOREIGN KEY(REVIEW) REFERENCES `REVIEW`(ID)
		ON UPDATE CASCADE ON DELETE CASCADE
)Engine=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;