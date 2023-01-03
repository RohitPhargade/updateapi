package com.demo.controller;

import com.demo.customexception.AppException;
import com.demo.dto.Employee;
import com.demo.service.EmployeeService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.Valid;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
class EmployeeControllerTest {

    @Inject
    private EmployeeController employeeController;
    @Inject
    private EmployeeService employeeService;

    @MockBean(EmployeeService.class)
    EmployeeService employeeService() {
        return mock(EmployeeService.class);
    }

    @Test
    void updatePersonSuccess() throws AppException {
        Employee employee = new Employee();
        employee.setId(100);
        employee.setName("John");
        employee.setDapartment("DEV");
        employee.setDesignation("Manager");
        employee.setJoiningDate(LocalDate.now());
        employee.setManagerName("Kane");
        employee.setNoOfReportees(20);
        String expected = employee.getDesignation() + " Added Successfully";
        when(employeeService.addEmployee(employee.getDesignation(), employee)).thenReturn(expected);
        HttpResponse<?> httpResponse = employeeController.updatePerson(employee);
        Assertions.assertEquals(expected, httpResponse.body());
    }
}