-- Create the database
CREATE DATABASE IF NOT EXISTS employee_directory;

-- Use the created database
USE employee_directory;

-- Create the employee table
CREATE TABLE IF NOT EXISTS employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(45),
    last_name VARCHAR(45),
    email VARCHAR(45)
);

-- Create the authorities table
CREATE TABLE IF NOT EXISTS authorities (
    username VARCHAR(50),
    authority VARCHAR(50),
    PRIMARY KEY (username, authority) -- Composite primary key
);

-- Create the roles table
CREATE TABLE IF NOT EXISTS roles (
    user_id VARCHAR(50),
    role VARCHAR(50),
    PRIMARY KEY (user_id, role) -- Composite primary key
);
