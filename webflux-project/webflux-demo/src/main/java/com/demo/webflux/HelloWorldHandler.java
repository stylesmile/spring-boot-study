package com.demo.webflux;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author chenye
 */
@Component
public class HelloWorldHandler {

    public Mono<ServerResponse> helloWorld(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("hello flux"));
    }
    public Mono<ServerResponse> helloWorld2(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("hello flux"));
    }

}