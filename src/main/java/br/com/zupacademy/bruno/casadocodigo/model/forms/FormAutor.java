package br.com.zupacademy.bruno.casadocodigo.model.forms;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.zupacademy.bruno.casadocodigo.model.Autor;

public class FormAutor {

	@NotEmpty
	private String nome;
	
	@NotEmpty
	@Email
	private String email;
	
	@Size(max=400)
	@NotEmpty
	private String descricao;
	
	
	public FormAutor(String nome, String email, String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}


	public Autor novoAutor() {		
		return new Autor(this.nome, this.email, this.descricao);		
	}


	
}
