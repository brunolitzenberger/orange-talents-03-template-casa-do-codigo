package br.com.zupacademy.bruno.casadocodigo.controllers;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zupacademy.bruno.casadocodigo.model.Cliente;
import br.com.zupacademy.bruno.casadocodigo.model.forms.FormCliente;

@RestController
@RequestMapping
public class NovoClienteController {
	
	@Autowired
	private EntityManager em;

	@PostMapping("/clientes")
	@Transactional
	public ResponseEntity<?> create(@RequestBody @Valid FormCliente formCliente) {
		Cliente cliente = formCliente.toModel(em);
		em.persist(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/clientes/" + cliente.getId()).build().toUri();
		return ResponseEntity.ok().body(uri);

	}
	
	}
