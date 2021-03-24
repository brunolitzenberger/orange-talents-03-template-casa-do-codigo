package br.com.zupacademy.bruno.casadocodigo.exceptions.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = { ExistIdValidator.class })
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface ExistId {
	
	String message() default "O id inserido não existe";
	
	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default {};	
	
	String fieldName();
	
	Class<?> domainClass();
}
