package com.csi.ScrumProject.dao;

import com.csi.ScrumProject.Repository.EmployeeRepository;
import com.csi.ScrumProject.exceptions.EmployeeRecordNotFoundException;
import com.csi.ScrumProject.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;


@Component
public class EmployeeDaoImpl {

    //****Scrum project by rushi Nichit


    @Autowired
    EmployeeRepository employeeRepositoryImpl;


    Employee employee3;

    Boolean flag = false;

    Boolean TrueFlag = true;

    public Employee signUp(Employee employee) {
//        for (Employee employee1 : employeeRepositoryImpl.findAll()) {
//            if (employee3.getName().equals(employee1.getName()) || employee3.getEmail().equals(employee1.getEmail()) || employee3.getId() == employee1.getId() || employee3.getContactNumber() == employee1.getContactNumber()) {
//                System.out.println("already user exists");
//            }
//        }


        return employeeRepositoryImpl.save(employee);
    }


    public Boolean signIn(String email, String password) {


        for (Employee employee : employeeRepositoryImpl.findAll()) {
            if (employee.getEmail().equals(email) && employee.getPassword().equals(password)) {
                flag = true;
            }
        }
        return flag;
    }

    public Employee getDataById(int id) {
        return employeeRepositoryImpl.findById(id);
    }

    public List<Employee> getDataByName(String name) {
        return employeeRepositoryImpl.findByName(name);
    }

    public Employee getDataByEmail(String email) {
        return employeeRepositoryImpl.findByEmail(email);
    }

    public Employee getDataByContactNumber(long contactNumber) {
        return employeeRepositoryImpl.findByContactNumber(contactNumber);
    }

    public List<Employee> getDataByUsingAnyInput(String input) throws EmployeeRecordNotFoundException {


        List<Employee> employeeList = new ArrayList<>();

        for (Employee employee : employeeRepositoryImpl.findAll()) {

            if (String.valueOf(employee.getEmail()).equals(input) || employee.getName().equals(input) || employee.getEmail().equals(input) || String.valueOf(employee.getContactNumber()).equals(input) || String.valueOf(employee.getDOB()).equals(input)) {

                employeeList.add(employee);

            }
        }
        return employeeList;
    }

    public List<Employee> getAllData() {
        return employeeRepositoryImpl.findAll();
    }

    public List<Employee> sortByName() {
        return employeeRepositoryImpl.findAll().stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).collect(Collectors.toList());
    }

    public List<Employee> sortById() {
        return employeeRepositoryImpl.findAll().stream().sorted(Comparator.comparingInt(Employee::getId)).collect(Collectors.toList());
    }

    public List<Employee> sortBySalary() {
        return employeeRepositoryImpl.findAll().stream().sorted(Comparator.comparingDouble(Employee::getSalary)).collect(Collectors.toList());
    }

    public List<Employee> sortByAge() {
        return employeeRepositoryImpl.findAll().stream().sorted(Comparator.comparingInt(Employee::getAge)).collect(Collectors.toList());
    }

    public List<Employee> sortByDOB() {
        return employeeRepositoryImpl.findAll().stream().sorted(Comparator.comparing(Employee::getDOB)).collect(Collectors.toList());
    }

    public List<Employee> filterDataBySalary() {
        return employeeRepositoryImpl.findAll().stream().filter(employee -> employee.getSalary() >= employee.getSalary()).collect(Collectors.toList());
    }

    public String loanEligibility(int id) {

        for (Employee employee : employeeRepositoryImpl.findAll()) {
            if (employee.getId() == id && employee.getSalary() >= 50000) {
                return "Yes you are Eligible for loan";
            }
        }
        return "you are not eligible for loan";
    }

    public Employee updateData(Employee employee) {
        return employeeRepositoryImpl.save(employee);
    }

    public void deleteData(int id) {
        employeeRepositoryImpl.deleteById(id);
    }

    public void deleteAll() {
        employeeRepositoryImpl.deleteAll();
    }

    public Optional<Employee> FetchSecondHighest() {
        return employeeRepositoryImpl.findAll().stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst();

    }

}

