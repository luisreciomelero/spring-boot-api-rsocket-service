package com.example.api.services;

import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Component;

import com.example.api.messages.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("cliente-componente")
public class RSocketClientEmploy implements IRSocketClient{
    /*
     * Con el objeto RSocketRequester realizaremos las peticiones
     * al servidor.
     */
    private final RSocketRequester rSocketRequester;

    public RSocketClientEmploy(RSocketRequester.Builder rsocketRequesterBuilder) {
        this.rSocketRequester = rsocketRequesterBuilder
                .tcp("localhost",7000);

    }


    //@ShellMethod("Send one request. One response will be printed.")
    public Message requestResponse() throws InterruptedException {
        log.info("\nSending one request. Waiting for one response...");

        Message message = this.rSocketRequester
                .route("request-response")
                .data(new Message("Client", "Request"))
                .retrieveMono(Message.class)
                .block();
        log.info("\nResponse was: {}", message);
        return message;
    }

}