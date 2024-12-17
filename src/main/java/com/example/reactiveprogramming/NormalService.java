package com.example.reactiveprogramming;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class NormalService {

    public String fetchNormal() {
        RestTemplate rt = new RestTemplate();
        String uri = "http://localhost:8090/api/helloworld";
        HttpEntity<String> entity = new HttpEntity<>("parameters", null);
        ResponseEntity<?> result =
                rt.exchange(uri, HttpMethod.GET, entity, String.class);
        logThread((String) result.getBody());
        return (String) result.getBody();
    }

    private void logThread(String service) {
        System.out.println(new Date() + ": " + service + " executed by thread: " + Thread.currentThread().getId() +  " || " +Thread.currentThread().getName());
    }
}
