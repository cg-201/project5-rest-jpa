package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Employee;
import com.capgemini.repository.EmployeeRepository;

// http://localhost:8080/api/employee
@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	// http://localhost:8080/api/employee/
	@PostMapping("/")
	public String createEmployee(@RequestBody Employee employee) {
		
		employeeRepository.save(employee);
		return "Employee Created!";
	}
	
	
	
	
}
