package br.com.zupacademy.bruno.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.bruno.casadocodigo.exceptions.validators.CpfCnpj;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email
	@NotBlank
	@Column(unique = true, nullable = false)
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@CpfCnpj
	@Column(unique = true, nullable = false)
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	@ManyToOne
	private Pais pais;
	@ManyToOne
	private Estado estado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;

	public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento,
			String cidade, @NotNull Pais pais, String telefone, String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
		
	}

	
	
	


}
