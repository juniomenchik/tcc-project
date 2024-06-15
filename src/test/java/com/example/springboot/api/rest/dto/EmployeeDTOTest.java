package com.example.springboot.api.rest.dto;

import com.example.springboot.persistence.entity.Employee;
import com.example.springboot.persistence.entity.enums.DeveloperLevelEnum;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class EmployeeDTOTest {

    private EmployeeDTO employeeDTO;

    @BeforeEach
    void setUp() {
        employeeDTO = EmployeeDTO.builder()
                .name("John Doe")
                .designation("Software Developer")
                .level(DeveloperLevelEnum.TRAINEE.toString())
                .salary(new BigDecimal("50000"))
                .build();
    }

    @Test
    void employeeBuilderTest() {
        assertNotNull(employeeDTO);
        assertEquals("John Doe", employeeDTO.getName());
        assertEquals("Software Developer", employeeDTO.getDesignation());
        assertEquals(DeveloperLevelEnum.TRAINEE.toString(), employeeDTO.getLevel());
        assertEquals(new BigDecimal("50000"), employeeDTO.getSalary());
    }

    @Test
    void buildByEmployee() {
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setDesignation("Software Developer");
        employee.setLevel(DeveloperLevelEnum.TRAINEE);
        employee.setSalary(new BigDecimal("50000"));

        EmployeeDTO builtDTO = EmployeeDTO.buildByEmployee(employee);

        assertNotNull(builtDTO);
        assertEquals(employee.getName(), builtDTO.getName());
        assertEquals(employee.getDesignation(), builtDTO.getDesignation());
        assertEquals(employee.getLevel().toString(), builtDTO.getLevel());
        assertEquals(employee.getSalary(), builtDTO.getSalary());
    }

    @Test
    void testEqualsAndHashCode() {
        EmployeeDTO employeeDTO1 = new EmployeeDTO();
        employeeDTO1.setName("John Doe");
        employeeDTO1.setDesignation("Software Developer");
        employeeDTO1.setLevel(DeveloperLevelEnum.TRAINEE.toString());
        employeeDTO1.setSalary(new BigDecimal("50000"));

        EmployeeDTO employeeDTO2 = new EmployeeDTO();
        employeeDTO2.setName("John Doe");
        employeeDTO2.setDesignation("Software Developer");
        employeeDTO2.setLevel(DeveloperLevelEnum.TRAINEE.toString());
        employeeDTO2.setSalary(new BigDecimal("50000"));

        // Test equals
        assertEquals(employeeDTO1, employeeDTO2);

        // Test hashCode
        assertEquals(employeeDTO1.hashCode(), employeeDTO2.hashCode());
    }

    @Test
    void testSettersAndGetters() {
        EmployeeDTO employeeDTO = new EmployeeDTO();

        String testName = "John Doe";
        String testDesignation = "Software Developer";
        String testLevel = DeveloperLevelEnum.TRAINEE.toString();
        BigDecimal testSalary = new BigDecimal("50000");

        // Test setters
        employeeDTO.setName(testName);
        employeeDTO.setDesignation(testDesignation);
        employeeDTO.setLevel(testLevel);
        employeeDTO.setSalary(testSalary);

        // Test getters
        assertEquals(testName, employeeDTO.getName());
        assertEquals(testDesignation, employeeDTO.getDesignation());
        assertEquals(testLevel, employeeDTO.getLevel());
        assertEquals(testSalary, employeeDTO.getSalary());
    }

    @Test
    void testConstructorAndCanEqual() {
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setDesignation("Software Developer");
        employee.setLevel(DeveloperLevelEnum.TRAINEE);
        employee.setSalary(new BigDecimal("50000"));

        EmployeeDTO employeeDTO = new EmployeeDTO(employee);

        assertEquals(employee.getName(), employeeDTO.getName());
        assertEquals(employee.getDesignation(), employeeDTO.getDesignation());
        assertEquals(employee.getLevel().toString(), employeeDTO.getLevel());
        assertEquals(employee.getSalary(), employeeDTO.getSalary());
    }

}