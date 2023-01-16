package com.example.demo.service;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class CalculatorService {
    private double leftOperand;
    private double rightOperand;
    private String operator;

    public double calculateResult() {

        double result = 0;
        switch(this.operator) {
            case "+":
                result = this.leftOperand + this.rightOperand;
                break;
            case "-":
                result = this.leftOperand - this.rightOperand;
                break;
            case "*":
                result = this.leftOperand * this.rightOperand;
                break;
            case "/":
                result = this.leftOperand / this.rightOperand;
                break;
            case "^":
                result = Math.pow(this.leftOperand,this.rightOperand);
                break;
            default:
                result = 0;
        }
        return result;
    }


    public double parsetring2Double4LeftNumber(String leftOperand) {
		double leftNumber;
		try {
			leftNumber = Double.parseDouble(leftOperand);
			System.out.println("Left Operand : " + leftNumber);
		} catch (NumberFormatException ex) {
			leftNumber = 0.0;
			System.out.println("Left Operand Exception");
		}
		return leftNumber;
	}

	public double parsetring2Double4rightNumber(String rightOperand) {
		double rightNumber;
		try {
			rightNumber = Double.parseDouble(rightOperand);
			System.out.println("Right Operand : " + rightOperand);
		} catch (NumberFormatException ex) {
			rightNumber = 0.0;
			System.out.println("Right Operand Exception");
		}
		return rightNumber;
	}
}

