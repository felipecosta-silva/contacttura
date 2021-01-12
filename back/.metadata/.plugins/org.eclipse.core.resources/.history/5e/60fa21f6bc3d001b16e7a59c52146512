package com.Livrariahotel.Livrariahotel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Livrariahotel.Livrariahotel.model.Livrariahotel;
import com.Livrariahotel.Livrariahotel.repository.LivrariahotelRepository;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;

@RestController
@RequestMapping({"/Livrariahotel"})
public class LivrariahotelController {
	
//	private LivrariahotelRepository repository;
	private LivrariahotelRepository repository;
	
	LivrariahotelController(LivrariahotelRepository livrariahotelRepository){
		this.repository = livrariahotelRepository;
	}
	
	@GetMapping
	public List findAll(){
		return (List) repository.findAll();
	}
	
	@GetMapping(value = "{id}")
//	http://localhost:8090/livrariahotel/1		
	public ResponseEntity findById(@PathVariable long id) {
		return repository.findById(id)
			.map(record -> ResponseEntity.ok().body(record))
			.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Livrariahotel create(@RequestBody Livrariahotel livrariahotel) {
		return repository.save(livrariahotel);
	}
	
	
	@PutMapping(value = "{id}")
//	http://localhost:8090/contacttura/2	
	public ResponseEntity update(@PathVariable long id,  
			@RequestBody Livrariahotel livrariahotel) {
		return repository.findById(id)
				.map(record -> {
					record.setCnpj(livrariahotel.getCnpj());
					record.setNome(livrariahotel.getNome());
					record.setCapacidade(livrariahotel.getCapacidade());
					record.setRua(livrariahotel.getRua());
					record.setBairro(livrariahotel.getBairro());
					record.setCidade(livrariahotel.getCidade());
					record.setCep(livrariahotel.getCep());
					Livrariahotel update = repository.save(record);
					return ResponseEntity.ok().build();
					
				}).orElse(ResponseEntity.notFound().build());
	}
	
//	@DeleteMapping(path = {"/{id}"})
//
//	public ResponseEntity <?> delete(@PathVariable long id){
//		return repository.findById(id)
//				.map(record -> {
//					repository.deleteById(id);
//				return ResponseEntity.ok().body("Agenda de nome: " + record.getName() + " foi deletado com sucesso!");
//			}).orElse(ResponseEntity.ok().body("Id não localizado, coloque um id válido"));
//	}
//	
}
