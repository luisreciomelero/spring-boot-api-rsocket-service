package com.example.api.mappers;


import java.io.IOException;
import java.util.LinkedHashMap;

import com.example.api.models.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;



public interface IMapper{

    Employee StringToEmployee(String employeeJson) throws JsonProcessingException;
    String EmployeeToString(Employee employee) throws JsonProcessingException;

    Employee DecodeEmployee(LinkedHashMap<String, String> data) throws IOException;
}
