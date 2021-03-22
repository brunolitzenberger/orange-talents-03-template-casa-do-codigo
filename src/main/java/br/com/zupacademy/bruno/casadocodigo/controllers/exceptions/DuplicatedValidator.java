package br.com.zupacademy.bruno.casadocodigo.controllers.exceptions;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.bruno.casadocodigo.model.forms.FormAutor;
import br.com.zupacademy.bruno.casadocodigo.repository.AutorRepository;

@Component
public class DuplicatedValidator implements Validator{
	
	private final AutorRepository autorRepository;	
	
	public DuplicatedValidator(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {		
		return FormAutor.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		FormAutor form = (FormAutor) target;
		Boolean autorExiste = autorRepository.existsByEmail(form.getEmail());
		if(autorExiste) {
			errors.rejectValue("email", null, "Email do(a) autor(a) já existe no sistema.");
		}
		
	}


	
}
