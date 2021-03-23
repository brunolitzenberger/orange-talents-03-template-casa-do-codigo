package br.com.zupacademy.bruno.casadocodigo.model.dto;

import java.text.NumberFormat;
import java.time.LocalDate;

import br.com.zupacademy.bruno.casadocodigo.model.Livro;

public class LivroDTO {

	private String titulo;
	private String resumo;
	private String sumario;
	private String preco;
	private Integer numeroDePaginas;
	private String isbn;
	private LocalDate dataPublicacao;
	private AutorDTO autor;

	public LivroDTO(Livro livro) {
		super();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = NumberFormat.getCurrencyInstance().format(livro.getPreco());
		this.numeroDePaginas = livro.getNumeroDePaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.autor = new AutorDTO(livro.getAutor());
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public String getPreco() {
		return preco;
	}

	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public AutorDTO getAutor() {
		return autor;
	}
	
	
	

}
