package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
