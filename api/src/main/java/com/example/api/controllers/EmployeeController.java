package com.example.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.clients.RSocketShellClient;
import com.example.api.messages.Message;
import com.example.api.models.Employee;

@RestController
public class EmployeeController {

    @Autowired
    private RSocketShellClient rSocketShellClient;

    @GetMapping("/employees")
    public String getAll() throws InterruptedException{
        Message msg = rSocketShellClient.requestResponse();
        return "El mensaje recibido ha sido: "+msg;
    }

    @GetMapping("/employees/{id}")
    public String getById()  {
        return "Accedemos a getById()";
    }

    @PostMapping("/employees")
    public String addEmployee(@RequestBody Employee newEmployee){
        return "Accedemos a addEmployee(): "+newEmployee;
    }
}
