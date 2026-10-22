--1.Lấy toàn bộ nhân viên.
SELECT * FROM employees;
--2.
SELECT * FROM employees
WHERE active=TRUE;
--3.
SELECT * FROM employees
WHERE salary>10000000;
--4
SELECT * FROM employees
WHERE name LIKE "%Văn%";
--5
SELECT * FROM employees
ORDER BY salary DESC,name ASC;
--6
SELECT * FROM employees
WHERE salary >10000000 AND salary<20000000;
--7
SELECT * FROM employees
ORDER BY salary DESC LIMIT 5;
--8
SELECT e.code,e.name,e.salary,d.Name
FROM employees e
LEFT JOIN Departments d ON e.department_id=d.ID;
--9
SELECT
d.ID,
d.Name,
COUNT(e.id) AS employee_count,
AVG(e.salary) AS avg_salary,
SUM(e.salary) AS total_salary
FROM departments d
LEFT JOIN employees e ON d.ID = e.department_id
GROUP BY d.ID, d.Name;
--10
SELECT
d.ID,
d.Name
FROM Departments d
LEFT JOIN Employees e ON d.ID=e.department_id
WHERE active=TRUE
GROUP BY d.ID,d.Name
HAVING COUNT(e.ID)>=2;
--11
SELECT * FROM employees WHERE department_id IS NULL;
--12
SELECT * FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

--2.1
INSERT INTO departments (ID,Code, Name)
VALUES (4,'MKT', 'Phòng Marketing');
--2.2
INSERT INTO employees (code, name, email, salary, hire_date, active, department_id)
VALUES ('E011', 'Lê Văn K', 'k.le@example.com', 12500000.00, '2024-05-01', TRUE,
        (SELECT ID FROM departments WHERE code = 'MKT'));

--2.3
UPDATE employees
SET email = 'new_a.nguyen@example.com'
WHERE code = 'E001';
--2.4
UPDATE employees
SET salary = salary * 1.10
WHERE department_id = (SELECT ID FROM departments WHERE Code = 'DEV');

--2.5
UPDATE employees
SET active = FALSE
WHERE code = 'E002';
--2.6
DELETE FROM employees WHERE code = 'E011';