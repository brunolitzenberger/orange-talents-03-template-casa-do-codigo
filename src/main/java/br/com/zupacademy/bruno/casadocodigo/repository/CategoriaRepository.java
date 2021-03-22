package br.com.zupacademy.bruno.casadocodigo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.bruno.casadocodigo.controllers.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>{

	Boolean existsByNome(String nome);

}
