package com.example.springboot.domain.service.employee;

import com.example.springboot.api.rest.dto.EmployeeDTO;
import com.example.springboot.persistence.entity.Employee;
import static com.example.springboot.persistence.entity.enums.DeveloperLevelEnum.TRAINEE;
import com.example.springboot.persistence.repository.EmployeeRepository;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

public class EmployeeServiceImplTest {

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateEmployee() {
        Employee employee = Employee.builder()
                .id(1L)
                .name("Jeff")
                .designation("Prograammer")
                .level(TRAINEE)
                .salary(TRAINEE.getSalary())
                .build();
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .name("Jeff")
                .designation("Prograammer")
                .level(String.valueOf(TRAINEE))
                .salary(TRAINEE.getSalary())
                .build();
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        EmployeeDTO result = employeeService.createEmployee(employeeDTO);
        assertNotNull(result);
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

    @Test
    public void testGetEmployee() {
        Employee employee = Employee.builder()
                .id(1L)
                .name("Jeff")
                .designation("Prograammer")
                .level(TRAINEE)
                .salary(TRAINEE.getSalary())
                .build();
        when(employeeRepository.findById(any(Long.class))).thenReturn(Optional.of(employee));
        EmployeeDTO result = employeeService.getEmployee(1L);
        assertNotNull(result);
        verify(employeeRepository, times(1)).findById(any(Long.class));
    }

    @Test
    public void testGetAllEmployees() {
        when(employeeRepository.findAll()).thenReturn(new ArrayList<>());
        ArrayList<Employee> result = (ArrayList<Employee>) employeeService.getAllEmployees();
        assertNotNull(result);
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = Employee.builder()
                .id(1L)
                .name("Jeff")
                .designation("Prograammer")
                .level(TRAINEE)
                .salary(TRAINEE.getSalary())
                .build();
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .name("Jeff")
                .designation("Prograammer")
                .level(String.valueOf(TRAINEE))
                .salary(TRAINEE.getSalary())
                .build();
        when(employeeRepository.findById(any(Long.class))).thenReturn(Optional.of(employee));
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        EmployeeDTO result = employeeService.updateEmployee(1L, employeeDTO);
        assertNotNull(result);
        verify(employeeRepository, times(1)).findById(any(Long.class));
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

    @Test
    public void testDeleteEmployee() {
        doNothing().when(employeeRepository).deleteById(any(Long.class));
        employeeService.deleteEmployee(1L);
        verify(employeeRepository, times(1)).deleteById(any(Long.class));
    }
}