package com.demo.validation;

import com.demo.controller.EmployeeController;
import com.demo.customexception.AppException;
import com.demo.dto.Employee;
import io.micronaut.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Validate {

    enum Emp {
        MANAGER, ASSOCIATE
    }
    Logger logger = LogManager.getLogger(Validate.class.getName());

    public Class className = null;
    private static Validate validate;

    public <T> Validate() {
    }

    public static Validate getValidationObject() {
        return new Validate();
    }

    public <K> void validates(K k) throws AppException {
        logger.info("In Validate.class", "In validate method");
        if (k != null) {
            if (k instanceof Employee) {
                Employee e = (Employee) k;
                switch (Emp.valueOf(e.getDesignation().toUpperCase())) {
                    case MANAGER:
                        if (e.getNoOfReportees() == null || e.getNoOfReportees() <= 0) {
                            throw new AppException("NoOfReportiees Cannot be than 1", HttpStatus.BAD_REQUEST);
                        }
                        break;
                    case ASSOCIATE:
                        if (e.getDapartment() == null || e.getDapartment().length() <= 1) {
                            throw new AppException("Associate Department cannot be null", HttpStatus.BAD_REQUEST);
                        }
                        if (e.getManagerName() == null || e.getManagerName().length() <= 1) {
                            throw new AppException("Associate Manager name cannot be null", HttpStatus.BAD_REQUEST);
                        }
                        if (e.getNoOfReportees() != null) {
                            throw new AppException("This field is not for Associates", HttpStatus.BAD_REQUEST);
                        }
                        break;

                }
            }
        } else {
            throw new NullPointerException("Can't Validate Object Is Null");
        }
    }
}
