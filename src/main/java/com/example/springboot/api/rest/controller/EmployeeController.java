package com.example.springboot.api.rest.controller;

import com.example.springboot.api.rest.controller.openapi.EmployeeControllerOpenAPI;
import com.example.springboot.persistence.entity.Employee;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController implements EmployeeControllerOpenAPI {

    @PostMapping
    @Override
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return null;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return null;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return null;
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return null;
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        return null;
    }
}