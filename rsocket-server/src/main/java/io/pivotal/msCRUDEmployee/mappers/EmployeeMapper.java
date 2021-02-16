package io.pivotal.msCRUDEmployee.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.pivotal.msCRUDEmployee.models.Employee;

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


}
