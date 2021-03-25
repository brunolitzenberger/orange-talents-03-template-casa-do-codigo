package br.com.zupacademy.bruno.casadocodigo.controllers;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zupacademy.bruno.casadocodigo.model.Estado;
import br.com.zupacademy.bruno.casadocodigo.model.forms.FormEstado;

@RestController
@RequestMapping("/estados")
public class NovoEstadoController {
	
	@Autowired
	private EntityManager em;

	@PostMapping
	@Transactional
	public ResponseEntity<String> criaEstado(@RequestBody @Valid FormEstado formEstado) {
		Estado estado = formEstado.toModel(em);
		if(estado == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum pais encontrado com este id");
		}
		em.persist(estado);
		return ResponseEntity.ok(estado.toString());
	}

}
