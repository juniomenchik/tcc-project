package com.example.springboot.persistence.entity;

import com.example.springboot.api.rest.dto.EmployeeDTO;
import com.example.springboot.persistence.entity.enums.DeveloperLevelEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String designation;
    private DeveloperLevelEnum level;
    private BigDecimal salary;

    public static Employee buildByEmployeeDTO(EmployeeDTO employeeDTO) {
        return Employee.builder()
                .name(employeeDTO.getName())
                .designation(employeeDTO.getDesignation())
                .level(employeeDTO.getLevel() != null
                        ? DeveloperLevelEnum.valueOf(employeeDTO.getLevel())
                        : DeveloperLevelEnum.TRAINEE)
                .salary(employeeDTO.getSalary() != null
                        ? employeeDTO.getSalary()
                        : DeveloperLevelEnum.TRAINEE.getSalary()
                ).build();
    }

    public void upLevel() {
        this.level = level.getNewLevel();
    }
}