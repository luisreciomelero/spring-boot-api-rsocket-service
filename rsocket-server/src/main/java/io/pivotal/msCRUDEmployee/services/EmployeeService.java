package io.pivotal.msCRUDEmployee.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.pivotal.msCRUDEmployee.DAOs.IEmployeeRepository;
import io.pivotal.msCRUDEmployee.mappers.IMapper;
import io.pivotal.msCRUDEmployee.models.Employee;

@Service("employeeService")
public class EmployeeService implements IService{

    private static Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private IEmployeeRepository repository;

    @Autowired
    private IMapper employMapper;

    @Override
    public List<String> doInteraction(String interaction, Object data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<String> employees = new ArrayList<String>();
        switch (interaction){
            case "getAll":

                employees = repository.findAll().stream().map(employee -> {
                    try {
                        return employMapper.EmployeeToString(employee);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return null;
                }).collect(Collectors.toList());
                return employees;


            case "getById":
                if(data instanceof Long) {

                    logger.info("Data: " + data);

                    Optional<Employee> opEmployee = repository.findById((Long) data);
                    if (opEmployee.isPresent()) {
                        Employee employee = opEmployee.get();
                        String jsonEmployee = employMapper.EmployeeToString(employee);
                        employees.add(jsonEmployee);
                        return employees;
                    }
                }
                break;

            case "addEmployee":
                if(data instanceof Map){
                    Employee employee = employMapper.DecodeEmployee(data);
                    repository.save(employee);
                    employees.add(employMapper.EmployeeToString(employee));
                }

                return employees;

            default:
                throw new IllegalStateException("Unexpected value: " + interaction);
        }
        return employees;
    }
}
