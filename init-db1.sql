CREATE TABLE users (id SERIAL PRIMARY KEY, name VARCHAR(100), role VARCHAR(50));

INSERT INTO users (name, role) VALUES 
('James', 'teacher'), ('Julia', 'teacher'), ('Alice', 'teacher'), 
('Bob', 'teacher'), ('Charlie', 'teacher');