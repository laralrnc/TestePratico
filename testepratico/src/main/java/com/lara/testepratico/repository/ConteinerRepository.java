package com.lara.testepratico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lara.testepratico.model.Conteiner;

@Repository
public interface ConteinerRepository extends JpaRepository <Conteiner, Long> {
	
	List <Conteiner> findAllByCategoriaContainingIgnoreCase(String nome);

}
