package br.com.zupacademy.bruno.casadocodigo.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

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

	public AutorController(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	@PostMapping
	@Transactional
	public String cadastrarAutor(@RequestBody @Valid FormAutor formAutor){		
		Autor autor = formAutor.novoAutor();			
		autorRepository.save(autor);
		return autor.toString();
		
	}
	
}
