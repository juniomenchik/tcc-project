package com.example.springboot.api.rest.controller.openapi;

import com.example.springboot.persistence.entity.Employee;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EmployeeControllerOpenAPI {

    @PostMapping
    @Operation(summary = "Create new employee")
    ResponseEntity<Employee> createEmployee(@RequestBody Employee employee);
    @Operation(summary = "Get employee by id")
    ResponseEntity<Employee> getEmployee(@PathVariable Long id);
    @Operation(summary = "Get all employees")
    ResponseEntity<List<Employee>> getAllEmployees();
    @Operation(summary = "Update an existing employee")
    ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee);
    @Operation(summary = "Delete an employee by id")
    ResponseEntity<Void> deleteEmployee(@PathVariable Long id);
}