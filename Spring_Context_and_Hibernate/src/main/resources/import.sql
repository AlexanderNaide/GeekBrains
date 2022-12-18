CREATE DATABASE  IF NOT EXISTS `spring_hibernate`;
USE `spring_hibernate`;

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (`id` bigint NOT NULL AUTO_INCREMENT,`price` double NOT NULL,`title` varchar(255) NOT NULL,PRIMARY KEY (`id`),UNIQUE KEY `UK_8xtpej5iy2w4cte2trlvrlayy` (`title`)) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `products` WRITE;
INSERT INTO `products` VALUES (1,65.6,'Молоко'),(2,75.8,'Кефир'),(3,88.9,'Йогурт'),(4,49.9,'Хлеб'),(5,55.6,'Батон'),(6,244.9,'Огурцы'),(7,180,'Помидоры'),(8,139.99,'Бананы');
UNLOCK TABLES;

DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (`user_id` bigint NOT NULL,`product_id` bigint NOT NULL,KEY `FKsfqpk5xjv93po29vn4fmy5exq` (`product_id`),KEY `FKoj7ky1v8cf4ibkk0s7alikp52` (`user_id`),CONSTRAINT `FKoj7ky1v8cf4ibkk0s7alikp52` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),CONSTRAINT `FKsfqpk5xjv93po29vn4fmy5exq` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `purchase` WRITE;
INSERT INTO `purchase` VALUES (8,8),(8,4),(9,5),(9,2),(2,3),(2,4),(2,5),(4,4),(4,8),(4,3),(10,6),(10,8),(10,7),(1,2),(1,4),(1,4),(3,7),(3,2),(5,7),(7,1),(7,1),(7,2),(7,6),(7,7),(7,3);
UNLOCK TABLES;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (`id` bigint NOT NULL AUTO_INCREMENT,`name` varchar(255) NOT NULL,PRIMARY KEY (`id`),UNIQUE KEY `UK_3g1j96g94xpk3lpxl2qbl985x` (`name`)) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES (1,'user1'),(10,'user10'),(2,'user2'),(3,'user3'),(4,'user4'),(5,'user5'),(6,'user6'),(7,'user7'),(8,'user8'),(9,'user9');
UNLOCK TABLES;