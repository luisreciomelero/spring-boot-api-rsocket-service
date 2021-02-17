package io.pivotal.msCRUDEmployee.mappers;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.pivotal.msCRUDEmployee.models.Employee;

@Mapper
public interface IMapper{

    Employee StringToEmployee(String employeeJson);
    String EmployeeToString(Employee employee) throws JsonProcessingException;

    Employee DecodeEmployee(Object data) throws IOException;

}
