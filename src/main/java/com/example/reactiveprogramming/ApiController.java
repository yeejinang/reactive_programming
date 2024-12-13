package com.example.reactiveprogramming;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@RestController
public class ApiController {

    private final AsyncService asyncService;
    private final ReactiveService reactiveService;

    private final NormalService normalService;

    public ApiController(AsyncService asyncService, ReactiveService reactiveService, NormalService normalService) {
        this.asyncService = asyncService;
        this.reactiveService = reactiveService;
        this.normalService = normalService;
    }

    @GetMapping("/async")
    public CompletableFuture<String> getAsyncData() {
        return asyncService.fetchDataAsync();
    }

    @GetMapping("/reactive")
    public Mono<String> getReactiveData() {
        return reactiveService.fetchDataReactive();
    }

    @GetMapping("/normal")
    public String getNormal() { return normalService.fetchNormal(); }
}
