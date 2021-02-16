package com.example.api.mappers;


import com.example.api.models.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;



public interface IMapper{

    Employee StringToEmployee(String employeeJson) throws JsonProcessingException;
    String EmployeeToString(Employee employee) throws JsonProcessingException;
}
