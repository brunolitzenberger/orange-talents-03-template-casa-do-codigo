package br.com.zupacademy.bruno.casadocodigo.exceptions.validators;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

import br.com.zupacademy.bruno.casadocodigo.model.forms.FormEstado;

public class UniqueCountryValidator implements ConstraintValidator<UniqueCountry, FormEstado>{
	
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean isValid(FormEstado value, ConstraintValidatorContext context) {
		Query query = em.createQuery("SELECT 1 FROM Estado WHERE nome = :estado AND pais_id = " + value.getPaisId());
		query.setParameter("estado", value.getNome());
		List<?> resultList = query.getResultList();
		Assert.state(resultList.size() <=1, "Estado já cadastrado neste país.");
		return resultList.isEmpty();
	}

}
