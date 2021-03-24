package br.com.zupacademy.bruno.casadocodigo.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.bruno.casadocodigo.model.Livro;
import br.com.zupacademy.bruno.casadocodigo.model.dto.ListaLivroDTO;

@RestController
@RequestMapping
public class ListaLivroController {

	@PersistenceContext
	private EntityManager em;

	@GetMapping("/livros")
	public ResponseEntity<List<ListaLivroDTO>> list() {
		List<Livro> resultList = em.createQuery("SELECT L FROM Livro L").getResultList();
		if (resultList.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		List<ListaLivroDTO> listaLivroDTO = ListaLivroDTO.toList(resultList);
		return ResponseEntity.ok(listaLivroDTO);

	}

}
