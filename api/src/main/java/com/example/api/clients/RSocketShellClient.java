package com.example.api.clients;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.example.api.messages.Message;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@ShellComponent
public class RSocketShellClient  {
    /*
     * Con el objeto RSocketRequester realizaremos las peticiones
     * al servidor.
     */
    private final RSocketRequester rSocketRequester;

    @Autowired
    public RSocketShellClient(RSocketRequester.Builder rsocketRequesterBuilder) {
        this.rSocketRequester = rsocketRequesterBuilder
                .tcp("localhost",7000);

    }



    @ShellMethod("Send one request. One response will be printed.")
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

