package br.com.zupacademy.bruno.casadocodigo.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.bruno.casadocodigo.model.Pais;
import br.com.zupacademy.bruno.casadocodigo.model.forms.FormPais;

@RestController
@RequestMapping("/pais")
public class PaisController {
	
	@PersistenceContext
	private EntityManager em;

	@PostMapping
	@Transactional
	public String criaPais(@RequestBody @Valid FormPais formPais) {
		Pais novoPais = formPais.toModel();
		em.persist(novoPais);
		return novoPais.toString();
	}
	

}
