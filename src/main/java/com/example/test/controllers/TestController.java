package com.example.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/myapp")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path = "/test")
    public Object getApi(@RequestParam String api){
        String response= restTemplate.getForObject(api, String.class);
        return response;
    }

}