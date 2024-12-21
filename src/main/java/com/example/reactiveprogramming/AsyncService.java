package com.example.reactiveprogramming;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    @Async
    public CompletableFuture<String> fetchDataAsync(MutexCounter counter) {
        logThread("Async Service");
        RestTemplate rt = new RestTemplate();
        String uri = "http://localhost:8090/api/helloworld";
        HttpEntity<String> entity = new HttpEntity<>("parameters", null);
        ResponseEntity<?> result =
                rt.exchange(uri, HttpMethod.GET, entity, String.class);
        logThread((String) result.getBody());
        counter.increment();
        return CompletableFuture.completedFuture("loll");
    }

    private void logThread(String service) {
        System.out.println(new Date() + ": " + service + " executed by thread: " + Thread.currentThread().getId() +  " || " +Thread.currentThread().getName());
    }
}


//        Server Software:
//        Server Hostname:        127.0.0.1
//        Server Port:            8080
//
//        Document Path:          /reactive
//        Document Length:        21 bytes
//
//        Concurrency Level:      200
//        Time taken for tests:   97.715 seconds
//        Complete requests:      1600
//        Failed requests:        0
//        Total transferred:      246400 bytes
//        HTML transferred:       33600 bytes
//        Requests per second:    16.37 [#/sec] (mean)
//        Time per request:       12214.375 [ms] (mean)
//        Time per request:       61.072 [ms] (mean, across all concurrent requests)
//        Transfer rate:          2.46 [Kbytes/sec] received
//
//        Connection Times (ms)
//                      min  mean[+/-sd] median   max
//        Connect:        4  289 287.9    195    1549
//        Processing: 10002 10323 375.0  10203   11818
//        Waiting:    10002 10236 282.1  10148   11186
//        Total:      10007 10612 589.4  10434   13103
//
//        Percentage of the requests served within a certain time (ms)
//        50%  10434
//        66%  10637
//        75%  10786
//        80%  10898
//        90%  11491
//        95%  11958
//        98%  12424
//        99%  12697
//        100%  13103 (longest request)

//        Server Software:
//        Server Hostname:        127.0.0.1
//        Server Port:            8080
//
//        Document Path:          /async
//        Document Length:        23 bytes
//
//        Concurrency Level:      200
//        Time taken for tests:   99.074 seconds
//        Complete requests:      1600
//        Failed requests:        0
//        Total transferred:      249600 bytes
//        HTML transferred:       36800 bytes
//        Requests per second:    16.15 [#/sec] (mean)
//        Time per request:       12384.242 [ms] (mean)
//        Time per request:       61.921 [ms] (mean, across all concurrent requests)
//        Transfer rate:          2.46 [Kbytes/sec] received
//
//        Connection Times (ms)
//                      min  mean[+/-sd] median   max
//        Connect:        5  447 272.2    430    1031
//        Processing: 10003 10462 371.5  10393   11736
//        Waiting:    10002 10308 330.9  10178   11416
//        Total:      10012 10908 469.3  10957   12423
//
//        Percentage of the requests served within a certain time (ms)
//        50%  10957
//        66%  11077
//        75%  11156
//        80%  11236
//        90%  11491
//        95%  11723
//        98%  11941
//        99%  12095
//        100%  12423 (longest request)
