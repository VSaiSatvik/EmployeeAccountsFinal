package com.crudapi.employeeaccountapi.repository;

import com.crudapi.employeeaccountapi.model.BankAccount;
import com.crudapi.employeeaccountapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    // Custom method to get all bank accounts for a specific employee
    List<BankAccount> findByEmployee(Employee employee);
}