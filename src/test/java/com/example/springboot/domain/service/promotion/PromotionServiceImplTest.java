package com.example.springboot.domain.service.promotion;

import com.example.springboot.persistence.entity.Employee;
import com.example.springboot.persistence.entity.enums.DeveloperLevelEnum;
import com.example.springboot.persistence.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.*;

class PromotionServiceImplTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    PromotionServiceImpl promotionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExtraMoney() {
        Long id = 1L;
        Employee employee = new Employee();
        employee.setSalary(BigDecimal.valueOf(50000));

        when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
        when(employeeRepository.save(any(Employee.class))).thenAnswer(i -> i.getArguments()[0]);

        promotionService.extraMoney(id);

        verify(employeeRepository, times(1)).findById(id);
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

    @Test
    void testNextLevel() {
        Long id = 1L;
        Employee employee = new Employee();
        employee.setLevel(DeveloperLevelEnum.JUNIOR);

        when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
        when(employeeRepository.save(any(Employee.class))).thenAnswer(i -> i.getArguments()[0]);

        promotionService.nextLevel(id);

        verify(employeeRepository, times(1)).findById(id);
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }
}