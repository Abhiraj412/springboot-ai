package com.abhiraj.module2.dto;

import com.abhiraj.module2.annotations.EmployeeValidation;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDTO {

    private Long id;

    //@NotNull(message = "name is required for Employee")
    //@NotEmpty
    @NotBlank
    private String name;

    @NotBlank(message = "email of employee can not be blank")
    @Email
    private String email;

    @NotNull(message = "edge of employee can not be null")
    @Max(value = 60, message = "Employee can not be older than 60")
    @Min(value = 18, message = "Employee can not be younger than 18")
    private Integer age;

    @NotBlank(message = "role of employee can not be blank")
    //@Pattern(regexp = "^(ADMIN|USER$)", message = "role can be only ADMIN OR USER")
    @EmployeeValidation
    private String role;//admin user

    @NotNull @Positive
    @Digits(integer = 7, fraction = 2, message = "salary format should be xxxx.xx")
    @DecimalMax(value = "999999.99")
    @DecimalMin(value = "1000.50")
    private Double salary;

    @PastOrPresent
    private LocalDate dateOfJoining;

    @AssertTrue(message = "employee should be active")
    private Boolean isActive;

    public EmployeeDTO(){

    }

    public EmployeeDTO(Long id, String name, String email, Integer age, String role, LocalDate dateOfJoining, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.role = role;
        this.dateOfJoining = dateOfJoining;
        this.isActive = isActive;
    }



}
