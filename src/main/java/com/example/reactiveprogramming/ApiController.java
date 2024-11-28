package com.example.reactiveprogramming;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@RestController
public class ApiController {

    private final AsyncService asyncService;
    private final ReactiveService reactiveService;

    public ApiController(AsyncService asyncService, ReactiveService reactiveService) {
        this.asyncService = asyncService;
        this.reactiveService = reactiveService;
    }

    @GetMapping("/async")
    public CompletableFuture<String> getAsyncData() {
        return asyncService.fetchDataAsync();
    }

    @GetMapping("/reactive")
    public Mono<String> getReactiveData() {
        return reactiveService.fetchDataReactive();
    }
}
