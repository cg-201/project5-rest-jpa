package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Student;
import com.capgemini.entities.Subject;
import com.capgemini.repository.StudentRepository;
import com.capgemini.repository.SubjectRepository;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {
	
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/{id}")
	public Subject findById(@PathVariable int id) {
		
		return subjectRepository.findById(id).get();
	}

	@PostMapping("/")
	public String create(@RequestBody Subject subject) {
		subjectRepository.save(subject);
		return "ok";
	}
	
	
	@PutMapping("/{subjectId}/students/{studentId}")
	public String enrollStudents(@PathVariable int subjectId, @PathVariable int studentId) {
	
		Subject subject = subjectRepository.findById(subjectId).get();
		Student student = studentRepository.findById(studentId).get();
		
		subject.getStudents().add(student);
		
		subjectRepository.save(subject);
		
		return "ok";
	}
}
