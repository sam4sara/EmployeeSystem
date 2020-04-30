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

    @Override
    public String deleteEmployeeByID(Integer employeeID) {
        int status = employeeRepository.deleteEmployeeById(employeeID);
        return status == 1 ? "Record deleted successfully..." : "Record not deleted...";
    }

    @Override
    public String createEmployee(Employee employee) {
        int status = employeeRepository.insertEmployee(employee);
        return status == 1 ? "Record inserted successfully..." : "Record not inserted...";
    }

    @Override
    public String updateEmployee(Employee employee) {
        int status = employeeRepository.updateEmployee(employee);
        return status == 1 ? "Record updated successfully..." : "Record not updated...";
    }
}
