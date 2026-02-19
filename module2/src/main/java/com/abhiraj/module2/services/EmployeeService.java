package com.abhiraj.module2.services;

import com.abhiraj.module2.dto.EmployeeDTO;
import com.abhiraj.module2.entities.EmployeeEntity;
import com.abhiraj.module2.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import tools.jackson.databind.ObjectMapper;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);

        return employeeEntity.map(employeeEntity1 -> modelMapper.map(employeeEntity1, EmployeeDTO.class));
        // if(employeeEntity == null) return null;
        // return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> listEmp = employeeRepository.findAll();
        return listEmp.stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .toList();
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
        EmployeeEntity empToSave = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity empSaved = employeeRepository.save(empToSave);

        return modelMapper.map(empSaved, EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);

        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    private boolean isExistByEmployeeId(Long employeeId) {
        return employeeRepository.existsById(employeeId);
    }

    public boolean deleteEmployeeById(Long employeeId) {
        boolean exists = isExistByEmployeeId(employeeId);

        if (!exists)
            return false;

        employeeRepository.deleteById(employeeId);
        return true;
    }

    public EmployeeDTO updatePartialEmployeeById(Long employeeId, Map<String, Object> updates) {
        boolean exists = isExistByEmployeeId(employeeId);

        if (!exists)
            return null;

        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();

        // Updating the fields Using Reflection
        updates.forEach((field, value) -> {
            Field fieldToUpdate = ReflectionUtils.findField(EmployeeEntity.class, field);
            fieldToUpdate.setAccessible(true);
            ReflectionUtils.setField(fieldToUpdate, employeeEntity, new ObjectMapper().convertValue(value, fieldToUpdate.getType()));
        });

        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);

    }
}
