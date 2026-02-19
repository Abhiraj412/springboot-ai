package com.abhiraj.module2.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeValidation, String> {

    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
        List<String> roles = List.of("ADMIN","USER");
        return roles.contains(inputRole);
    }
}
