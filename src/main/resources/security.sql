CREATE DATABASE security;

CREATE TABLE IF NOT EXISTS product
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    cost NUMERIC(10, 2) NOT NULL
    );

CREATE TABLE IF NOT EXISTS users
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role     VARCHAR(255) NOT NULL
    );


CREATE UNIQUE INDEX idx_unique_user_name ON users (name);


CREATE UNIQUE INDEX idx_unique_product_name ON product (name);

INSERT INTO users (name, password, role)
VALUES ('lina', 'hashed_password_for_lina', 'role_admin');

INSERT INTO users (name, password, role)
VALUES ('max', 'hashed_password_for_max', 'role_user');
