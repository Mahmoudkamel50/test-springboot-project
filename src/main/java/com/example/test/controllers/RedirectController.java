package com.example.test.controllers;

import com.example.test.services.RedirectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redirect")
@Slf4j
public class RedirectController {

    @Autowired
    private RedirectService redirectService;

    @PostMapping
    public String postApi(@RequestParam String api, @RequestParam String methodType, @RequestBody String body, @RequestParam int expectedStatus) {
        log.info("Start request with data: api={}, methodType={}, body={}, expectedStatus={}", api, methodType, body, expectedStatus);
        return redirectService.sendRequest(api, methodType, body, expectedStatus);
    }
}