package com.sts.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.entity.Student;
import com.sts.repositories.StudentRepository;
import com.sts.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public Student addStudent(Student st) {
		Student student = this.studentRepo.save(st);
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> list = this.studentRepo.findAll();
		return list;
	}

	@Override
	public Student getStudentById(int id) {
		Student student = this.studentRepo.findById(id).get();
		return student;
	}

	@Override
	public Student updateStudent(Student st, int id) {
		Student student = this.studentRepo.findById(id).get();
		student.setAbout(st.getAbout());
		student.setAddress(st.getAddress());
		student.setName(st.getName());
		Student save = this.studentRepo.save(student);
		return save;
	}

	@Override
	public void deletestudent(int id) {
		Student student = this.studentRepo.findById(id).get();
		this.studentRepo.delete(student);
	}

}
