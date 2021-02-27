package com.nendrasys.com.validation;

import com.nendrasys.com.model.RegistrationModel;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import java.util.regex.Pattern;

public class RegistrationValidation implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return RegistrationModel.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"firstName","firstName.empty");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "lastName.empty");
        ValidationUtils.rejectIfEmpty(errors, "userName", "userName.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "password.empty");
        ValidationUtils.rejectIfEmpty(errors,"confirmPassword","confirmPassword.empty");
        ValidationUtils.rejectIfEmpty(errors, "address", "address.empty");
        ValidationUtils.rejectIfEmpty(errors,"country","country.empty");

        RegistrationModel user = (RegistrationModel) o;

        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE);
        if (!(pattern.matcher(user.getEmail()).matches())) {
            errors.rejectValue("email", "user.email.invalid");
        }

        if (user.getPassword() == null || user.getPassword().length() < 4  || user.getPassword().length() > 30 ) {
            errors.rejectValue("password", "user.password.size");
        }

        if(!(user.getPassword().equals(user.getConfirmPassword()))){
            errors.rejectValue("confirmPassword","mismatch.confirmPassword");
        }

        Pattern pattern1 = Pattern.compile("(0/91)?[6-9][0-9]{9}");
        if (!(pattern1.matcher(user.getContact()).matches())) {
            errors.rejectValue("contact", "user.contact.invalid");
        }

        if(user.getFirstName().length()>30){
            errors.rejectValue("firstName","user.firstName.length");
        }

        if(user.getLastName().length()>30){
            errors.rejectValue("lastName","user.lastName.length");
        }

        if(user.getEmail().length()>30){
            errors.rejectValue("email","user.email.length");
        }

        if(user.getUserName().length()>30){
            errors.rejectValue("userName","user.userName.length");
        }

        if(user.getAddress().length()>200){
            errors.rejectValue("address","user.address.length");
        }

    }
}