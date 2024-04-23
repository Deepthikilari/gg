package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.StudentPojo;
import com.example.demo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentrepo;

	public List<StudentPojo> getalldetails() {
		return studentrepo.findAll();
	}

	public String create(StudentPojo student) {
		studentrepo.save(student);
		return "student has added";

	}

	public StudentPojo update(int id, StudentPojo student) {
		student.setId(id);
		return studentrepo.save(student);

	}

	public void  delete(int id) {
		studentrepo.deleteById(id);

	}

}
