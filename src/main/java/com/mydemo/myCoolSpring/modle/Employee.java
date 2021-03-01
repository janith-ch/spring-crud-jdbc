package com.mydemo.myCoolSpring.modle;

import lombok.Data;

@Data
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private int workM; //work hours of a month
    private float basicSalary;
    private float netSalary;

    public Employee(){

    }

}
