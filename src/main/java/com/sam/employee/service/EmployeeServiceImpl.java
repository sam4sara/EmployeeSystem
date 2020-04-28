package com.sam.employee.service;

import com.sam.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Override
    public String welcome() {
        return "Welcome to employee management system 1.0.0";
    }

    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee1=new Employee(111,"Sam","30","9032905776","5000","Pune");
        Employee employee2=new Employee(112,"Jay","28","8805450294","5000","Pune");
        employeeList.add(employee1);
        employeeList.add(employee2);
        return employeeList;
    }
}
