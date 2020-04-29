package com.sam.employee.repository;

import com.sam.employee.model.Employee;
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

    public Employee findById(long id) {
        return jdbcTemplate.queryForObject("select * from employee where employeeID=?", new Object[] { id },
                new BeanPropertyRowMapper<>(Employee.class));
    }

    public int deleteById(Integer employeeID) {
        return jdbcTemplate.update("delete from employee where employeeID=?", new Object[] { employeeID });
    }

    public int insert(Employee employee) {
        return jdbcTemplate.update("insert into employee (employeeID, employeeName, age, mobileNumber, salary, city) " + "values(?, ?, ?, ?, ?. ?)",
                new Object[] { employee.getEmployeeID(), employee.getEmployeeName(), employee.getAge(), employee.getMobileNumber(), employee.getSalary(), employee.getCity() });
    }

    /*public int update(Employee employee) {
        return jdbcTemplate.update("update employee " + " set name = ?, passport_number = ? " + " where id = ?",
                new Object[] { employee.getName(), employee.employee(), employee.getId() });
    }*/

}
