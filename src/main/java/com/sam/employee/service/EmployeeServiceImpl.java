package com.sam.employee.service;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Override
    public String welcome() {
        return "Welcome to employee management system 1.0.0";
    }
}
