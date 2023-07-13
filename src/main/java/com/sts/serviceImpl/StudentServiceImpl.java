package com.sts.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.entity.Student;
import com.sts.exception.ResourceNotFoundException;
import com.sts.payload.StudentDto;
import com.sts.repositories.StudentRepository;
import com.sts.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public StudentDto addStudent(StudentDto st) {
		Student student = this.studentRepo.save(this.mapper.map(st, Student.class));
		return this.mapper.map(student, StudentDto.class);
	}

	@Override
	public List<StudentDto> getAllStudent() {
		List<Student> list = this.studentRepo.findAll();
		List<StudentDto> collect = list.stream().map(p -> this.mapper.map(p, StudentDto.class)).collect(Collectors.toList());
		
		return collect;
	}

	@Override
	public StudentDto getStudentById(int id) {
		Student student = this.studentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student", "id", id));
		return this.mapper.map(student, StudentDto.class);
	}

	@Override
	public StudentDto updateStudent(StudentDto st, int id) {
		
		Student student = this.studentRepo.findById(id).get();
		
		student.setAbout(st.getAbout());
		student.setAddress(st.getAddress());
		student.setName(st.getName());
		
		Student save = this.studentRepo.save(student);
		
		return this.mapper.map(save, StudentDto.class);
	}

	@Override
	public void deletestudent(int id) {
		Student student = this.studentRepo.findById(id).get();
		this.studentRepo.delete(student);
	}

}
