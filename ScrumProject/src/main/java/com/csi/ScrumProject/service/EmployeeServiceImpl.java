package com.csi.ScrumProject.service;

import com.csi.ScrumProject.dao.EmployeeDaoImpl;
import com.csi.ScrumProject.exceptions.EmployeeRecordNotFoundException;
import com.csi.ScrumProject.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {
    //****Scrum project by rushi Nichit




    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    Boolean flag = false;

    public Employee signUp(Employee employee) {
        return employeeDaoImpl.signUp(employee);
    }

    public Boolean signIn(String email, String password) {
        return employeeDaoImpl.signIn(email, password);
    }

    public Optional<Employee> getDataById(int id) {
        return employeeDaoImpl.getDataById(id);
    }

    public List<Employee> getDataByName(String name) {
        return employeeDaoImpl.getDataByName(name);
    }

    public Employee getDataByEmail(String email) {
        return employeeDaoImpl.getDataByEmail(email);
    }

    public Employee getDataByContactNumber(long contactNumber) {
        return employeeDaoImpl.getDataByContactNumber(contactNumber);
    }

    public List<Employee> getDataByUsingAnyInput(String input) throws EmployeeRecordNotFoundException {
        return employeeDaoImpl.getDataByUsingAnyInput(input);
    }

    public List<Employee> getAllData() {
        return employeeDaoImpl.getAllData();
    }

    public List<Employee> sortByName() {
        return employeeDaoImpl.sortByName();
    }

    public List<Employee> sortById() {
        return employeeDaoImpl.sortById();
    }

    public List<Employee> sortBySalary() {
        return employeeDaoImpl.sortBySalary();
    }

    public List<Employee> sortByAge() {
        return employeeDaoImpl.sortByAge();
    }

    public List<Employee> sortByDOB() {
        return employeeDaoImpl.sortByDOB();
    }

    public List<Employee> filterDataBySalary() {
        return employeeDaoImpl.filterDataBySalary();
    }

    public boolean loanEligibility(int id) {
        return employeeDaoImpl.loanEligibility(id);
    }

    public Employee updateData(Employee employee) {
        return employeeDaoImpl.updateData(employee);
    }

    public void deleteData(int id) {
        employeeDaoImpl.deleteData(id);
    }

    public void deleteAll() {
        employeeDaoImpl.deleteAll();
    }

    public Optional<Employee> FetchSecondHighest() {
        return employeeDaoImpl.FetchSecondHighest();
    }

    public void sendSimpleEmail(String toEmail, String subject, String body) {
        employeeDaoImpl.sendSimpleEmail(toEmail, subject, body);
    }
}
