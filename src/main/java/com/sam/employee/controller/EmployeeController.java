package com.sam.employee.controller;

import com.sam.employee.model.Employee;
import com.sam.employee.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private static final Logger logger = LogManager.getLogger(EmployeeController.class);

    @Autowired
    @Qualifier("employeeServiceImpl")
    private EmployeeService employeeService;

    @GetMapping(value = "/welcome")
    public String createStudent() {
        logger.info("In welcome method");
        return employeeService.welcome();
    }

    @GetMapping(value = "/employees")
    public ResponseEntity<List<Employee>> listAllStudents() {
        logger.info("IN listAllTasks method");
        List<Employee> employeeList = employeeService.findAllEmployees();
        if (employeeList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
    }

    @GetMapping(value = "/employee/{id}")
    public ResponseEntity<?> getEmployeeByID(@Valid @PathVariable("id") String id){
        logger.info("IN getEmployee METHOD");
        Employee employee = employeeService.findEmployeeByID(Integer.parseInt(id));
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @DeleteMapping(value = "/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@Valid @PathVariable("id") String employeeID) throws Exception {
        logger.info("IN delete METHOD");
        String status = "Internal server error";
        try {
            status = employeeService.deleteEmployeeByID(Integer.parseInt(employeeID));
        } catch (Exception e) {
            throw new Exception("Employee delete is not allowed.");
        }
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
    public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee employee) throws Exception {
        logger.info("IN create METHOD");
        String status = employeeService.createEmployee(employee);
        return new ResponseEntity<>(status,HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateEmployee/{id}")
    public ResponseEntity<String> updateEmployee(@Valid @PathVariable("id") String id,
                                            @Valid @RequestBody Employee employee) throws Exception {
        String status = "Internal server error";
        logger.info("IN update METHOD");
        if(employee.getEmployeeID() == null){
            throw new Exception("Unable to update. Employee with id " + id + " not found.");
        }
        try {
            status = employeeService.updateEmployee(employee);
        } catch (Exception e) {
            throw new Exception("Employee update is not allowed.Please reload your edit student view.");
        }
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}
