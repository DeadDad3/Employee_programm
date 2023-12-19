package ru.kudukhov.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcEmployeeRepository implements EmployeeRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcEmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            Employee employee = new Employee(
                    resultSet.getLong("id"),
                    resultSet.getString("last_name"),
                    resultSet.getString("first_name"),
                    resultSet.getString("employee_number"),
                    resultSet.getString("email")
            );
            return employee;
        });
    }

    @Override
    public Employee getEmployeeById(Long id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, rowNum) -> {
            Employee employee = new Employee(
                    resultSet.getLong("id"),
                    resultSet.getString("last_name"),
                    resultSet.getString("first_name"),
                    resultSet.getString("employee_number"),
                    resultSet.getString("email")
            );
            return employee;
        });
    }

    @Override
    public Employee createEmployee(Employee employee) {
        String sql = "INSERT INTO employee (last_name, first_name, employee_number, email) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, employee.getLastName(), employee.getFirstName(), employee.getEmployeeNumber(), employee.getEmail());
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        String sql = "UPDATE employee SET last_name = ?, first_name = ?, employee_number = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getLastName(), employee.getFirstName(), employee.getEmployeeNumber(), employee.getEmail(), employee.getId());
        return employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
