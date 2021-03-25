package br.com.zupacademy.bruno.casadocodigo.model.forms;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.bruno.casadocodigo.exceptions.validators.CountryState;
import br.com.zupacademy.bruno.casadocodigo.exceptions.validators.CpfCnpj;
import br.com.zupacademy.bruno.casadocodigo.exceptions.validators.ExistId;
import br.com.zupacademy.bruno.casadocodigo.exceptions.validators.UniqueValue;
import br.com.zupacademy.bruno.casadocodigo.model.Cliente;
import br.com.zupacademy.bruno.casadocodigo.model.Estado;
import br.com.zupacademy.bruno.casadocodigo.model.Pais;

@CountryState
public class FormCliente {

	@Email
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "email", message = "Email já cadastrado no sistema.")
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento", message = "CPF/CNPJ já cadastrado no sitema.")
	@CpfCnpj
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	@ExistId(domainClass = Pais.class, fieldName = "id")
	private Long paisId;

	private Long estadoId;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;

	public FormCliente(String email, String nome, String sobrenome, String documento, String endereco,
			String complemento, String cidade, Long paisId, Long estadoId, String telefone, String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisId = paisId;
		this.estadoId = estadoId;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Cliente toModel(EntityManager em) {
		Cliente cliente =  new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, em.find(Pais.class, paisId), telefone, cep);
		if(estadoId != null) {
			cliente.setEstado(em.find(Estado.class, estadoId));
		}
		return cliente;
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

	public Long getPais() {
		return paisId;
	}

	public Long getEstado() {
		return estadoId;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

}
