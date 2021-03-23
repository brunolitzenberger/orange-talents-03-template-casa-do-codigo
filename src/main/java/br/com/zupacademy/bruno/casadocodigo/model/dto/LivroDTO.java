package br.com.zupacademy.bruno.casadocodigo.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.bruno.casadocodigo.model.Livro;

public class LivroDTO {

	private Long id;
	private String titulo;
	
	public LivroDTO(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}
	
	
	public static List<LivroDTO> toList(List<Livro> livros){
		return livros.stream().map(LivroDTO::new).collect(Collectors.toList());
		
	}


	public Long getId() {
		return id;
	}


	public String getTitulo() {
		return titulo;
	}
	
	
	
}
