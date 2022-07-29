package com.netflix.apidata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class NetflixApiTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void all() {
        webTestClient.get()
                .uri("/api/actor/")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().valueEquals("Content-Type", "application/hal+json");
    }

    @Test
    void one() {
        webTestClient.get()
                .uri("/api/actor/128253")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().valueEquals("Content-Type", "application/hal+json")
                .expectBody()
                //.jsonPath("$.id").isEqualTo(128253)
                .jsonPath("$.name").isEqualTo("Ama Qamata");
    }
}
