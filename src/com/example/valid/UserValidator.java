package com.example.valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.dto.User;

@Service
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.getClass().equals(User.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "ER_Email","email required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "ER_Password", "password required");
		
		User user = (User)target;
		String password = user.getPassword();
		if(password == null || password.length()<3) {
			errors.rejectValue("password", "ER_Password", "password length must be more than 3 chars");
		}
		
	}
	
}
