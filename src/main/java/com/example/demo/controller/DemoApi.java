package com.example.demo.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /**
     * Default greeting as JSON
     * http://localhost:8080/api/greeting/get
     * @return
     */
    @GetMapping(value = { "/greeting/get" }, produces = "application/json")
    public ResponseEntity<Map<String, String>> getGreeting() {
        System.out.println("/api/greeting/get Started");
        ResponseEntity<?> entRes = null;
        Map<String, String> response = new HashMap<String, String>();
        response.put("service", "/api/greeting/get");
        response.put("status", "Success");
        response.put("statusCode", "200");
        response.put("message", "Hello World from Demo");

        entRes = ResponseEntity.status(HttpStatus.OK).body(Collections.unmodifiableMap(response));
        @SuppressWarnings("unchecked")
        final ResponseEntity<Map<String, String>> resEnt = (ResponseEntity<Map<String, String>>) entRes;

        System.out.println("/api/greeting/get Finished");
        return resEnt;
    }
}
