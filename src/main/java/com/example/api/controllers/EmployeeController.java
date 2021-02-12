package com.example.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.models.Employee;

@RestController
public class EmployeeController {

    @GetMapping("/employees")
    public String getAll(){
        return "Accedemos a getall()";
    }

    @GetMapping("/employees/{id}")
    public String getById(){
        return "Accedemos a getById()";
    }

    @PostMapping("/employees")
    public String addEmployee(@RequestBody Employee newEmployee){
        return "Accedemos a addEmployee(): "+newEmployee;
    }
}
