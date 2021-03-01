package com.mydemo.myCoolSpring.repository;

import com.mydemo.myCoolSpring.modle.Employee;
import com.mydemo.myCoolSpring.repository.mappers.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public class EmployeeRepo implements EmployeeRI {
    @Autowired
    @Qualifier("employee-named-param-jdbc")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Employee> findAll() {
        try {
            String query = "SELECT * FROM EMPLOYEE";

            return namedParameterJdbcTemplate.query(query, new EmployeeRowMapper());
        } catch (Exception e) {
            throw new RuntimeException("error getting employee " + e.toString());
        }
    }
}
