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

import com.lara.testepratico.model.Deslocamento;
import com.lara.testepratico.repository.ConteinerRepository;
import com.lara.testepratico.repository.DeslocamentoRepository;

@RestController
@RequestMapping("/deslocamentos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DeslocamentoController {

	@Autowired
	private DeslocamentoRepository deslocamentorepository;

	@Autowired
	public ConteinerRepository conteinerrepository;

	// exibe todas as movimentações
	@GetMapping
	public ResponseEntity<List<Deslocamento>> getAll() {
		return ResponseEntity.ok(deslocamentorepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Deslocamento> getById(@PathVariable Long id) {
		return deslocamentorepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Deslocamento> postDeslocamento(@Valid @RequestBody Deslocamento deslocamento) {

		if (conteinerrepository.existsById(deslocamento.getConteiner().getId())) {
			return ResponseEntity.status(HttpStatus.CREATED).body(deslocamentorepository.save(deslocamento));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	@PutMapping
	public ResponseEntity<Deslocamento> putDeslocamento(@RequestBody Deslocamento deslocamento) {

		if (deslocamentorepository.existsById(deslocamento.getId())) {
			if (conteinerrepository.existsById(deslocamento.getConteiner().getId())) {
				return ResponseEntity.status(HttpStatus.OK).body(deslocamentorepository.save(deslocamento));
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDeslocamento(@PathVariable long id) {
		return deslocamentorepository.findById(id).map(resposta -> {
			deslocamentorepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}).orElse(ResponseEntity.notFound().build());

	}

}
