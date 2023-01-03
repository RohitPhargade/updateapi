package com.demo;

import com.demo.controller.EmployeeController;
import io.micronaut.runtime.Micronaut;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {
    public static final Logger LOGGER = LogManager.getLogger(Application.class.getName());

    public static void main(String[] args) {
        LOGGER.info("Application.class", "----------------------In update Endpoint--------------------------");
        Micronaut.run(Application.class, args);
    }
}
