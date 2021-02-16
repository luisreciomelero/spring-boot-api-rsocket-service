package com.example.api.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.api.interceptors.EmployeeTimeElapsedInterceptor;
import com.example.api.services.IRSocketClient;
import com.example.api.services.RSocketClientEmploy;

@Configuration
@ComponentScan(basePackages = "com.example.api")
public class ConfigurationApp implements WebMvcConfigurer {

    @Autowired
    @Qualifier("employee-te-interceptor")
    private HandlerInterceptor employeeTimeElapsedInterceptor;

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(employeeTimeElapsedInterceptor).addPathPatterns("/api/v1/**");
    }

    @Bean("cliente-bean-conf")
    public IRSocketClient rSocketClientEmploy(RSocketRequester.Builder builder){
        return new RSocketClientEmploy(builder);
    }







}
