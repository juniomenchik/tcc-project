package com.example.springboot.persistence.entity;

import com.example.springboot.api.rest.dto.EmployeeDTO;
import com.example.springboot.persistence.entity.enums.DeveloperLevelEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

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
        try {
            if ( !Objects.isNull(employeeDTO.getLevel())){
                DeveloperLevelEnum.valueOf(employeeDTO.getLevel());
            }
        }catch (Exception exception){
            throw new IllegalArgumentException("Invalid developer level");
        }

        var level = DeveloperLevelEnum.valueOf(employeeDTO.getLevel());

        return Employee.builder()
                .name(employeeDTO.getName())
                .designation(employeeDTO.getDesignation())
                .level(employeeDTO.getLevel() != null
                        ? level
                        : DeveloperLevelEnum.TRAINEE)
                .salary(employeeDTO.getSalary() != null
                        ? employeeDTO.getSalary()
                        : level.getSalary())
                .build();
    }

    public void upLevel() {
        this.level = level.getNewLevel();
    }
}