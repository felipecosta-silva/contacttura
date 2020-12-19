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
		contactturaUser.setPassword(criptoPassword(contactturaUser.getPassword()));
		return repository.save(contactturaUser);
	}
	
	///Update
	@PutMapping(value = "{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id,
			@RequestBody ContactturaUser contactturaUser) {
		return repository.findById(id)
				.map(record -> {
					
					record.setName(contactturaUser.getName());
					record.setUsername(contactturaUser.getUsername());
					record.setPassword(criptoPassword(contactturaUser.getPassword()));
					record.setAdmin(false);
					
					ContactturaUser update = repository.save(record);
					
					return ResponseEntity.ok().body("Usuário" + update.getUsername()+ " de nome "+update.getName()+" foi atualizado com sucesso!! \n\n");
				}).orElse(ResponseEntity.notFound().build());
	}
	
	
	@DeleteMapping(path = {"/{id}"})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity <?> delete(@PathVariable long id){
		return repository.findById(id)
				.map(record -> {
					repository.deleteById(id);
					
					return ResponseEntity.ok().body(" Usuário "  + record.getUsername() +  " foi deletado com sucesso!");
					}).orElse(ResponseEntity.ok().body("Usuário informado não esta na lista de cadastrados\n Por favor, tente novamente com um usuário válido."));
	}

	//Metodo para criptografar senha
	private String criptoPassword (String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String passwordCripto = passwordEncoder.encode(password);
		
		return passwordCripto;

	}
}

	


