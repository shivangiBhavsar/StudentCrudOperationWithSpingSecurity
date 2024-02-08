package com.studentrestapi.CustomAnnotation;

import  java.lang.annotation.ElementType;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Documented
@Constraint(validatedBy = StandardValidation.class)
public @interface ValidateStandardOfStudent {
	public String message()default "Invalid Standard: It should be between 1 to 12.";
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
