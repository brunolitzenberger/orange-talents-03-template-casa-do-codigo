package br.com.zupacademy.bruno.casadocodigo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.bruno.casadocodigo.model.forms.FormAutor;
import br.com.zupacademy.bruno.casadocodigo.repository.AutorRepository;

@Component
public class DuplicatedEmailValidator implements Validator {

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return FormAutor.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		FormAutor request = (FormAutor) target;

		Boolean possivelAutor = autorRepository
				.existsByEmail(request.getEmail());

		if (possivelAutor) {
			errors.rejectValue("email", null, "Email do(a) autor(a) já cadastrado no sistema.");
		}
	}

}
