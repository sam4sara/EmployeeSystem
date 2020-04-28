package com.sam.employee.controller;

import com.sam.employee.model.Employee;
import com.sam.employee.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    //Load all students
    @GetMapping(value = "/employees")
    public ResponseEntity<List<Employee>> listAllStudents() {

        logger.info("IN listAllTasks method");
        List<Employee> employeeList = employeeService.findAllEmployees();
        if (employeeList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
    }

    /**
     * Create a new student
     *//*
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public ResponseEntity<?> createStudent(@Valid @RequestBody EmployeeDTO employeeDTO,
                                           UriComponentsBuilder ucBuilder, Errors errors) throws Exception {
        logger.info("IN createStudent METHOD");
        if (errors.hasErrors()) {
            return getErrors(errors);
        }
        EmployeeDTO employeeDTONew = employeeServiceImpl.create(employeeDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/tasks/{id}").buildAndExpand(employeeDTONew.getId()).toUri());
        return new ResponseEntity<String>("Record inserted succesfully",headers, HttpStatus.CREATED);
    }

    *//**
     * Load all the students
     *//*


    *//**
     * Load student by id
     *//*
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getStudent(@Valid @PathVariable("id") String id) throws Exception {
        logger.info("IN getStudent METHOD");
        EmployeeDTO employeeDTO = employeeServiceImpl.findById(id);
        return new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.OK);
    }

    *//**
     * Get all the errors
     *//*
    private ResponseEntity<List<CustomErrorTypeException>> getErrors(Errors errors) {
        return ResponseEntity.badRequest().body(errors.getAllErrors()
                .stream()
                .map(msg -> new CustomErrorTypeException(msg.getDefaultMessage()))
                .collect(Collectors.toList()));
    }



    *//**
     * Update particular student by id
     *//*
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEmployee(@Valid @PathVariable("id") String id,
                                            @Valid @RequestBody EmployeeDTO employeeDTO, Errors errors) throws Exception {
        logger.info("IN updateEmployee METHOD");
        if (errors.hasErrors()) {
            return getErrors(errors);
        }
        if(employeeDTO.getId() == null){
            throw new CustomErrorTypeException("Unable to update. Employee with id " + id + " not found.");
        }
        try {
            employeeServiceImpl.update(employeeDTO);
            EmployeeDTO updatedEmployeeDTO = employeeServiceImpl.findById(id);
            return new ResponseEntity<EmployeeDTO>(updatedEmployeeDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomErrorTypeException("Employee update is not allowed.Please reload your edit student view.");
        }
    }

    *//**
     * Delete student by id
     *//*
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteStudent(@Valid @PathVariable("id") String id) throws Exception {
        logger.info("IN delete METHOD");
        try {
            employeeServiceImpl.delete(id);
            return new ResponseEntity<>("Record deleted...",HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new CustomErrorTypeException("Employee delete is not allowed.");
        }
    }*/
}
