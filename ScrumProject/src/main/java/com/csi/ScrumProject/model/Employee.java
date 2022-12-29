package com.csi.ScrumProject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String email;

    private String password;

    private Long contactNumber;

    private int age;

    private double salary;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date DOB;


    public Employee(int i, String john, String s, String rsn, int i1, int i2, double v, String s1) {
    }

    public Employee(String s, String rsn) {
    }
}

