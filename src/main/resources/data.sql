DROP DATABASE IF EXISTS data_jpa;
CREATE DATABASE data_jpa;

USE data_jpa;

INSERT INTO data_jpa.role(id, name)
VALUES
    (1, 'ROLE_USER'),
    (2, 'ROLE_ADMIN');

INSERT INTO data_jpa.user(username, password)
VALUES
('admin@mail.com', 'admin');

INSERT INTO data_jpa.user_roles(user_id, roles_id)
VALUES
       (1, 2);
INSERT INTO data_jpa.user_roles(user_id, roles_id)
VALUES
       (1, 1);
