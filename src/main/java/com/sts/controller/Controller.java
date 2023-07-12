package com.sts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.entity.Student;
import com.sts.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
public class Controller {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student st) {
		Student student = this.studentService.addStudent(st);
		return student;
	}
	@GetMapping("/all")
	public List<Student> getAllStudent(){
		List<Student> list = this.studentService.getAllStudent();
		return list;
	}
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable int id) {
		Student student = this.studentService.getStudentById(id);
		return student;
	}
	@PostMapping("/{id}")
	public Student updateStudent(@RequestBody Student st , @PathVariable int id) {
		Student student = this.studentService.updateStudent(st, id);
		return student;
	}
	@DeleteMapping("/{id}")
	public void deletestudent(@PathVariable int id) {
		this.studentService.deletestudent(id);
		System.out.println("Delete Student with id:" + id + "Succussfully");
	}

}
