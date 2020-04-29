package com.sam.employee.service;

import com.sam.employee.model.Employee;
import com.sam.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public String welcome() {
        return "Welcome to employee management system 1.0.0";
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeByID(Integer employeeID) {
        return employeeRepository.findById(employeeID);
    }
}
