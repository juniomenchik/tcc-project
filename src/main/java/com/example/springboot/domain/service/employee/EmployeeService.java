package com.example.springboot.domain.service.employee;

import com.example.springboot.api.rest.dto.EmployeeDTO;
import com.example.springboot.persistence.entity.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employee);

    EmployeeDTO getEmployee(Long id);

    List<Employee> getAllEmployees();

    EmployeeDTO updateEmployee(Long id, EmployeeDTO employee);

    void deleteEmployee(Long id);
}