package com.demo.repository;

import com.aerospike.mapper.tools.AeroMapper;
import com.demo.dto.Employee;
import com.demo.util.AeroMapperUtil;
import io.micronaut.data.annotation.Repository;
import jakarta.inject.Inject;

@Repository
public class EmployeeRepository {

    @Inject
    AeroMapperUtil aeroMapperUtil;

    public String save(String designation, Employee employee) {
        aeroMapperUtil.getMapper().save(employee);
        return designation +" Added Successfully";
    }
}
