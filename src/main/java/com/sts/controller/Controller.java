package com.sts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.entity.Student;
import com.sts.payload.ApiResponse;
import com.sts.payload.StudentDto;
import com.sts.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/students")
public class Controller {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add")
	public ResponseEntity<StudentDto> addStudent(@Valid @RequestBody StudentDto st) {
		System.out.println("student name before" + st.getName());
		StudentDto student = this.studentService.addStudent(st);
		System.out.println("student name after" + student.getName());
		return new ResponseEntity<StudentDto>(student , HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public List<StudentDto> getAllStudent(){
		List<StudentDto> list = this.studentService.getAllStudent();
		return list;
	}
	@GetMapping("/{id}")
	public StudentDto getStudentById(@PathVariable int id) {
		StudentDto student = this.studentService.getStudentById(id);
		return student;
	}
	@PostMapping("/{id}")
	public StudentDto updateStudent(@Valid @RequestBody StudentDto st , @PathVariable int id) {
		StudentDto student = this.studentService.updateStudent(st, id);
		return student;
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deletestudent(@PathVariable int id) {
		this.studentService.deletestudent(id);
		System.out.println("Delete Student with id:" + id + "Succussfully");
		ApiResponse api = new ApiResponse("Delete Student with id:" + id + " Succussfully" , true);
		return new ResponseEntity<ApiResponse>(api , HttpStatus.OK);
	}

}
