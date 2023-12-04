CREATE DATABASE programming_code_has_error;
USE programming_code_has_error;

CREATE TABLE student (
	id INT PRIMARY KEY AUTO_INCREMENT,
	full_name VARCHAR(200) NOT NULL,
	student_code VARCHAR(10) UNIQUE,
	address VARCHAR(200),
	birthday DATETIME
);

INSERT INTO `student` (`id`, `full_name`, `student_code`, `address`, `birthday`) VALUES
	(1, 'Taylor Swift', 'sdfsdf88', 'United State', '1989-12-13 10:07:05'),
	(3, 'Charlie Puth', 'sdfsdf86', 'United State', '1991-12-02 10:07:05'),
	(4, 'Leonardo DiCaprio', 'a875642', 'Italy', '1974-11-11 10:07:05');