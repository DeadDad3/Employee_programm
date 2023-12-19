package ru.kudukhov.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Long id);
}
