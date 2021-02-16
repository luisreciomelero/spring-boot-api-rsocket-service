package io.pivotal.msCRUDEmployee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import io.pivotal.msCRUDEmployee.messages.Message;
import io.pivotal.msCRUDEmployee.services.IService;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
public class EmployeeRSocketController {

    static final String SERVER = "msCRUDEmployee";
    static final String RESPONSE = "Response";

    @Autowired
    @Qualifier("employeeService")
    private IService employService;

    @MessageMapping("request-response")
    Mono<Message> requestResponse(final Message request) {
        log.info("Received request-response request: {}", request);
        String data = employService.doInteraction(request.getInteraction(), request.getData());
        return Mono.just(new Message(SERVER, request.getInteraction(), data));
    }

}
