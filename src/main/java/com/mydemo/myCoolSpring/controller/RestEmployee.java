package com.mydemo.myCoolSpring.controller;
import com.mydemo.myCoolSpring.modle.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mydemo.myCoolSpring.service.EmployeeService;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class RestEmployee {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> findAll() {

        return employeeService.findAll();
    }


}

