package com.lara.testepratico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.lara.testepratico.model.Deslocamento;

public interface DeslocamentoRepository extends JpaRepository <Deslocamento, Long> {
	
	public List <Deslocamento> findAllByMovimentacaoContainingIgnoreCase (String movimentacao);

}
