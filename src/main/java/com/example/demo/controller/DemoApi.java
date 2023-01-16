package com.example.demo.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ApiRequest;
import com.example.demo.model.ApiResponse;

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

    /**
     * Default greeting as JSON
     * http://localhost:8080/api/greeting/post
     * @return
     */
    @PostMapping(value = { "/greeting/post" }, produces = "application/json")
    public ResponseEntity<ApiResponse> postGreeting(@RequestBody String name) {
        System.out.println("/api/greeting/post Started");

        String service = "/api/greeting/post";
        String status = "Sucess";
        String statusCode = "200";
        System.out.println("name : " + name);
        String message = "Hello World from " + name;
        
        ApiResponse response = ApiResponse.builder().service(service).status(status).statusCode(statusCode).message(message).build();

        System.out.println("/api/greeting/get Finished");
        return ResponseEntity.ok(response);
    }

    /**
     * Default greeting as JSON
     * http://localhost:8080/api/greeting/post2
     * @return
     */
    @PostMapping(value = { "/greeting/post2" }, produces = "application/json")
    public ResponseEntity<ApiResponse> postGreeting2(@RequestBody ApiRequest request) {
        System.out.println("/api/greeting/post2 Started");

        String service = "/api/greeting/post";
        String status = "Sucess";
        String statusCode = "200";
        String message = request.getMessage() + request.getName();
        
        ApiResponse response = ApiResponse.builder().service(service).status(status).statusCode(statusCode).message(message).build();

        System.out.println("/api/greeting/get Finished");
        return ResponseEntity.ok(response);
    }
}
