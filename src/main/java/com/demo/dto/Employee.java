package com.demo.dto;

import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Id;
import org.luaj.vm2.ast.Str;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@AerospikeRecord(namespace = "test",set = "Employee")
@Introspected
public class Employee {
    @NotBlank
    @AerospikeKey
    @Id
    Integer id;
    @NotBlank
    String name;
    @NotNull
    LocalDate joiningDate; /*[dd-mmm-yyyy]    : Both*/

    String dapartment = null;     /*  : Compulsory for Associate, optional for manager*/

    @NotBlank
    String designation; /*[Manager/Associate]    : Both*/

    String managerName = null;         /* : Compulsory for Associate, optional for manager*/
    Integer noOfReportees = null;       /* : Compulsory for manager, Disabled for Associates*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getDapartment() {
        return dapartment;
    }

    public void setDapartment(String dapartment) {
        this.dapartment = dapartment;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Integer getNoOfReportees() {
        return noOfReportees;
    }

    public void setNoOfReportees(Integer noOfReportees) {
        this.noOfReportees = noOfReportees;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", joiningDate=" + joiningDate +
                ", dapartment='" + dapartment + '\'' +
                ", designation='" + designation + '\'' +
                ", managerName='" + managerName + '\'' +
                ", noOfReportees=" + noOfReportees +
                '}';
    }
}
