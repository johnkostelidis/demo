CREATE TABLE users (id SERIAL PRIMARY KEY, name VARCHAR(100), role VARCHAR(50));

INSERT INTO users (name, role) VALUES 
('Jack', 'student'), ('Jill', 'student'), ('David', 'student'), 
('Eve', 'student'), ('Frank', 'student');