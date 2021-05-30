package com.rain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class TestController {

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
//
//    @GetMapping("/test")
//    public String test(String name){
//        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-server");
//        String url = serviceInstance.getUri() + "/hello?name=" + name;
//        RestTemplate restTemplate = new RestTemplate();
//        String object = restTemplate.getForObject(url, String.class);
//        return "Invoke:" + url + ",return:" + object;
//    }

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String test(String name){
        String url = "http://nacos-server/hello?name=" + name;
        String object = restTemplate.getForObject(url, String.class);
        return "Invoke:" + url + ",return:" + object;
    }

}
