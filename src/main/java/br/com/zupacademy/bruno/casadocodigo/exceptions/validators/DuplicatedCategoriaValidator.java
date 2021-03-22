package br.com.zupacademy.bruno.casadocodigo.exceptions.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.bruno.casadocodigo.controllers.FormCategoria;
import br.com.zupacademy.bruno.casadocodigo.repository.CategoriaRepository;
@Component
public class DuplicatedCategoriaValidator implements Validator{
	
	private final CategoriaRepository categoriaRepository;
	
	public DuplicatedCategoriaValidator(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return FormCategoria.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		FormCategoria request = (FormCategoria) target;
		Boolean possivelCategoria = categoriaRepository.existsByNome(request.getNome());
		if(possivelCategoria) {
			errors.rejectValue("nome", null, "Nome de categoria já existente.");
		}
		
	}

}
