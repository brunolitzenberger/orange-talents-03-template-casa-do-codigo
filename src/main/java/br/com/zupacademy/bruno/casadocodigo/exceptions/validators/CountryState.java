package br.com.zupacademy.bruno.casadocodigo.exceptions.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy = { CountryStateValidator.class })
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface CountryState {

	String message() default "Estado inválido.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}