Benchmarking

```
ab -n 1600 -c 200 http://127.0.0.1:8080/async
```

```
ab -n 1600 -c 200 http://127.0.0.1:8080/reactive
```

```
k6 run script.js
```
