package br.com.zupacademy.bruno.casadocodigo.exceptions.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = { UniqueCountryValidator.class })
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface UniqueCountry {
	
	String message() default "Já existe um estado com este nome para este País.";
	
	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default {};	
	

}
