package br.com.zupacademy.bruno.casadocodigo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autores")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome", nullable=false)
	private String nome;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="descricao", nullable=false, length=400)
	private String descricao;
	
	@Column(name="instante", nullable=false)	
	private LocalDateTime instante;

	
	public Autor(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.instante = LocalDateTime.now();
	}


	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao + ", instante="
				+ instante + "]";
	}
	
	
	
	
	
	

}
