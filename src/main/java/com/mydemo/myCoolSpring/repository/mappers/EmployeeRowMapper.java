package com.mydemo.myCoolSpring.repository.mappers;

import com.mydemo.myCoolSpring.modle.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("employee_id"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setWorkM(rs.getInt("work_hours"));
        employee.setAge(rs.getInt("age"));
        employee.setBasicSalary(rs.getFloat("basic_salary"));
        employee.setNetSalary(rs.getFloat("net_salary"));
        return employee;
    }
}
