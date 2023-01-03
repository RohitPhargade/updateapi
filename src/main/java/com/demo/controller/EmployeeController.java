package com.demo.controller;


import com.demo.customexception.AppException;
import com.demo.dto.Employee;
import com.demo.service.EmployeeService;
import com.demo.validation.Validate;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
@Validated
public class EmployeeController {


    @Inject
    private EmployeeService employeeService;

    public static final Logger LOGGER = LogManager.getLogger(EmployeeController.class.getName());

    @Post(value = "/employee",produces = MediaType.APPLICATION_JSON)
    public HttpResponse<?> updatePerson(@Valid @Body Employee employee) throws AppException  {
        LOGGER.info("emp controller.class", "In update Endpoint");
        Validate.getValidationObject().validates(employee);
        return HttpResponse.ok(employeeService.addEmployee(employee.getDesignation(),employee));

    }



    @Post("/update-employee")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public HttpResponse<?> updateEmployee(String str) {
//        GsonBuilder builder = new GsonBuilder();
//        builder.setPrettyPrinting();
//        String empAsString = gson.toJson(emp);
//        Gson gson = builder.create();
        System.out.println("====> "+ str);
        return HttpResponse.ok("Updated successfully");
    }













}
