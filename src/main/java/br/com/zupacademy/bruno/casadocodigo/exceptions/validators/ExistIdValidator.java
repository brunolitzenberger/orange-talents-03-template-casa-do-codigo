package br.com.zupacademy.bruno.casadocodigo.exceptions.validators;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class ExistIdValidator implements ConstraintValidator<ExistId, Object>{
	
	private String domainAttribute;
	private Class<?> klass;
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void initialize(ExistId params) {
		domainAttribute = params.fieldName();
		klass = params.domainClass();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {		
		Query query = em.createQuery("SELECT 1 FROM " + klass.getName() + " WHERE "+ domainAttribute +" = :value");
		query.setParameter("value", value);
		List<?> resultList = query.getResultList();
		Assert.state(resultList.size() <= 1, "Não foram encontrados registros com este id");
		return !resultList.isEmpty();
	}

}
