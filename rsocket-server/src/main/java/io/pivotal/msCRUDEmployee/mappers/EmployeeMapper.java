package io.pivotal.msCRUDEmployee.mappers;

import java.io.DataInput;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.pivotal.msCRUDEmployee.models.Employee;
import net.minidev.json.JSONObject;

@Component
public class EmployeeMapper implements IMapper{

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Employee StringToEmployee(String employeeJson) {

        return objectMapper.convertValue(employeeJson, Employee.class);

    }

    @Override
    public String EmployeeToString(Employee employee) throws JsonProcessingException {
        return objectMapper.writeValueAsString(employee);

    }
    @Override
    public Employee DecodeEmployee(Object employeeData) throws IOException {
        Map<String, String> employeeMap = (LinkedHashMap) employeeData;
        String json = new JSONObject(employeeMap).toString();
        Employee employee = objectMapper.readValue(json, Employee.class);
        return employee;
    }


}
