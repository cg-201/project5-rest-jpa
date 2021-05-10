package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Student;
import com.capgemini.repository.StudentRepository;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/{id}")
	public Student findStudentById(@PathVariable int id) {
		
		return studentRepository.findById(id).get();
	}

	@PostMapping("/")
	public String create(@RequestBody Student student) {
		studentRepository.save(student);
		return "ok";
	}
}
