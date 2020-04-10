DROP DATABASE IF EXISTS data_jpa;
CREATE DATABASE data_jpa;

USE data_jpa;

INSERT INTO data_jpa.role(id, name)
VALUES
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_USER');
