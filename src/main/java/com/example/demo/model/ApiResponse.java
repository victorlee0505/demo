package com.example.demo.model;

public class ApiResponse {
    private String service;
    private String status;
    private String statusCode;
    private String message;
    
    public ApiResponse() {
    }

    public ApiResponse(String service, String status, String statusCode, String message) {
        this.service = service;
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
}
