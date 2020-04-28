package com.sam.employee.model;

public class Employee {
    private Integer employeeID;
    private String employeeName;
    private String age;
    private String mobileNumber;
    private String salary;
    private String city;

    public Employee() { }
    public Employee(Integer employeeID, String employeeName, String age, String mobileNumber, String salary, String city) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.age = age;
        this.mobileNumber = mobileNumber;
        this.salary = salary;
        this.city = city;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", EmployeeName='" + employeeName + '\'' +
                ", age='" + age + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", salary='" + salary + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
