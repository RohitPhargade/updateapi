package com.demo.service;

import com.demo.customexception.AppException;
import com.demo.dto.Employee;
import com.demo.repository.EmployeeRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class EmployeeService {

    @Inject
    private EmployeeRepository employeeRepository;

    public String addEmployee(String designation, Employee employee) throws AppException {
        return employeeRepository.save(designation ,employee);
    }
}
