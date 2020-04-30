package com.sam.employee.utility;

import com.sam.employee.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeID(rs.getInt("employeeID"));
        employee.setEmployeeName(rs.getString("employeeName"));
        employee.setAge(rs.getString("age"));
        employee.setMobileNumber(rs.getString("mobileNumber"));
        employee.setSalary(rs.getString("salary"));
        employee.setCity(rs.getString("city"));
        return employee;
    }
}
