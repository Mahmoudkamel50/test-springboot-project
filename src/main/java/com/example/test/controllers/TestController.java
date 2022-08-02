package com.example.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/myapp")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    String url= "https://endpoint.free.beeceptor.com/my/api/path/favicon.ico";
    @GetMapping
    public Object getApi(){
       String response= restTemplate.getForObject(url, String.class);
       return response;
    }

    /**
     * here i tried to solve it by passing the url throw the method but i faced an error
    @GetMapping(path = "/test")
    public ResponseEntity<?> getApi2(URL url){
       return new  ResponseEntity<String>(restTemplate.getForEntity(url, String.class), HttpStatus.OK);
    }
    */
}