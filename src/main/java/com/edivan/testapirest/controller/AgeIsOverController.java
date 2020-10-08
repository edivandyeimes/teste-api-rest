package com.edivan.testapirest.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.edivan.testapirest.validator.AgeIsOver;

public class AgeIsOverController implements ConstraintValidator<AgeIsOver, String>{
	
	@Autowired
	private String value;
	
	
 
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        
        try {
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	Calendar birthDate = GregorianCalendar.getInstance();
        	birthDate.setTime(sdf.parse(value));
        	Calendar date = GregorianCalendar.getInstance();
        	int birthYear = birthDate.get(Calendar.YEAR);
        	int currentYear = date.get(Calendar.YEAR);
            int age = currentYear - birthYear;
            int birthMonth = birthDate.get(Calendar.MONTH);
            int birthDay = birthDate.get(Calendar.DAY_OF_MONTH);
            int currentDay = date.get(Calendar.DAY_OF_MONTH);
            int currentMonth = date.get(Calendar.MONTH);
            if(birthMonth >= currentMonth && birthDay >= currentDay){
            	age--;
            }
            if(age >= 18) {
            	return true; 
            }
            else {
            	return false;
            }
        
        } catch (RuntimeException e) {
        	e.printStackTrace();
            return false;
            
        } catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
    }
}
	

