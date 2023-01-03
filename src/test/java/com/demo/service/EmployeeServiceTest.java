package com.demo.service;

import com.demo.controller.EmployeeController;
import com.demo.customexception.AppException;
import com.demo.dto.Employee;
import com.demo.repository.EmployeeRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
class EmployeeServiceTest {
    @Inject
    private EmployeeService employeeService;


    @Inject
    private EmployeeRepository employeeRepository;


    @MockBean(EmployeeRepository.class)
    EmployeeRepository employeeRepository() {
        return mock(EmployeeRepository.class);
    }

    @Test
    void addEmployeeSuccess() throws AppException {
        Employee employee = new Employee();
        employee.setId(100);
        employee.setName("John");
        employee.setDapartment("DEV");
        employee.setDesignation("Manager");
        employee.setJoiningDate(LocalDate.now());
        employee.setManagerName("Kane");
        employee.setNoOfReportees(20);

        String expected = employee.getDesignation() + " Added Successfully";

        when(employeeRepository.save(employee.getDesignation(), employee)).thenReturn(expected);
        String output = employeeService.addEmployee(employee.getDesignation(), employee);
        Assertions.assertEquals(expected, output);
    }
}