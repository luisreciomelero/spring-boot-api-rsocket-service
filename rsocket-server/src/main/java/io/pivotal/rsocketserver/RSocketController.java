package io.pivotal.rsocketserver;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import io.pivotal.rsocketserver.data.Message;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
public class RSocketController {

    static final String SERVER = "Server";
    static final String RESPONSE = "Response";

    @MessageMapping("request-response")
    Mono<Message> requestResponse(final Message request) {
        log.info("Received request-response request: {}", request);
        return Mono.just(new Message(SERVER, RESPONSE));
    }

}
