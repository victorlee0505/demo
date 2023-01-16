package com.example.demo.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.Calculator;

@RequestMapping("/api/cal")
@RestController
public class CalculatorApi {
    
    /**
     * POST cal as JSON
     * http://localhost:8080/api/cal/post
     *  {
     *     "op": "+",
     *     "left": "3",
     *     "right": "4"
     *  }
     * @return
     */
    @PostMapping(value = { "/post" }, produces = "application/json")
    public ResponseEntity<Map<String, String>> doMath(final @RequestBody(required = false) Map<String,String> body) {

        System.out.println("/api/cal/post Started");

        ResponseEntity<?> entRes = null;
        Map<String, String> response = new HashMap<String, String>();
        response.put("Service", "/api/cal/post");

        String message = "null";

        String operator = null;
        String leftOperand = null;
		String rightOperand = null;

        if(body != null){
            if(body.containsKey("op")){
                operator = body.get("op");
            }

            if(body.containsKey("left")){
                leftOperand = body.get("left");
            }

            if(body.containsKey("right")){
                rightOperand = body.get("right");
            }
        } else {
            message = "No POST Body";
        }

        if(StringUtils.isNotBlank(operator) && StringUtils.isNotBlank(leftOperand) && StringUtils.isNotBlank(rightOperand)){

        }

        Calculator calculator = new Calculator();

        double leftNumber = calculator.parsetring2Double4LeftNumber(leftOperand);
        double rightNumber = calculator.parsetring2Double4rightNumber(rightOperand);
        
        calculator.setOperator(operator);
        calculator.setLeftOperand(leftNumber);
        calculator.setRightOperand(rightNumber);

        double result = calculator.calculateResult();

        try {
            response.put("Status", "Success");
            response.put("StatusCode", "200");
            response.put("Message", message);
            response.put("Operator", operator);
            response.put("LeftOperand", leftOperand);
            response.put("RightOperand", rightOperand);
            response.put("Result", String.valueOf(result));
        }
        catch (Exception e) {
            // LOG.error("Exception encountered, return 500", e);
            response.put("Status", "Failed");
            response.put("StatusCode", "500");
            response.put("Message", "Failed.");
            response.put("Operator", operator);
            response.put("LeftOperand", leftOperand);
            response.put("RightOperand", rightOperand);
        }

        entRes = ResponseEntity.status(HttpStatus.OK).body(Collections.unmodifiableMap(response));
        @SuppressWarnings("unchecked")
        final ResponseEntity<Map<String, String>> resEnt = (ResponseEntity<Map<String, String>>) entRes;

        System.out.println("/api/cal/post Finished");
        return resEnt;
    }
}