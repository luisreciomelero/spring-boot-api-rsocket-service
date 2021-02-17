package com.example.api.mappers;

import java.io.DataInput;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.springframework.stereotype.Component;

import com.example.api.models.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONObject;


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

    @Override
    public Employee DecodeEmployee(LinkedHashMap<String, String> employeeData) throws IOException {
        String json = new JSONObject(employeeData).toString();
        return StringToEmployee(json);
    }


}
