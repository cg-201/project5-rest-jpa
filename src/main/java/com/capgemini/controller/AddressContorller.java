package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Address;
import com.capgemini.repository.AddressRepository;

@RestController
@RequestMapping("/api/address/")
public class AddressContorller {

	@Autowired
	private AddressRepository addressRepository; 

	@GetMapping("/")
	public List<Address> finalAllAddress() {
		return addressRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Address findAddressById(@PathVariable int id) {
		
		return addressRepository.findById(id).get();
	}
	
	
	
}
