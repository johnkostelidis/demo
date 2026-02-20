-- 1. Create the databases
CREATE DATABASE db_one;
CREATE DATABASE db_two;

-- 2. Connect to the first database
\c db_one

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100)
);

-- Insert 5 records into DB 1
INSERT INTO users (name) VALUES 
('James'), 
('Julia'), 
('Alice'), 
('Bob'), 
('Charlie');

-- 3. Connect to the second database
\c db_two

CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    product_name VARCHAR(100),
    customer_name VARCHAR(100)
);

-- Insert 5 records into DB 2
INSERT INTO orders (product_name, customer_name) VALUES 
('Laptop', 'Jack'), 
('Smartphone', 'Jill'), 
('Tablet', 'David'), 
('Monitor', 'Eve'), 
('Keyboard', 'Frank');