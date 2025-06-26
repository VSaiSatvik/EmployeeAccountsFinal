package com.crudapi.employeeaccountapi.model;

import jakarta.persistence.*;

@Entity
public class EmployeeAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String employeeId;
    private String name;
    private String bankAccountNumber;
    private String bankName;

    public Long getId() {
        return id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
