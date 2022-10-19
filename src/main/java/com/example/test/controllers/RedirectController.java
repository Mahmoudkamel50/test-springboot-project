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
    public String postApi(@RequestParam String api, @RequestParam String methodType, @RequestBody String body) {
        log.info("Start request with data: api={}, methodType={}, body={}", api, methodType, body);
        return redirectService.sendRequest(api, methodType, body, 200);
    }

    @GetMapping
    public String getApi(@RequestParam String api, @RequestParam String methodType) {
        log.info("Start request with data: api={}, methodType={}", api, methodType);
        return redirectService.sendRequest(api, methodType, null, 200);
    }

    @PutMapping
    public String updateApi(@RequestParam String api, @RequestParam String methodType, @RequestBody String body) {
        log.info("Start request with data: api={}, methodType={}, body={}", api, methodType,body);
        return redirectService.sendRequest(api, methodType, body, 200);
    }

    @DeleteMapping
    public String deleteApi(@RequestParam String api, @RequestParam String methodType) {
        log.info("Start request with data: api={}, methodType={}", api, methodType);
        return redirectService.sendRequest(api, methodType, null, 200);
    }
}