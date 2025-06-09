package com.example.SpringFlux.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@WebFluxTest
class MonoControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void shouldGetMono() {
        final Integer expectedValue = 1;

        webTestClient.get().uri("/mono")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Integer.class)
                .consumeWith(response -> assertThat(response.getResponseBody()).isEqualTo(expectedValue));

    }

}