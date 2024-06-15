package com.example.springboot.api.rest.dto;

import com.example.springboot.persistence.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String name;
    private String designation;
    private String level;
    private BigDecimal salary;

    public EmployeeDTO(Employee employee) {
        this.name = employee.getName();
        this.designation = employee.getDesignation();
        this.level = String.valueOf(employee.getLevel());
        this.salary = employee.getSalary();
    }

    public static EmployeeDTO buildByEmployee(Employee employee) {
        return EmployeeDTO.builder()
                .name(employee.getName())
                .designation(employee.getDesignation())
                .salary(employee.getSalary())
                .level(employee.getLevel().name())
                .build();
    }
}