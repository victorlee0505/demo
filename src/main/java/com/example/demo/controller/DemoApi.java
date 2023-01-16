package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoApi {
    /**
     * Default greeting as String
     * http://localhost:8080/api/greeting
     */
    @GetMapping(value = { "/greeting" }, produces = "application/json")
    public String getHello() {

        System.out.println("/api/greeting Started");

        String result = "Hello World from Demo";

        System.out.println("/api/greeting Finished");

        return result;

    }
}
