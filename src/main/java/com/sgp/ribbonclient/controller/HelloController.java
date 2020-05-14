package com.sgp.ribbonclient.controller;

import com.sgp.ribbonclient.bean.User;
import com.sgp.ribbonclient.service.IFeignClientService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Retry(name = "retryBackendA")
@CircuitBreaker(name = "circuitbreakerA")
public class HelloController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IFeignClientService feignClientService;

    @Value("${service.hello.url}")
    private String helloUrl;

    @RequestMapping("/hello")
    public String hello(@RequestParam String id){
        return restTemplate.getForObject(helloUrl+"/hello?id=" + id, String.class);
    }

    @RequestMapping("/feignhello")
    public String feignhello(@RequestParam String id){
        return feignClientService.hello(id);
    }

    @RequestMapping("/feignplaygameornot")
    public String feignplaygameornot(@RequestBody User user){
        return feignClientService.playgameornot(user);
    }
}
