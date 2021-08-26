CREATE TABLE `client` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `full_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `tel_number` int NOT NULL
);

CREATE TABLE `technic` (
  `id` int PRIMARY KEY,
  `model` varchar(25) NOT NULL,
  `brand_id` int
);

CREATE TABLE `work` (
  `id` int PRIMARY KEY NOT NULL,
  `title` varchar(50) NOT NULL,
  `price` double NOT NULL
);

CREATE TABLE `orders` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `technic_id` int NOT NULL,
  `client_id` int NOT NULL,
  `order_status` ENUM ('NEW', 'IN_WORK', 'READY') NOT NULL,
  `last_modified_by` int
);

CREATE TABLE `part` (
  `part_number` varchar(10) PRIMARY KEY NOT NULL,
  `title` varchar(50) NOT NULL,
  `price` double NOT NULL
);

CREATE TABLE `order_parts` (
  `part_number` varchar(10) NOT NULL,
  `order_id` int NOT NULL,
  PRIMARY KEY (`part_number`, `order_id`)
);

CREATE TABLE `order_works` (
  `order_id` int NOT NULL,
  `work_id` int NOT NULL,
  PRIMARY KEY (`order_id`, `work_id`)
);

CREATE TABLE `user` (
  `id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `full_name` varchar(50) NOT NULL,
  `email` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `role` ENUM ('ROLE_ENGINEER', 'ROLE_ADMIN', 'ROLE_RECEPTION', 'ROLE_CEO') NOT NULL
);

CREATE TABLE `brand` (
  `id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL
);

ALTER TABLE `technic` ADD FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`);

ALTER TABLE `orders` ADD FOREIGN KEY (`technic_id`) REFERENCES `technic` (`id`);

ALTER TABLE `orders` ADD FOREIGN KEY (`client_id`) REFERENCES `client` (`id`);

ALTER TABLE `orders` ADD FOREIGN KEY (`last_modified_by`) REFERENCES `user` (`id`);

ALTER TABLE `order_parts` ADD FOREIGN KEY (`part_number`) REFERENCES `part` (`part_number`);

ALTER TABLE `order_parts` ADD FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

ALTER TABLE `order_works` ADD FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

ALTER TABLE `order_works` ADD FOREIGN KEY (`work_id`) REFERENCES `work` (`id`);
