package br.com.zupacademy.bruno.casadocodigo.controllers;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.bruno.casadocodigo.model.Livro;
import br.com.zupacademy.bruno.casadocodigo.model.forms.FormLivro;

@RestController
@RequestMapping("/livro")
public class LivroController {
	@PersistenceContext
	private EntityManager em;
	
	@PostMapping
	@Transactional
	public String create(@RequestBody @Valid FormLivro formLivro) {
		System.out.println(LocalDate.now());
		Livro livro = formLivro.novoLivro(em);
		em.persist(livro);
		return livro.toString();
		
	}
	
}