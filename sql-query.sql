USE project;

CREATE TABLE `architect` (
  `architect_id` int NOT NULL AUTO_INCREMENT,
  `profile_photo` varchar(355) NOT NULL,
  `name` varchar(100) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `cover_photo` varchar(355) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `education` varchar(255) NOT NULL,
  `experience` int NOT NULL,
  `degree_certificate` varchar(355) NOT NULL,
  `nata_certificate` varchar(355) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`architect_id`),
  UNIQUE KEY `Email` (`email`),
  UNIQUE KEY `architectID_UNIQUE` (`architect_id`)
);



CREATE TABLE `designs` (
  `design_id` int NOT NULL AUTO_INCREMENT,
  `design_name` varchar(50) NOT NULL,
  `design_url` varchar(200) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `description` varchar(190) NOT NULL,
  `no_of_rooms` int NOT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `architect_id` int NOT NULL,
  PRIMARY KEY (`design_id`),
  UNIQUE KEY `designId_UNIQUE` (`design_id`)
);


CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `type` varchar(45) NOT NULL,
  `phone_number` varchar(45) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `userid_UNIQUE` (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ;




