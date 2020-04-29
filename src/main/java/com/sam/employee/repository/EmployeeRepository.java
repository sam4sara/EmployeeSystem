package com.sam.employee.repository;

import com.sam.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
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

    class StudentRowMapper implements RowMapper<Employee> {
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

    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from employee", new StudentRowMapper());
    }

}
