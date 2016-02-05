package it.experis.service.validator;

import it.experis.service.bean.SMS;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SMSValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return SMS.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "required.address", "Field sms text is required.");
		
	}

}
