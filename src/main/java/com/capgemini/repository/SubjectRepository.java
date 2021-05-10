package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
