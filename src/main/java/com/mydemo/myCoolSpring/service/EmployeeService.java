package com.mydemo.myCoolSpring.service;

import com.mydemo.myCoolSpring.modle.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.mydemo.myCoolSpring.repository.EmployeeRepo;

import java.util.List;
@Component
@Service
public class EmployeeService implements EmployeeSI{
    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }
}
