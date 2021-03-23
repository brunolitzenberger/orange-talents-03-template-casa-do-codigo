package br.com.zupacademy.bruno.casadocodigo.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.bruno.casadocodigo.model.Livro;
import br.com.zupacademy.bruno.casadocodigo.model.dto.LivroDTO;
import br.com.zupacademy.bruno.casadocodigo.model.forms.FormLivro;

@RestController
@RequestMapping("/livro")
public class LivroController {
	@PersistenceContext
	private EntityManager em;
	
	@PostMapping
	@Transactional
	public String create(@RequestBody @Valid FormLivro formLivro) {
		Livro livro = formLivro.novoLivro(em);
		em.persist(livro);
		return livro.toString();
		
	}
	
	@GetMapping
	public List<LivroDTO> list(){
		 List<Livro> resultList = em.createQuery("SELECT L FROM Livro L").getResultList();
		 List<LivroDTO> livroDTO = LivroDTO.toList(resultList);
		 return livroDTO;
		
	}
	
}
