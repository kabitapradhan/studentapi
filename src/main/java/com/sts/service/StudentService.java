package com.sts.service;

import java.util.List;

import com.sts.entity.Student;
import com.sts.payload.StudentDto;

public interface StudentService {
	
	public StudentDto addStudent(StudentDto st);
	public List<StudentDto> getAllStudent();
	public StudentDto getStudentById(int id);
	public StudentDto updateStudent(StudentDto st , int id);
	public void deletestudent(int id);

}
