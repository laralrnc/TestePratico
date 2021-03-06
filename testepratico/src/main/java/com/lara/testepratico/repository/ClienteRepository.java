package com.lara.testepratico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import com.lara.testepratico.model.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {
	
	public List <Cliente> findAllByClienteContainingIgnoreCase(String cliente);
	

}


