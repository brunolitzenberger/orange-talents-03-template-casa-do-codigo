package br.com.zupacademy.bruno.casadocodigo.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.bruno.casadocodigo.controllers.exceptions.DuplicatedValidator;
import br.com.zupacademy.bruno.casadocodigo.model.Autor;
import br.com.zupacademy.bruno.casadocodigo.model.forms.FormAutor;
import br.com.zupacademy.bruno.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	
	private final AutorRepository autorRepository;	
	private DuplicatedValidator duplicatedValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(duplicatedValidator);
	}
	
	public AutorController(AutorRepository autorRepository, DuplicatedValidator duplicatedValidator) {
		this.autorRepository = autorRepository;
		this.duplicatedValidator = duplicatedValidator;
	}
	
	@PostMapping
	@Transactional
	public String cadastrarAutor(@RequestBody @Valid FormAutor formAutor){		
		Autor autor = formAutor.novoAutor();	
		autorRepository.save(autor);
		return autor.toString();
		
	}
	
}
