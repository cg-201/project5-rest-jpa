package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.Employee;
import com.capgemini.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
