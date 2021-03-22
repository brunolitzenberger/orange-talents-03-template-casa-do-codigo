package br.com.zupacademy.bruno.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.bruno.casadocodigo.exceptions.validators.DuplicatedCategoriaValidator;
import br.com.zupacademy.bruno.casadocodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	private final CategoriaRepository categoriaRepository;
	private final DuplicatedCategoriaValidator duplicatedCategoriaValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		//1
		binder.addValidators(duplicatedCategoriaValidator);
	}
	
	public CategoriaController(CategoriaRepository categoriaRepository, DuplicatedCategoriaValidator duplicatedCategoriaValidator) {
		this.categoriaRepository = categoriaRepository;
		this.duplicatedCategoriaValidator = duplicatedCategoriaValidator;
	}
	
	@PostMapping
	public String create(@RequestBody @Valid FormCategoria formCategoria) {
		Categoria categoria = formCategoria.toModel();
		categoriaRepository.save(categoria);
		return categoria.toString();		
	}

}
