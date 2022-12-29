package com.csi.ScrumProject.tests;

import com.csi.ScrumProject.Repository.EmployeeRepository;
import com.csi.ScrumProject.dao.EmployeeDaoImpl;
import com.csi.ScrumProject.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeDaoImpltests {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    @MockBean
    EmployeeRepository employeeRepository;

    @Test
    public void getAllDataTest() {

        when(employeeRepository.findAll()).thenReturn(Stream.of(new Employee(1, "John", "john@gmail.com", "rsn", 83798970, 18, 50000.00, "")).collect(Collectors.toList()));

        assertEquals(1, employeeDaoImpl.getAllData().size());
    }

    @Test
    public void signUpTest() {
        Employee employee = new Employee(1, "John", "john@gmail.com", "rsn", 83798970, 18, 50000.00, "");

        employeeDaoImpl.signUp(employee);

        verify(employeeRepository, times(1)).save(employee);


    }

    @Test
    public void deleteDataTest() {
        Employee employee = new Employee(1, "John", "john@gmail.com", "rsn", 83798970, 18, 50000.00, "");

        employeeDaoImpl.deleteAll();

        verify(employeeRepository, times(1)).deleteAll();
    }

    @Test
    public void signInTest() {
        Employee employee = new Employee("john@gmail.com", "rsn");

        employeeDaoImpl.signIn("john@gmail.com", "rsn");

        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    public void loanEligibilityTest() {

        Employee employee = new Employee(2, "Mike", "mike@gmail.com", "rsn", 83798970, 18, 40000.23, "");
        new Employee(1, "John", "john@gmail.com", "rsn", 83798970, 18, 70000.00, "");
        employeeDaoImpl.loanEligibility(2);
        employeeDaoImpl.loanEligibility(1);

        verify(employeeRepository, times(2)).findAll();
    }

    @Test
    public void getDataByIdTest() {

        Employee employee = new Employee(1, "John", "john@gmail.com", "rsn", 83798970, 18, 50000.00, "");

        employeeDaoImpl.getDataById(employee.getId());

        verify(employeeRepository, times(1)).findById(employee.getId());
    }

    @Test
    public void updateData() {
        Employee employee = new Employee(1, "John", "john@gmail.com", "rsn", 83798970, 18, 50000.00, "");

        employeeDaoImpl.updateData(employee);

        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    public void getDataByName() {
        Employee employee = new Employee(1, "John", "john@gmail.com", "rsn", 83798970, 18, 50000.00, "");

        employeeDaoImpl.getDataByName("John");

        verify(employeeRepository, times(1)).findByName("John");
    }

    @Test
    public void getDataByEmail() {
        Employee employee = new Employee(1, "John", "john@gmail.com", "rsn", 83798970, 18, 50000.00, "");

        employeeDaoImpl.getDataByEmail("john@gmail.com");

        verify(employeeRepository, times(1)).findByEmail("john@gmail.com");

    }

    @Test
    public void getDataByContactNumber() {
        Employee employee = new Employee(1, "John", "john@gmail.com", "rsn", 83798970, 18, 50000.00, "");

        employeeDaoImpl.getDataByContactNumber(83798970);

        verify(employeeRepository, times(1)).findByContactNumber(83798970);

    }

    @Test
    public void sortByName() {
        Employee employee = new Employee(1, "John", "john@gmail.com", "rsn", 83798970, 18, 50000.00, "");
        new Employee(2, "rushi", "rushi@gmail.com", "123", 7898987, 23, 98000.23, "1999-06-26");
        List<Employee> ee = new ArrayList<>();
        ee.add(employee);

        employeeDaoImpl.sortByName();
        when(employeeDaoImpl.sortByName()).thenReturn(ee);


    }



}
