package br.com.zupacademy.bruno.casadocodigo.controllers;

import javax.validation.constraints.NotBlank;

public class FormCategoria {
	
	@NotBlank
	private String nome;	
	
	public FormCategoria() {
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}

	public String getNome() {
		return this.nome;
	}
	
}
