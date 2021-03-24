package br.com.zupacademy.bruno.casadocodigo.model.forms;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.bruno.casadocodigo.exceptions.validators.UniqueValue;
import br.com.zupacademy.bruno.casadocodigo.model.Pais;

public class FormPais {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public Pais toModel() {
		return new Pais(nome);
	}

}
