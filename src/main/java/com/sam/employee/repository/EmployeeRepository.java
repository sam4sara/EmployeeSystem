package com.sam.employee.repository;

import com.sam.employee.model.Employee;
import com.sam.employee.utility.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from employee", new EmployeeRowMapper());
    }

    public Employee findById(long id) {
        return jdbcTemplate.queryForObject("select * from employee where employeeID=?", new Object[] { id },
                new BeanPropertyRowMapper<>(Employee.class));
    }

    public int deleteEmployeeById(Integer employeeID) {
        return jdbcTemplate.update("delete from employee where employeeID=?", new Object[] { employeeID });
    }

    public int insertEmployee(Employee employee) {
        return jdbcTemplate.update("insert into employee (employeeID, employeeName, age, mobileNumber, salary, city) " + "values(?, ?, ?, ?, ?, ?)",
                new Object[] { employee.getEmployeeID(), employee.getEmployeeName(), employee.getAge(), employee.getMobileNumber(), employee.getSalary(), employee.getCity() });
    }

    public int updateEmployee(Employee employee) {
        return jdbcTemplate.update("update employee " + " set employeeName = ?, age = ?,  mobileNumber = ?, salary = ?, city = ? " + " where employeeID = ?",
                new Object[] { employee.getEmployeeName(), employee.getAge(), employee.getMobileNumber(), employee.getSalary(), employee.getCity(), employee.getEmployeeID() });
    }
}
