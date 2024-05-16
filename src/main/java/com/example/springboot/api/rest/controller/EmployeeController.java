package com.example.springboot.api.rest.controller;

import com.example.springboot.api.rest.controller.openapi.EmployeeControllerOpenAPI;
import com.example.springboot.api.rest.dto.EmployeeDTO;
import com.example.springboot.domain.service.employee.EmployeeService;
import com.example.springboot.persistence.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/employees")
public class EmployeeController implements EmployeeControllerOpenAPI {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    @Override
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employee) {
        log.info("Creating a new employee with value {}", employee);
        EmployeeDTO createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.ok(createdEmployee);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long id) {
        log.info("Fetching the employee with id {}", id);
        EmployeeDTO retrievedEmployee = employeeService.getEmployee(id);
        return ResponseEntity.ok(retrievedEmployee);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Employee>> getAllEmployees() {
        log.info("Fetching all employees");
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employee) {
        log.info("Updating the employee with id {}", id);
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        log.info("Deleting the employee with id {}", id);
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}