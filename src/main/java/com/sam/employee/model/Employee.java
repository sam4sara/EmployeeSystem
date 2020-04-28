package com.sam.employee.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    private Integer employeeID;
    private String EmployeeName;
    private String age;
    private String mobileNumber;
    private String salary;
    private String city;
}
