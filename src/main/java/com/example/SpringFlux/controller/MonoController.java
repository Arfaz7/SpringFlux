package com.example.SpringFlux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MonoController {
    @GetMapping("/mono")
    public Mono<Integer> getMono() {
        return Mono.just(1)
                .log();
    }
}
