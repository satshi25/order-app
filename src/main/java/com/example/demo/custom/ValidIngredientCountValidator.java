package com.example.demo.custom;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.demo.entity.Ingredient;
import com.example.demo.entity.Taco;

public class ValidIngredientCountValidator implements ConstraintValidator<ValidIngredientsCount, Set<Ingredient>> {

//	@Override
//	public boolean isValid(Taco taco, ConstraintValidatorContext context) {
//		if( taco == null) {
//			return false;
//		}
//		
//		if(taco.getIngredients().isEmpty()) {
//			return false;
//		}
//		return true;
//	}

//	@Override
//	public boolean isValid(List<Ingredient> value, ConstraintValidatorContext context) {
//		if( value == null) {
//			return false;
//		}
//		
//		if(value.isEmpty()) {
//			return false;
//		}
//		return true;
//	}

	@Override
	public boolean isValid(Set<Ingredient> value, ConstraintValidatorContext context) {
		if( value == null) {
			return false;
		}
		
		if(value.isEmpty()) {
			return false;
		}
		return true;
	}

}
