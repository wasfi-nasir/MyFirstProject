package com.example.interviews.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
    private static final String PHONE_VALIDATION = "(\\+|(00))9705[96][0-9]{7}";
    @Override
    public void initialize(Phone contactNumber) {
    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
        return contactField != null && contactField.matches(PHONE_VALIDATION);
}

}