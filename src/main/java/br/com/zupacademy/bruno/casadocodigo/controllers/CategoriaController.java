package br.com.zupacademy.bruno.casadocodigo.controllers;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.bruno.casadocodigo.model.Categoria;
import br.com.zupacademy.bruno.casadocodigo.model.forms.FormCategoria;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	private EntityManager em;
	
	@PostMapping
	public String create(@RequestBody @Valid FormCategoria formCategoria) {
		Categoria categoria = formCategoria.toModel();
		em.persist(categoria);
		return categoria.toString();		
	}

}
