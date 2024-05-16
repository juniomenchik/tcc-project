package com.example.springboot.domain.service.promotion;

import com.example.springboot.persistence.entity.Employee;
import com.example.springboot.persistence.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class PromotionServiceImpl implements PromotionService {

    private final EmployeeRepository employeeRepository;

    public PromotionServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee extraMoney(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Employee not found!"));

        BigDecimal newSalary = employee.getSalary().multiply(new BigDecimal("1.2"));
        employee.setSalary(newSalary);

        log.info("New salary after twenty percent promotion: " + employee.getSalary());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee nextLevel(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Employee not found!"));

        employee.upLevel();

        log.info("Congrats for the " + employee.getLevel().name() + " promotion!!! ");
        log.info("Your New salary is R$" + employee.getSalary());
        return employeeRepository.save(employee);
    }
}