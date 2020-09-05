package com.demo.webflux;

import com.demo.tool.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * @author chenye
 */
@RestController
public class TestController {
    /**
     * localhost:8080/test1
     */
    @GetMapping("/test1")
    public Flux<String> test1() {
        return Flux.just("test");
    }

    /**
     * localhost:8080/test2
     */
    @GetMapping("/test2")
    public Mono<String> test2() {
        return Mono.just("test");
    }
    /**
     * localhost:8080/test3
     */
    @GetMapping("/test3")
    public String test3() {
        return "test3";
    }

    /**
     * localhost:8080/reslut
     */
    @GetMapping("/reslut")
    public Flux<Result> reslut() {
        return Flux.just(Result.success("reslut"));
    }
}
