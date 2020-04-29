package com.sam.employee.service;

import com.sam.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    public String welcome();
    public List<Employee> findAllEmployees();
    public Employee findEmployeeByID(Integer employeeID);
}
