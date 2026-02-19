package com.abhiraj.module2.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {EmployeeRoleValidator.class})

public @interface EmployeeValidation {
    String message() default "{Employee role can either be ADMIN or USER}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
