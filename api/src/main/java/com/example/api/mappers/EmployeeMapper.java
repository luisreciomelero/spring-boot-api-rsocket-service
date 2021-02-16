package com.example.api.mappers;

import org.springframework.stereotype.Component;

import com.example.api.models.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;


@Component
public class EmployeeMapper implements IMapper{

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Employee StringToEmployee(String employeeJson) throws JsonProcessingException {
        return objectMapper.readValue(employeeJson, Employee.class);

    }

    @Override
    public String EmployeeToString(Employee employee) throws JsonProcessingException {
        return objectMapper.writeValueAsString(employee);

    }


}
