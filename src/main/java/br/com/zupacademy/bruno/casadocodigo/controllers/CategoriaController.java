package br.com.zupacademy.bruno.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.bruno.casadocodigo.model.Categoria;
import br.com.zupacademy.bruno.casadocodigo.model.forms.FormCategoria;
import br.com.zupacademy.bruno.casadocodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	private final CategoriaRepository categoriaRepository;
	
	public CategoriaController(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	@PostMapping
	public String create(@RequestBody @Valid FormCategoria formCategoria) {
		Categoria categoria = formCategoria.toModel();
		categoriaRepository.save(categoria);
		return categoria.toString();		
	}

}
