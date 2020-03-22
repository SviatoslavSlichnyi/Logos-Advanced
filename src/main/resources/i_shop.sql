DROP DATABASE i_shop;
CREATE DATABASE i_shop;
USE i_shop;

CREATE TABLE users
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    email      VARCHAR(75) NOT NULL UNIQUE,
    password   VARCHAR(75) NOT NULL,
    first_name VARCHAR(45) NOT NULL,
    last_name  VARCHAR(45) NOT NULL,
    role       VARCHAR(45) NOT NULL
);

CREATE TABLE products
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(75)   NOT NULL UNIQUE,
    description TEXT          NOT NULL,
    price       decimal(8, 2) NOT NULL
);

CREATE TABLE bucket
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    user_id       int       NOT NULL,
    product_id    INT       NOT NULL,
    purchase_date TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);

DESC users;
DESC products;
DESC bucket;


INSERT INTO users (email, password, first_name, last_name, role) VALUES
('admin', 'admin', 'admin', 'admin', 'ADMIN');