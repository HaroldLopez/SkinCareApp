CREATE DATABASE skincare_db;

USE skincare_db;

CREATE TABLE producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    marca VARCHAR(100),
    precio DECIMAL(10,2),
    categoria VARCHAR(100)
);
