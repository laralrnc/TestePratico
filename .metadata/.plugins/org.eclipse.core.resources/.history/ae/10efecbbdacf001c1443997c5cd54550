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

import com.lara.testepratico.model.Cliente;
import com.lara.testepratico.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins="*",allowedHeaders="*")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienterepository;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getAll() {
		return ResponseEntity.ok(clienterepository.findAll());

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Long id) {
		return clienterepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Cliente> postCliente(@Valid @RequestBody Cliente cliente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienterepository.save(cliente));
	}
	
	@PutMapping
	public ResponseEntity<Cliente> putCliente(@Valid @RequestBody Cliente cliente) {
					
		return clienterepository.findById(cliente.getId())
				.map(resposta -> {
					return ResponseEntity.ok().body(clienterepository.save(cliente));
				})
				.orElse(ResponseEntity.notFound().build());

	}
	
}
