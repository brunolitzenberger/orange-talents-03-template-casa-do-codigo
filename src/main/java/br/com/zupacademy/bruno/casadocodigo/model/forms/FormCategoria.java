package br.com.zupacademy.bruno.casadocodigo.model.forms;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.bruno.casadocodigo.exceptions.validators.UniqueValue;
import br.com.zupacademy.bruno.casadocodigo.model.Categoria;

public class FormCategoria {
	
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Categoria já cadastrada.")
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
