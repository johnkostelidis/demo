CREATE TABLE students (id SERIAL PRIMARY KEY, name VARCHAR(100), role VARCHAR(50));

INSERT INTO students (name, role) VALUES 
('Jack', 'student'), ('Jill', 'student'), ('David', 'student'), 
('Eve', 'student'), ('Frank', 'student');