package br.com.zupacademy.bruno.casadocodigo.model.forms;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.bruno.casadocodigo.model.Autor;
import br.com.zupacademy.bruno.casadocodigo.model.Categoria;
import br.com.zupacademy.bruno.casadocodigo.model.Livro;

public class FormLivro {


	@NotBlank
	private String titulo;

	@NotBlank
	@Length(max = 500)
	private String resumo;
	
	@NotBlank
	private String sumario;

	@NotNull
	@Min(20)
	private BigDecimal preco;

	@NotNull
	@Min(100)
	private Integer numeroDePaginas;

	@NotBlank
	private String isbn;
	
	@Future
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;

	@NotNull
	private Long categoria_id;

	@NotNull
	private Long autor_id;

	public FormLivro(@NotBlank String titulo, @NotBlank @Max(500) String resumo, @NotBlank String sumario,
			@NotBlank @Min(20) BigDecimal preco, @NotBlank @Min(100) Integer numeroDePaginas, @NotBlank String isbn,
			 @NotNull  Long categoria_id, @NotNull Long autor_id) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.categoria_id = categoria_id;
		this.autor_id = autor_id;
	}
	
	public Livro novoLivro(EntityManager em) {
		Autor autor = em.find(Autor.class, this.autor_id);
		Categoria categoria = em.find(Categoria.class, categoria_id);
		return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroDePaginas, this.isbn, this.dataPublicacao, categoria, autor);
	}
	
	
	
}
