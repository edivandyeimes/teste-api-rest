package com.edivan.testapirest.controller;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;
import org.passay.EnglishSequenceData;
import org.passay.IllegalSequenceRule;

import com.edivan.testapirest.validator.ValidPassword;

public class PasswordValidatorController implements ConstraintValidator<ValidPassword, String>{

	@Override
	public void initialize(ValidPassword arg0) {
		
	}
	
	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		PasswordValidator validator = new PasswordValidator(Arrays.asList(
           new LengthRule(8, 9), 
           new CharacterRule(EnglishCharacterData.UpperCase, 1), 
           new CharacterRule(EnglishCharacterData.LowerCase, 1), 
           new CharacterRule(EnglishCharacterData.Digit, 1), 
           new CharacterRule(EnglishCharacterData.Special, 1),
           new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 3, false),
           new IllegalSequenceRule(EnglishSequenceData.Numerical, 3, false),
           new IllegalSequenceRule(EnglishSequenceData.USQwerty, 3, false),
           new WhitespaceRule()));
 
        RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }
        context.buildConstraintViolationWithTemplate(
        	String.join(",", validator.getMessages(result)))
        	.addConstraintViolation()
        	.disableDefaultConstraintViolation();
        return false;
	}

}
