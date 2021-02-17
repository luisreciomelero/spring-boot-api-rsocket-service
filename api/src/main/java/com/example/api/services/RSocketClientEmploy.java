package com.example.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Component;

import com.example.api.mappers.IMapper;
import com.example.api.messages.Message;
import com.example.api.models.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("cliente-componente")
public class RSocketClientEmploy implements IRSocketClient{
    /*
     * Con el objeto RSocketRequester realizaremos las peticiones
     * al servidor.
     */
    private final RSocketRequester rSocketRequester;
    
    @Autowired
    private IMapper employeemapper;

    public RSocketClientEmploy(RSocketRequester.Builder rsocketRequesterBuilder) {
        this.rSocketRequester = rsocketRequesterBuilder
                .tcp("localhost",7000);

    }


    //@ShellMethod("Send one request. One response will be printed.")
    public Message requestResponse(String interaction, Employee employee) throws InterruptedException {
        log.info("\nSending one request. Waiting for one response...");

        Message message = this.rSocketRequester
                .route("request-response")
                .data(new Message("Client", interaction, employee))
                .retrieveMono(Message.class)
                .block();
        log.info("\nResponse was: {}", message);
        return message;
    }

    public Message requestResponse(String interaction, Long data) throws InterruptedException {
        log.info("\nSending one request. Waiting for one response...");

        Message message = this.rSocketRequester
                .route("request-response")
                .data(new Message("Client", interaction, data))
                .retrieveMono(Message.class)
                .block();
        log.info("\nResponse was: {}", message);
        log.info("tipo: " + message.getEmployees().get(0).getClass().getName());

        return message;
    }

}