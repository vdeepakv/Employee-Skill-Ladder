//Creates a neew database iff it doesn't exist
CREATE DATABASE IF NOT EXISTS deepakdb;
USE deepakdb;

  //Create the employees table
CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(50),
    skillLevel INT
);

//Insert sample data into the employees table
INSERT INTO employees (id, name, department, skillLevel)
VALUES
    (1, 'John Doe', 'IT', 3),
    (2, 'Jane Smith', 'HR', 2),
    (3, 'Michael Johnson', 'Finance', 4)
;
