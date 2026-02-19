package com.abhiraj.module2.controllers;

import com.abhiraj.module2.dto.EmployeeDTO;
import com.abhiraj.module2.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        System.out.println("fetching employee by id:" + id);
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false) Integer age,
            @RequestParam(required = false) String sortBy) {
        System.out.println("Fetching all employees");
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping(path = "/createEmployee")
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee) {
        System.out.println("create employee request:" + inputEmployee);
        EmployeeDTO employeeDTO = employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@PathVariable(name = "employeeId") Long employeeId, @RequestBody EmployeeDTO employeeDTO) {
        System.out.println("update employee request by Id:" + employeeId);
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, employeeDTO));
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable(name = "employeeId") Long employeeId) {
        System.out.println("delete employee by Id:" + employeeId);
        boolean isDeleted = employeeService.deleteEmployeeById(employeeId);
        if(isDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@PathVariable(name = "employeeId") Long empId,
                                                 @RequestBody Map<String, Object> updates) throws Exception {
        EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeById(empId, updates);
        if(employeeDTO == null) return ResponseEntity.notFound().build();
        return  ResponseEntity.ok(employeeDTO);
    }

}
