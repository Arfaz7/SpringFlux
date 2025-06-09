package com.example.SpringFlux;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class SpringFluxApplicationTests {

	@Nested
	class FluxTest {
		@Test
		void fluxTestError() {
			Flux<String> stringFlux = Flux.just("Sushi", "Ramen", "Burger", "Pizza")
					.concatWith(Flux.error(new RuntimeException("Exception")))
					.log();

			stringFlux.subscribe(System.out::println, System.err::println);
		}

		@Test
		void fluxTestComplete() {
			Flux<String> stringFlux = Flux.just("Sushi", "Ramen", "Burger", "Pizza")
					.log();

			stringFlux.subscribe(System.out::println, System.err::println, () -> System.out.println("---End---"));
		}

		@Test
		void fluxStepVerifyComplete() {
			Flux<String> stringFlux = Flux.just("Sushi", "Ramen", "Burger", "Pizza")
					.log();

			StepVerifier.create(stringFlux)
					.expectNext("Sushi")
					.expectNext("Ramen")
					.expectNext("Burger")
					.expectNext("Pizza")
					.verifyComplete();
		}

		@Test
		void fluxStepVerifyError() {
			Flux<String> stringFlux = Flux.just("Sushi", "Ramen", "Burger", "Pizza")
					.concatWith(Flux.error(new RuntimeException("Exception")))
					.log();

			StepVerifier.create(stringFlux)
					.expectNext("Sushi")
					.expectNext("Ramen")
					.expectNext("Burger")
					.expectNext("Pizza")
					.verifyError(RuntimeException.class);
		}
	}

	@Nested
	class MonoTest {
		@Test
		void monoTest() {
			Mono<String> stringMono = Mono.just("Bagel").log();

			StepVerifier.create(stringMono)
					.expectNext("Bagel")
					.verifyComplete();
		}
	}

}
