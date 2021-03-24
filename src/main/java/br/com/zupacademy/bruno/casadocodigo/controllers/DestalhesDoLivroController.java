package br.com.zupacademy.bruno.casadocodigo.controllers;

import javax.persistence.EntityManager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.bruno.casadocodigo.model.Livro;
import br.com.zupacademy.bruno.casadocodigo.model.dto.LivroDTO;

@RestController
@RequestMapping
public class DestalhesDoLivroController {
	
	private EntityManager em;


	public DestalhesDoLivroController(EntityManager em) {
		this.em = em;
	}
	

	@GetMapping("livros/{id}")
	public ResponseEntity<LivroDTO> destalhesLivro(@PathVariable Long id){
		Livro livro = em.find(Livro.class, id);
		if(livro == null) {
			return ResponseEntity.notFound().build();
		}
		LivroDTO livroDTO = new LivroDTO(livro);
		return ResponseEntity.ok(livroDTO);		
	}

}
