package br.com.zupacademy.bruno.casadocodigo.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.bruno.casadocodigo.model.Autor;
import br.com.zupacademy.bruno.casadocodigo.model.forms.FormAutor;

@RestController
@RequestMapping("/autores")
public class NovoAutorController {
	
	@PersistenceContext
	private EntityManager em;

	@PostMapping
	@Transactional
	public String cadastrarAutor(@RequestBody @Valid FormAutor formAutor) {
		Autor autor = formAutor.novoAutor();
		em.persist(autor);
		return autor.toString();

	}

}
