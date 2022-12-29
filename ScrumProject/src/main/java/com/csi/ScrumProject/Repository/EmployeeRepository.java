package com.csi.ScrumProject.Repository;

import com.csi.ScrumProject.model.Employee;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public Employee findById(int id);

    public List<Employee> findByName(String name);

    public Employee findByContactNumber(long contactNumber);

    public Employee findByEmail(String email);


}
/*
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

    public Employee findById(int id);

    public List<Employee> findByName(String name);

    public Employee findByContactNumber(long contactNumber);

    public Employee findByEmail(String email);


*/

