package com.example.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.mappers.IMapper;
import com.example.api.services.IRSocketClient;
import com.example.api.messages.Message;
import com.example.api.models.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    //@Qualifier("cliente-componente")
    @Qualifier("cliente-bean-conf")
    private IRSocketClient rSocketClient;

    @Autowired
    private IMapper employeeMapper;

    @GetMapping({"/", ""})
    public String index(){
        return "Bienvenido a index";
    }

    @GetMapping("/employees")
    public List<Employee> getAll() throws InterruptedException{
        Message msg = rSocketClient.requestResponse("getAll", (long) 0);
        return formatList(msg);
    }

    @GetMapping("/employees/{id}")
    public List<Employee> getById(@PathVariable("id") Long id) throws InterruptedException, JsonProcessingException {
        Message msg = rSocketClient.requestResponse("getById", id);
        return formatList(msg);
    }

    @PostMapping("/employees")
    public List<Employee> addEmployee(@RequestBody Employee newEmployee) throws InterruptedException, JsonProcessingException {
        logger.info("Employee: " + employeeMapper.EmployeeToString(newEmployee));
        Message msg = rSocketClient.requestResponse("addEmployee", newEmployee);
        return formatList(msg);
    }

    private List<Employee> formatList(Message msg){
        Stream<Employee> emp = msg.getEmployees().stream().map(s -> {
            try {
                return employeeMapper.StringToEmployee(s);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return null;
        });
        List<Employee> employees = emp.collect(Collectors.toList());

        return employees;
    }
}
