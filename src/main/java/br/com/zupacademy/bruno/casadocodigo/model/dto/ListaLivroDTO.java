package br.com.zupacademy.bruno.casadocodigo.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.bruno.casadocodigo.model.Livro;

public class ListaLivroDTO {

	private Long id;
	private String titulo;
	
	public ListaLivroDTO(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}
	
	
	public static List<ListaLivroDTO> toList(List<Livro> livros){
		return livros.stream().map(ListaLivroDTO::new).collect(Collectors.toList());
		
	}


	public Long getId() {
		return id;
	}


	public String getTitulo() {
		return titulo;
	}
	
	
	
}
