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

    private static final MutexCounter mutexCounter = new MutexCounter();

    public ApiController(AsyncService asyncService, ReactiveService reactiveService, NormalService normalService) {
        this.asyncService = asyncService;
        this.reactiveService = reactiveService;
        this.normalService = normalService;
    }

    @GetMapping("/async")
    public String getAsyncData() {
         asyncService.fetchDataAsync(mutexCounter);
         return "hello";
    }

    @GetMapping("/reactive")
    public String getReactiveData() {
         reactiveService.fetchDataReactive(mutexCounter);
         return "hello";
    }

    @GetMapping("/normal")
    public String getNormal() { return normalService.fetchNormal(mutexCounter); }
}
