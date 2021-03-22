package br.com.zupacademy.bruno.casadocodigo.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.bruno.casadocodigo.model.Autor;
import br.com.zupacademy.bruno.casadocodigo.model.forms.FormAutor;
import br.com.zupacademy.bruno.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	private AutorRepository autorRepository;	
	private DuplicatedEmailValidator duplicatedEmailValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		//1
		binder.addValidators(duplicatedEmailValidator);
	}
	
	public AutorController(AutorRepository autorRepository, DuplicatedEmailValidator proibeEmailDuplicadoAutorValidator) {
		this.autorRepository = autorRepository;
		this.duplicatedEmailValidator = proibeEmailDuplicadoAutorValidator;
	}
	
	@PostMapping
	@Transactional
	public String cadastrarAutor(@RequestBody @Valid FormAutor formAutor){		
		Autor autor = formAutor.novoAutor();			
		autorRepository.save(autor);
		return autor.toString();
		
	}
	
}
