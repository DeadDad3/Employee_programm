package ru.kudukhov.Employee;

public class Employee {
    public Employee(Long id, String lastName, String firstName, String employeeNumber, String email) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.employeeNumber = employeeNumber;
        this.email = email;
    }

    private Long id;
    private String lastName;
    private String firstName;
    private String employeeNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;


}