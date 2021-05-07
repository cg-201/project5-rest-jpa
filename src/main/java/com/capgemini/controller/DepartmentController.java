package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Department;
import com.capgemini.repository.DepartmentRepository;

@RestController
@RequestMapping("/api/department/")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	@GetMapping("/")
	public List<Department> finalAll() {
		
		return departmentRepository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Department findById(@PathVariable int id) {
		
		return departmentRepository.findById(id).get();
	}
	
	
	@PostMapping("/")
	public String createDeparment(@RequestBody Department department) {
		
		departmentRepository.save(department);
		return "Deparment Added";
	}

}
