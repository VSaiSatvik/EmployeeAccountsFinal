package com.crudapi.employeeaccountapi.controller;

import com.crudapi.employeeaccountapi.model.EmployeeAccount;
import com.crudapi.employeeaccountapi.repository.EmployeeAccountRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeAccountController {

    private final EmployeeAccountRepository repo;

    public EmployeeAccountController(EmployeeAccountRepository repo) {
        this.repo = repo;
    }

    // GET all employees
    @GetMapping
    public List<EmployeeAccount> getAllEmployees() {
        return repo.findAll();
    }

    // GET employee by custom employeeId
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<EmployeeAccount> getEmployeeByEmployeeId(@PathVariable String employeeId) {
        Optional<EmployeeAccount> employee = repo.findByEmployeeId(employeeId);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST - create new employee
    @PostMapping
    public EmployeeAccount createEmployee(@RequestBody EmployeeAccount employee) {
        return repo.save(employee);
    }

    // PUT - update employee by custom employeeId
    @PutMapping("/employee/{employeeId}")
    public ResponseEntity<EmployeeAccount> updateEmployee(@PathVariable String employeeId,
                                                          @RequestBody EmployeeAccount updatedEmployee) {
        Optional<EmployeeAccount> existingEmployee = repo.findByEmployeeId(employeeId);
        if (existingEmployee.isPresent()) {
            EmployeeAccount employee = existingEmployee.get();
            employee.setName(updatedEmployee.getName());
            employee.setBankAccountNumber(updatedEmployee.getBankAccountNumber());
            employee.setBankName(updatedEmployee.getBankName());
            return ResponseEntity.ok(repo.save(employee));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - delete employee by custom employeeId
    @DeleteMapping("/employee/{employeeId}")
    @Transactional
    public ResponseEntity<Void> deleteEmployee(@PathVariable String employeeId) {
        if (repo.existsByEmployeeId(employeeId)) {
            repo.deleteByEmployeeId(employeeId);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}
