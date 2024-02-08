package com.studentrestapi.CustomAnnotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StandardValidation implements ConstraintValidator<ValidateStandardOfStudent,Integer> {

	@Override
	public boolean isValid(Integer standard, ConstraintValidatorContext context) {
     List<Integer> standardList=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
		return standardList.contains(standard);
	}

}
