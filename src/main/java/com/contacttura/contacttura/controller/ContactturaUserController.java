package com.contacttura.contacttura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contacttura.contacttura.model.ContactturaUser;
import com.contacttura.contacttura.repository.ContactturaUserRepository;

@RestController
@RequestMapping({"/user"})
public class ContactturaUserController {
	@Autowired
	private ContactturaUserRepository repository;
	
	
	//List
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}
	
	//Find by Id
	@GetMapping(value = "{id}")
	public ResponseEntity findById(@PathVariable long id) {
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//Create
	@PostMapping
	public ContactturaUser create(@RequestBody ContactturaUser contactturaUser) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		passwordEncoder.encode("root");
		return repository.save(contactturaUser);
	}
	
	///Update
	@PutMapping(value = "{id}")
	public ResponseEntity<ContactturaUser> update(@PathVariable("id") long id,
			@RequestBody ContactturaUser contactturaUser) {
		return repository.findById(id)
				.map(record -> {
					record.setName(contactturaUser.getName());
					record.setUsername(contactturaUser.getUsername());
					ContactturaUser update = repository.save(record);
					return ResponseEntity.ok().body(update);
					
				}).orElse(ResponseEntity.notFound().build());
	}
	
	
	@DeleteMapping(path = {"/{id}"})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity <?> delete(@PathVariable long id){
		return repository.findById(id)
				.map(record -> {
					repository.deleteById(id);
					
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.ok().build());
	}

}
