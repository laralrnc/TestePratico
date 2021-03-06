package com.lara.testepratico.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_conteiner")
public class Conteiner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 11, max = 11, message = "4 letras e 7 números. Ex: TEST1234567")
	@NotBlank
	private String codigoConteiner;

	@NotNull
	private int tipo;

	@NotBlank
	private String status;

	@NotBlank
	private String categoria;

	@ManyToOne
	@JsonIgnoreProperties("conteiner")
	private Cliente cliente;

	@ManyToOne
	@JsonIgnoreProperties("conteiner")
	private Deslocamento deslocamento;

	public Cliente getCliente() {
		return cliente;
	}

	public Deslocamento getDeslocamento() {
		return deslocamento;
	}

	public void setDeslocamento(Deslocamento deslocamento) {
		this.deslocamento = deslocamento;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoConteiner() {
		return codigoConteiner;
	}

	public void setCodigoConteiner(String codigoConteiner) {
		this.codigoConteiner = codigoConteiner;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
