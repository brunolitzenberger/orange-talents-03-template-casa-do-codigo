package br.com.zupacademy.bruno.casadocodigo.model.forms;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.bruno.casadocodigo.exceptions.validators.ExistId;
import br.com.zupacademy.bruno.casadocodigo.exceptions.validators.UniqueCountry;
import br.com.zupacademy.bruno.casadocodigo.model.Estado;
import br.com.zupacademy.bruno.casadocodigo.model.Pais;

@UniqueCountry
public class FormEstado {

	@NotBlank
	private String nome;

	@ExistId(domainClass = Pais.class, fieldName = "id")
	private Long paisId;

	public String getNome() {
		return nome;
	}

	public Long getPaisId() {
		return paisId;
	}

	public Estado toModel(EntityManager em) {
		return new Estado(nome, em.find(Pais.class, paisId));
	}

}
