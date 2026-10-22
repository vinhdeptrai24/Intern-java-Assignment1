--1.bang departments --
CREATE TABLE departments(
    ID BIGSERIAL PRIMARY KEY,
    Code varchar(20) NOT NULL,
    Name varchar(100) NOT NULL,
    UNIQUE(Code)
);
--2.bang employees
CREATE TABLE employees
(
    ID BIGSERIAL PRIMARY KEY,
    code varchar(20) NOT NULL UNIQUE,
    name varchar(100) NOT NULL,
    email varchar(150) NOT NULL UNIQUE,
    salary NUMERIC(15, 2) NOT NULL CHECK (salary >= 0),
    hire_date DATE NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    department_id BIGINT,
    FOREIGN KEY (department_id) REFERENCES departments (ID)
);