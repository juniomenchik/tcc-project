package com.example.springboot.domain.service.employee;

import com.example.springboot.api.rest.dto.EmployeeDTO;
import com.example.springboot.persistence.entity.Employee;
import com.example.springboot.persistence.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        log.info("Creating a new employee");
        Employee employee = employeeRepository.save(Employee.buildByEmployeeDTO(employeeDTO));
        return EmployeeDTO.buildByEmployee(employee);
    }

    @Override
    public EmployeeDTO getEmployee(Long id) {
        log.info("Getting employee with id " + id);
        Employee employee = employeeRepository.findById(id).orElse(null);
        return employee != null ? EmployeeDTO.buildByEmployee(employee) : null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        log.info("Getting all employees");
        return new ArrayList<>(employeeRepository.findAll());
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO updatedEmployee) {
        log.info("Updating employee with id " + id);
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setName(updatedEmployee.getName());
            employeeRepository.save(employee);
        }
        return employee != null ? EmployeeDTO.buildByEmployee(employee) : null;
    }

    @Override
    public void deleteEmployee(Long id) {
        log.info("Deleting employee with id " + id);
        employeeRepository.deleteById(id);
    }
}