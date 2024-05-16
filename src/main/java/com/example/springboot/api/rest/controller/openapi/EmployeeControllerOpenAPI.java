package com.example.springboot.api.rest.controller.openapi;

import com.example.springboot.api.rest.dto.EmployeeDTO;
import com.example.springboot.persistence.entity.Employee;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EmployeeControllerOpenAPI {
    @Operation(summary = "Create new employee")
    ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employee);
    @Operation(summary = "Get employee by id")
    ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long id);
    @Operation(summary = "Get all employees")
    ResponseEntity<List<Employee>> getAllEmployees();
    @Operation(summary = "Update an existing employee")
    ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employee);
    @Operation(summary = "Delete an employee by id")
    ResponseEntity<Void> deleteEmployee(@PathVariable Long id);
}