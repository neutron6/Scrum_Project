package com.csi.ScrumProject.controller;

import com.csi.ScrumProject.exceptions.EmployeeRecordNotFoundException;
import com.csi.ScrumProject.model.Employee;
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

    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@RequestBody Employee employee) {
        log.info("########SAVING DATA SUCCESSFULLY######" + getDataByName(employee.getName()));
        return ResponseEntity.ok(employeeServiceImpl.signUp(employee));

    }

    @GetMapping("/signin/{email}/{password}")
    public ResponseEntity<Boolean> signIn(@PathVariable String email, String password) {
        return ResponseEntity.ok(employeeServiceImpl.signIn(email, password));
    }

    @GetMapping("/getdatabyid/{id}")
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int id) throws EmployeeRecordNotFoundException {

        Employee employee1 = employeeServiceImpl.getDataById(id).orElseThrow(() -> new RuntimeException());

        return ResponseEntity.ok(employeeServiceImpl.getDataById(id));
    }

    @GetMapping("/getdatabyname/{name}")
    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String name) {
        return ResponseEntity.ok(employeeServiceImpl.getDataByName(name));
    }

    @GetMapping("/getDataByEmail/{email}")
    public ResponseEntity<Employee> getDataByEmail(@PathVariable String email) {
        return ResponseEntity.ok(employeeServiceImpl.getDataByEmail(email));
    }

    @GetMapping("/getDataByContactNumber/{empContactNumber}")
    public ResponseEntity<Employee> getDataByContactNumber(@PathVariable long contactNumber) {
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
        
        return  ResponseEntity.ok((employeeServiceImpl.loanEligibilty(id));
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

    @PostMapping("/mail/toEmail/subject/body")
    public void sendSimpleEmail(@RequestParam String toEmail, String subject, String body) {
        employeeServiceImpl.sendSimpleEmail(toEmail, subject, body);
    }
}

