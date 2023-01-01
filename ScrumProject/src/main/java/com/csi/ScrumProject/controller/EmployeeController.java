package com.csi.ScrumProject.controller;

import com.csi.ScrumProject.exceptions.EmployeeRecordNotFoundException;
import com.csi.ScrumProject.exceptions.GetDataByNameException;
import com.csi.ScrumProject.exceptions.SignInException;
import com.csi.ScrumProject.model.EmailDetails;
import com.csi.ScrumProject.model.Employee;
import com.csi.ScrumProject.service.EmailService;
import com.csi.ScrumProject.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/scrum")
@Slf4j
public class EmployeeController {

    //****Scrum project by rushi Nichit


    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    private EmailService emailService;

    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@RequestBody Employee employee) throws GetDataByNameException {
        log.info("########SAVING DATA SUCCESSFULLY######\n" + getDataByName(employee.getName()));
        return ResponseEntity.ok(employeeServiceImpl.signUp(employee));

    }

    @GetMapping("/signin/{email}/{password}")
    public void signIn(@PathVariable String email, String password) throws SignInException {
        log.info("*****SIGN IN INITIALIZED BY*****\n" + getDataByEmail(email));
        employeeServiceImpl.signIn(email, password);


    }

    @GetMapping("/getdatabyid/{id}")
    public ResponseEntity<Employee> getDataById(@PathVariable int id) throws EmployeeRecordNotFoundException {

        log.info("*****GET DATA BY ID REQ FETCHED BY*****\n" + "id-->" + getDataById(id));
        // Employee employee1 = employeeServiceImpl.getDataById(id).orElseThrow(() -> new RuntimeException());

        return ResponseEntity.ok(employeeServiceImpl.getDataById(id));
    }

    @GetMapping("/getdatabyname/{name}")
    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String name) throws GetDataByNameException {

        return ResponseEntity.ok(employeeServiceImpl.getDataByName(name));
    }

    @GetMapping("/getDataByEmail/{email}")
    public ResponseEntity<Employee> getDataByEmail(@PathVariable String email) {
        return ResponseEntity.ok(employeeServiceImpl.getDataByEmail(email));
    }

    @GetMapping("/getDataByContactNumber/{empContactNumber}")
    public ResponseEntity<Employee> getDataByContactNumber(@RequestParam long contactNumber) {
        return ResponseEntity.ok(employeeServiceImpl.getDataByContactNumber(contactNumber));
    }

    @GetMapping("/getDataByUsingAnyInput/{input}")
    public ResponseEntity<List<Employee>> getDataByUsingAnyInput(@PathVariable String input) throws EmployeeRecordNotFoundException {
        return ResponseEntity.ok(employeeServiceImpl.getDataByUsingAnyInput(input));
    }

    @GetMapping("/sortByName")
    public ResponseEntity<List<Employee>> sortByName() {
        return ResponseEntity.ok(employeeServiceImpl.sortByName());
    }

    @GetMapping("/sortById")
    public ResponseEntity<List<Employee>> sortById() {
        return ResponseEntity.ok(employeeServiceImpl.sortById());
    }

    @GetMapping("/sortBySalary")
    public ResponseEntity<List<Employee>> sortBySalary() {
        return ResponseEntity.ok(employeeServiceImpl.sortBySalary());
    }

    @GetMapping("/sortByAge")
    public ResponseEntity<List<Employee>> sortByAge() {
        return ResponseEntity.ok(employeeServiceImpl.sortByAge());
    }

    @GetMapping("/sortByDOB")
    public ResponseEntity<List<Employee>> sortByDOB() {
        return ResponseEntity.ok(employeeServiceImpl.sortByDOB());
    }

    @GetMapping("/filterDataBySalary")
    public ResponseEntity<List<Employee>> filterDataBySalary() {
        return ResponseEntity.ok(employeeServiceImpl.filterDataBySalary());
    }

    @GetMapping("/loanEligibility/{id}")
    public ResponseEntity<String> loanEligibility(@PathVariable int id) {
        return ResponseEntity.ok(employeeServiceImpl.loanEligibility(id));
    }

    @PutMapping("/updateData")
    public ResponseEntity<Employee> updateData(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeServiceImpl.updateData(employee));
    }

    @DeleteMapping("/deleteData/{id}")
    public void deleteData(@PathVariable int id) {
        employeeServiceImpl.deleteData(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        employeeServiceImpl.deleteAll();
    }

    @GetMapping("/getallData")
    public List<Employee> getAllData() {
        return employeeServiceImpl.getAllData();
    }

    @GetMapping("/getsecond")
    public Optional<Employee> FetchSecondHighest() {
        return employeeServiceImpl.FetchSecondHighest();
    }


    // Sending email with attachment
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
            @RequestBody EmailDetails details) {

        log.info("***recipient is***\n" + details.getRecipient());
        log.info("***Body is***\n" + details.getMsgBody());
        log.info("***Subject is***\n" + details.getSubject());
        String status
                = emailService.sendMailWithAttachment(details);

        return status;
    }
}


