package com.example.reactiveprogramming;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReactiveService {

    private final WebClient webClient;

    public Mono<String> fetchDataReactive() {
        logThread("Reactive Service");
        return webClient.get()
                .uri("async")
                .retrieve()
                .bodyToMono(String.class)
                .timeout(Duration.ofSeconds(15)) // Timeout per request
                .retryWhen(Retry.fixedDelay(3, Duration.ofSeconds(20))) // Retry 3 times
                .doOnNext(response -> logThread(response))
                .doOnError(e -> log.error("Error while calling API for ID {}: {}"));
    }

    private void logThread(String service) {
        System.out.println(new Date() + ": " + service + " executed by thread: id: " +  Thread.currentThread().getId() + " || " +Thread.currentThread().getName());
    }
}
