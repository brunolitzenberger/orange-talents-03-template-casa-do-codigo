package br.com.zupacademy.bruno.casadocodigo.exceptions.validators;

import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.bruno.casadocodigo.model.Estado;
import br.com.zupacademy.bruno.casadocodigo.model.forms.FormCliente;

public class CountryStateValidator implements ConstraintValidator<CountryState, FormCliente> {

	@Autowired
	private EntityManager em;

	/**
	 * Se existerem estados neste país 
	 * o id do estado precisa existir
	 * se não existirem o id precisa ser nulo
	 */
	@Override
	public boolean isValid(FormCliente value, ConstraintValidatorContext context) {
		List<Estado> estadosDoPais = em.createQuery("SELECT estado FROM Estado estado WHERE pais_id = " + value.getPais(), Estado.class).getResultList();
		List<Estado> estado = em.createQuery("SELECT estado FROM Estado  estado WHERE id = " + value.getEstado(), Estado.class).getResultList();
		return estadosDoPais.isEmpty() && value.getEstado() == null || !estadosDoPais.isEmpty() && !estado.isEmpty();
	}

}
