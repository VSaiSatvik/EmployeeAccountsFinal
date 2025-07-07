package com.crudapi.employeeaccountapi.controller;

import com.crudapi.employeeaccountapi.model.Employee;
import com.crudapi.employeeaccountapi.model.BankAccount;
import com.crudapi.employeeaccountapi.repository.EmployeeRepository;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepo;

    public EmployeeController(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    // GET all employees
    @GetMapping
    public ResponseEntity<?> getAllEmployees() {
        return ResponseEntity.ok(employeeRepo.findAll());
    }

    // GET employee by employeeId (custom field)
    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getEmployeeById(@PathVariable String employeeId) {
        Optional<Employee> employee = employeeRepo.findByEmployeeId(employeeId);

        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get()); // returns ResponseEntity<Employee>
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found"); // returns ResponseEntity<String>
        }
    }

    // POST - create employee with accounts
    @PostMapping
    public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee employee) {
        if (employee.getAccounts() != null) {
            for (BankAccount account : employee.getAccounts()) {
                account.setEmployee(employee); // set back-reference
            }
        }
        Employee saved = employeeRepo.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // PUT - update employee by employeeId
    @PutMapping("/{employeeId}")
    public ResponseEntity<?> updateEmployee(@PathVariable String employeeId,
                                            @Valid @RequestBody Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepo.findByEmployeeId(employeeId);

        if (optionalEmployee.isPresent()) {
            Employee existing = optionalEmployee.get();

            existing.setName(updatedEmployee.getName());

            // Replace all accounts (for simplicity)
            if (updatedEmployee.getAccounts() != null) {
                for (BankAccount acc : updatedEmployee.getAccounts()) {
                    acc.setEmployee(existing);
                }
                existing.setAccounts(updatedEmployee.getAccounts());
            }

            return ResponseEntity.ok(employeeRepo.save(existing));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }

    // DELETE - remove employee by employeeId
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String employeeId) {
        Optional<Employee> optional = employeeRepo.findByEmployeeId(employeeId);
        if (optional.isPresent()) {
            employeeRepo.delete(optional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }
}