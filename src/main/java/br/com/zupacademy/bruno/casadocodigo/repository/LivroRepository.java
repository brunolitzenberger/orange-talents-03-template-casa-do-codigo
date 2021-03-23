package br.com.zupacademy.bruno.casadocodigo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.bruno.casadocodigo.model.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long>{

}
