-- 1. Thêm phòng ban và CHỈ ĐỊNH RÕ ID là 1, 2, 3
INSERT INTO departments (id, code, name) VALUES
(1, 'DEV', 'Phòng Lập trình'),
(2, 'QA', 'Phòng Kiểm thử'),
(3, 'HR', 'Phòng Nhân sự');

-- 2. Thêm nhân viên tham chiếu đúng đến các ID 1 và 2 vừa tạo
INSERT INTO employees (code, name, email, salary, hire_date, active, department_id) VALUES
-- Nhân viên phòng DEV (department_id = 1)
('E001', 'Nguyễn Văn A', 'nva@example.com', 1500.00, '2023-01-10', true, 1),
('E002', 'Trần Thị B', 'ttb@example.com', 1800.50, '2023-02-15', true, 1),
('E003', 'Lê Văn C', 'lvc@example.com', 2200.00, '2023-03-20', true, 1),
('E010', 'Đặng Thị K', 'dtk@example.com', 2500.00, '2023-10-01', true, 1),

-- Nhân viên phòng QA (department_id = 2)
('E004', 'Phạm Thị D', 'ptd@example.com', 1300.00, '2023-04-05', true, 2),
('E005', 'Hoàng Văn E', 'hve@example.com', 1450.75, '2023-05-12', true, 2),

-- Nhân viên inactive (active = false)
('E006', 'Vũ Thị F', 'vtf@example.com', 1600.00, '2023-06-18', false, 1),
('E007', 'Ngô Văn G', 'nvg@example.com', 1400.00, '2023-07-22', false, 2),

-- Nhân viên chưa có phòng ban (department_id = NULL)
('E008', 'Đoàn Thị H', 'dth@example.com', 1900.25, '2023-08-30', true, NULL),
('E009', 'Bùi Văn I', 'bvi@example.com', 2100.00, '2023-09-14', true, NULL);