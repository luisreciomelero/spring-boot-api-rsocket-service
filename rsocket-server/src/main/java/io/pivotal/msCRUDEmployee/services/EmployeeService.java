package io.pivotal.msCRUDEmployee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.pivotal.msCRUDEmployee.DAOs.IEmployeeRepository;

@Service("employeeService")
public class EmployeeService implements IService{

    @Autowired
    private IEmployeeRepository repository;

    @Override
    public String doInteraction(String interaction, String data) {

        return "LLEGAMOS AL SERVICIO";
    }
}
