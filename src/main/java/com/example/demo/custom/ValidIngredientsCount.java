package com.example.demo.custom;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValidIngredientCountValidator.class})
@Documented
public @interface ValidIngredientsCount {

	String message() default "{com.example.demo.custom.ValidIngredientsCount.message}";
	
	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default { };
}
