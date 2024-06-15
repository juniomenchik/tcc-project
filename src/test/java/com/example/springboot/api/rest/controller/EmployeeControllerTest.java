package com.example.springboot.api.rest.controller;

import com.example.springboot.api.rest.dto.EmployeeDTO;
import com.example.springboot.domain.service.employee.EmployeeService;
import com.example.springboot.persistence.entity.Employee;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class EmployeeControllerTest {

    @InjectMocks
    EmployeeController employeeController;

    @Mock
    EmployeeService employeeService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testCreateEmployee() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        when(employeeService.createEmployee(any(EmployeeDTO.class))).thenReturn(employeeDTO);
        ResponseEntity<EmployeeDTO> response = employeeController.createEmployee(employeeDTO);
        assertEquals(200, response.getStatusCodeValue());
        verify(employeeService, times(1)).createEmployee(any(EmployeeDTO.class));
    }

    @Test
    public void testGetEmployee() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        when(employeeService.getEmployee(any(Long.class))).thenReturn(employeeDTO);
        ResponseEntity<EmployeeDTO> response = employeeController.getEmployee(1L);
        assertEquals(200, response.getStatusCodeValue());
        verify(employeeService, times(1)).getEmployee(any(Long.class));
    }

    @Test
    public void testGetAllEmployees() {
        List<Employee> list = new ArrayList<>();
        when(employeeService.getAllEmployees()).thenReturn(list);
        ResponseEntity<List<Employee>> response = employeeController.getAllEmployees();
        assertEquals(200, response.getStatusCodeValue());
        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    public void testUpdateEmployee() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        when(employeeService.updateEmployee(any(Long.class), any(EmployeeDTO.class))).thenReturn(employeeDTO);
        ResponseEntity<EmployeeDTO> response = employeeController.updateEmployee(1L, employeeDTO);
        assertEquals(200, response.getStatusCodeValue());
        verify(employeeService, times(1)).updateEmployee(any(Long.class), any(EmployeeDTO.class));
    }

    @Test
    public void testDeleteEmployee() {
        doNothing().when(employeeService).deleteEmployee(any(Long.class));
        ResponseEntity<Void> response = employeeController.deleteEmployee(1L);
        assertEquals(200, response.getStatusCodeValue());
        verify(employeeService, times(1)).deleteEmployee(any(Long.class));
    }

}