package com.example.reactiveprogramming;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@RequiredArgsConstructor
@EnableAsync
public class ReactiveProgrammingApplication {
//    private final AsyncService asyncService;

//    private final ReactiveService reactiveService;

    public static void main(String[] args) {
        SpringApplication.run(ReactiveProgrammingApplication.class, args);
        System.out.println("Thread: " + Thread.currentThread().getId() + Thread.currentThread().getName());
    }
}
