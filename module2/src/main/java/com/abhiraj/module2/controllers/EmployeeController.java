package com.abhiraj.module2.controllers;

import com.abhiraj.module2.entities.EmployeeEntity;
import com.abhiraj.module2.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @GetMapping(path =  "/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id){
        System.out.println("fetching employee by id:"+ id);
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) Integer age,
                                                @RequestParam(required = false) String sortBy) {
        System.out.println("Fetching all employees");
        return employeeRepository.findAll();
    }

    @PostMapping(path = "/createEmployee")
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
        System.out.println("create employee request:"+ inputEmployee);
        return employeeRepository.save(inputEmployee);
    }

    @PutMapping
    public EmployeeEntity updateEmployeeById( @RequestParam Long id) {
        EmployeeEntity emp1 = employeeRepository.findById(id).orElse(null);

        if(emp1 != null) {
            return employeeRepository.save(emp1);
        }

        return null;
    }

}
