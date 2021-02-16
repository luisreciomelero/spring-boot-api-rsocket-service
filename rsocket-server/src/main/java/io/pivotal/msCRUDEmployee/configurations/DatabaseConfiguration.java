package io.pivotal.msCRUDEmployee.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.pivotal.msCRUDEmployee.DAOs.IEmployeeRepository;
import io.pivotal.msCRUDEmployee.mappers.IMapper;
import io.pivotal.msCRUDEmployee.models.Employee;

@Configuration
public class DatabaseConfiguration {

    @Autowired
    private IEmployeeRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @Bean
    public String loadDatabase(IEmployeeRepository repository){
        repository.save(new Employee("Bilbo", "Baggings", "thief"));
        repository.save(new Employee("Frodo", "Baggings", "burglar"));
        return "ok";
    }


}
