
CREATE DATABASE IF NOT EXISTS university;
USE university;
CREATE TABLE IF NOT EXISTS student (
                                       studentId INT UNSIGNED PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL,
                                       email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS course (
                                      courseId INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                                      name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS studentCourses (
                                              studentId INT UNSIGNED,
                                              courseId INT UNSIGNED,
                                              PRIMARY KEY (studentId, courseId),
                                              CONSTRAINT fk_student
                                                  FOREIGN KEY (studentId) REFERENCES student(studentId) ON DELETE CASCADE ON UPDATE CASCADE,
                                              CONSTRAINT fk_course
                                                  FOREIGN KEY (courseId) REFERENCES course(courseId) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW CREATE TABLE student;
SHOW CREATE TABLE studentCourses;
SHOW CREATE TABLE course;
