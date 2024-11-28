package com.example.reactiveprogramming;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

@Service
public class ReactiveService {

    public Mono<String> fetchDataReactive() {
        logThread("Reactive Service");
        return Mono.delay(Duration.ofSeconds(10)) // Non-blocking delay
                .map(delay -> {
                    logThread("Processing after delay");
                    return "Non-Blocking Response";
                });
    }

    private void logThread(String service) {
        System.out.println(new Date() + ": " + service + " executed by thread: id: " +  Thread.currentThread().getId() + " || " +Thread.currentThread().getName());
    }

}
