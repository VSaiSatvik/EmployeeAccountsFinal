package com.crudapi.employeeaccountapi.repository;

import com.crudapi.employeeaccountapi.model.EmployeeAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeAccountRepository extends JpaRepository<EmployeeAccount, Long> {
    Optional<EmployeeAccount> findByEmployeeId(String employeeId);
    void deleteByEmployeeId(String employeeId);
    boolean existsByEmployeeId(String employeeId);
}
