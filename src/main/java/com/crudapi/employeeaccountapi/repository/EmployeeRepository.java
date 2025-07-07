package com.crudapi.employeeaccountapi.repository;

import com.crudapi.employeeaccountapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom finder method to get employee by their custom ID (not database ID)
    Optional<Employee> findByEmployeeId(String employeeId);
}
