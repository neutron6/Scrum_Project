package com.csi.ScrumProject.Repository;

import com.csi.ScrumProject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findByName(String name);

    public Employee findByContactNumber(long contactNumber);

    public Employee findByEmail(String email);
}
