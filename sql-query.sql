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

SELECT * FROM project.architect;
SELECT designs.design_id, designs.design_name, designs.design_url, designs.price, designs.description, designs.no_of_rooms,architect.architect_id, architect.name, architect.phone_number, architect.email, architect.experience FROM designs INNER JOIN architect ON designs.architect_id = architect.architect_id WHERE designs.is_deleted = 0;

SELECT * FROM USER WHERE email AND is_deleted = 0;

CREATE TABLE assets (
    asset_id INT NOT NULL AUTO_INCREMENT,
    design_id INT NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    FOREIGN KEY (design_id) REFERENCES designs(design_id),
    PRIMARY KEY (asset_id)
);

CREATE TABLE designs (
    design_id INT PRIMARY KEY AUTO_INCREMENT,
    design_name VARCHAR(255) NOT NULL,
    style VARCHAR(255) NOT NULL,
    price_per_sqFt DOUBLE NOT NULL,
    square_feet INT NOT NULL,
    category VARCHAR(255) NOT NULL,
    floorplan VARCHAR(255) NOT NULL,
    time_required VARCHAR(255) NOT NULL,
    bio VARCHAR(255) NOT NULL,
    brief TEXT NOT NULL,
    is_deleted BOOLEAN NOT NULL,
    architect_id INT NOT NULL,
    FOREIGN KEY (architect_id) REFERENCES architect(architect_id)
);

