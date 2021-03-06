package com.lara.testepratico.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lara.testepratico.model.Conteiner;
import com.lara.testepratico.repository.ConteinerRepository;

@RestController
@RequestMapping("/conteiner")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ConteinerController {

	@Autowired
	public ConteinerRepository conteinerrepository;

	@GetMapping
	public ResponseEntity<List<Conteiner>> getAll() {
		return ResponseEntity.ok(conteinerrepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Conteiner> getById(@PathVariable Long id) {
		return conteinerrepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Conteiner> postConteiner(@Valid @RequestBody Conteiner conteiner) {
		return ResponseEntity.status(HttpStatus.CREATED).body(conteinerrepository.save(conteiner));
	}

	@PutMapping
	public ResponseEntity<Conteiner> putConteiner(@RequestBody Conteiner conteiner) {
		
		return conteinerrepository.findById(conteiner.getId())
				.map(resposta -> {
					return ResponseEntity.ok().body(conteinerrepository.save(conteiner));
				})
				.orElse(ResponseEntity.notFound().build());
	}
		

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteConteiner(@PathVariable long id) {
		
		return conteinerrepository.findById(id).map(resposta -> {
			conteinerrepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}).orElse(ResponseEntity.notFound().build());

	}
	
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity <List <Conteiner>> getByCategoria(@PathVariable String categoria)
	{
		return ResponseEntity.ok(conteinerrepository.findAllByCategoriaContainingIgnoreCase(categoria));
	}
	
	
	


}
