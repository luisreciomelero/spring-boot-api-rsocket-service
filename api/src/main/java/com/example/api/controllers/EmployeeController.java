package com.example.api.controllers;

import javax.websocket.server.PathParam;

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

import com.example.api.services.IRSocketClient;
import com.example.api.messages.Message;
import com.example.api.models.Employee;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    //@Qualifier("cliente-componente")
    @Qualifier("cliente-bean-conf")
    private IRSocketClient rSocketClient;

    @GetMapping({"/", ""})
    public String index(){
        return "Bienvenido a index";
    }

    @GetMapping("/employees")
    public String getAll() throws InterruptedException{
        Message msg = rSocketClient.requestResponse("getAll", "");
        return "El mensaje recibido ha sido: "+msg.getData();
    }

    @GetMapping("/employees/{id}")
    public String getById(@PathVariable("id") String id) throws InterruptedException {
        Message msg = rSocketClient.requestResponse("getById", id);
        return "Accedemos a getById(): " + msg.getData();
    }

    @PostMapping("/employees")
    public String addEmployee(@RequestBody Employee newEmployee) throws InterruptedException {
        Message msg = rSocketClient.requestResponse("addEmployee", newEmployee.toString());
        return "Accedemos a addEmployee(): "+msg.getData();
    }
}
