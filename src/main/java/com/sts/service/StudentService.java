package com.sts.service;

import java.util.List;

import com.sts.entity.Student;

public interface StudentService {
	
	public Student addStudent(Student st);
	public List<Student> getAllStudent();
	public Student getStudentById(int id);
	public Student updateStudent(Student st , int id);
	public void deletestudent(int id);

}
