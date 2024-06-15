package com.example.springboot.persistence.entity;

import com.example.springboot.api.rest.dto.EmployeeDTO;
import com.example.springboot.persistence.entity.enums.DeveloperLevelEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

class EmployeeTest {

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = Employee.builder()
                .name("John Doe")
                .designation("Software Developer")
                .level(DeveloperLevelEnum.TRAINEE)
                .salary(new BigDecimal("50000"))
                .build();
    }

    @Test
    void employeeBuilderTest() {
        assertNotNull(employee);
        assertEquals("John Doe", employee.getName());
        assertEquals("Software Developer", employee.getDesignation());
        assertEquals(DeveloperLevelEnum.TRAINEE, employee.getLevel());
        assertEquals(new BigDecimal("50000"), employee.getSalary());
    }

    @Test
    void upLevelTest() {
        employee.upLevel();
        assertNotEquals(DeveloperLevelEnum.TRAINEE, employee.getLevel());
    }

    @Test
    void buildByEmployeeDTO() {
        EmployeeDTO employeeDTO = new EmployeeDTO("Jane Doe", "Software Developer", DeveloperLevelEnum.SENIOR.toString(), new BigDecimal("70000"));
        Employee employee = Employee.buildByEmployeeDTO(employeeDTO);

        assertNotNull(employee);
        assertEquals(employeeDTO.getName(), employee.getName());
        assertEquals(employeeDTO.getDesignation(), employee.getDesignation());
        assertEquals(employeeDTO.getLevel().toString(), employee.getLevel().toString());
        assertEquals(employeeDTO.getSalary(), employee.getSalary());
    }

    @Test
    void upLevel() {
        DeveloperLevelEnum initialLevel = employee.getLevel();
        employee.upLevel();
        assertNotEquals(initialLevel, employee.getLevel());
    }

    @Test
    void getId() {
        assertNull(employee.getId());
    }

    @Test
    void getName() {
        assertEquals("John Doe", employee.getName());
    }

    @Test
    void getDesignation() {
        assertEquals("Software Developer", employee.getDesignation());
    }

    @Test
    void getLevel() {
        assertEquals(DeveloperLevelEnum.TRAINEE, employee.getLevel());
    }

    @Test
    void getSalary() {
        assertEquals(new BigDecimal("50000"), employee.getSalary());
    }

    @Test
    void setId() {
        employee.setId(1L);
        assertEquals(1L, employee.getId());
    }

    @Test
    void setName() {
        employee.setName("Jane Doe");
        assertEquals("Jane Doe", employee.getName());
    }

    @Test
    void setDesignation() {
        employee.setDesignation("Senior Software Developer");
        assertEquals("Senior Software Developer", employee.getDesignation());
    }

    @Test
    void setLevel() {
        employee.setLevel(DeveloperLevelEnum.SENIOR);
        assertEquals(DeveloperLevelEnum.SENIOR, employee.getLevel());
    }

    @Test
    void setSalary() {
        employee.setSalary(new BigDecimal("70000"));
        assertEquals(new BigDecimal("70000"), employee.getSalary());
    }

    @Test
    void testEquals() {
        Employee anotherEmployee = Employee.builder()
            .name("John Doe")
            .designation("Software Developer")
            .level(DeveloperLevelEnum.TRAINEE)
            .salary(new BigDecimal("50000"))
            .build();

        assertTrue(employee.equals(anotherEmployee));
    }

    @Test
    void canEqual() {
        Employee anotherEmployee = Employee.builder()
            .name("John Doe")
            .designation("Software Developer")
            .level(DeveloperLevelEnum.TRAINEE)
            .salary(new BigDecimal("50000"))
            .build();

        assertTrue(employee.canEqual(anotherEmployee));
    }

    @Test
    void testHashCode() {
        Employee anotherEmployee = Employee.builder()
            .name("John Doe")
            .designation("Software Developer")
            .level(DeveloperLevelEnum.TRAINEE)
            .salary(new BigDecimal("50000"))
            .build();

        assertEquals(employee.hashCode(), anotherEmployee.hashCode());
    }

    @Test
    void testToString() {
        String expected = "Employee(id=null, name=John Doe, designation=Software Developer, level=TRAINEE, salary=50000)";
        assertEquals(expected, employee.toString());
    }

    @Test
    void builder() {
        Employee anotherEmployee = Employee.builder()
            .name("Jane Doe")
            .designation("Senior Software Developer")
            .level(DeveloperLevelEnum.SENIOR)
            .salary(new BigDecimal("70000"))
            .build();

        assertNotNull(anotherEmployee);
        assertEquals("Jane Doe", anotherEmployee.getName());
        assertEquals("Senior Software Developer", anotherEmployee.getDesignation());
        assertEquals(DeveloperLevelEnum.SENIOR, anotherEmployee.getLevel());
        assertEquals(new BigDecimal("70000"), anotherEmployee.getSalary());
    }
}