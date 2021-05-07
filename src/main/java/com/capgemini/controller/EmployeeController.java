package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@GetMapping("/")
	public List<Employee> getEmployee() {
		return employeeRepository.findAll();
	}

	// http://localhost:8080/api/employee/{id}
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable int id) {

		return employeeRepository.findById(id).get();
	}

	// http://localhost:8080/api/employee/
	@PostMapping("/")
	public String createEmployee(@RequestBody Employee employee) {

		employeeRepository.save(employee);
		return "Employee Created!";
	}

	// http://localhost:8080/api/employee/{id}
	@PutMapping("/{id}")
	public String updateEmployee(@PathVariable int id, @RequestBody Employee e) {

		Employee dbEmployee = employeeRepository.findById(id).get();

		if (dbEmployee != null) {
			dbEmployee.setEmail(e.getEmail());
			// dbEmployee.setMobile(e.getMobile());
			// dbEmployee.setName(e.getName());

			employeeRepository.save(dbEmployee);
		}

		return "Record Updated";
	}

	// http://localhost:8080/api/employee/{id}
	@DeleteMapping("/{id}")
	public String deleteRecord(@PathVariable int id) {

		employeeRepository.deleteById(id);

		return "Record Deleted";
	}

}
