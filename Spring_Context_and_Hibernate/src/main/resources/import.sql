-- Если нужны преднастройки БД(создать таблицы, внести какие-то стартовые данные), то вносить их тут

-- CREATE DATABASE  IF NOT EXISTS `spring_hibernate`;

-- DROP TABLE if exists purchase CASCADE;
-- CREATE TABLE purchase (user_id BIGINT, product_id BIGINT, FOREIGN KEY (fk_us) REFERENCES users (id), FOREIGN KEY (fk_pr) REFERENCES products (id));
-- INSERT INTO purchase (user_id, product_id) VALUES (3, 2), (7, 1), (6, 3), (2, 5), (4, 4);