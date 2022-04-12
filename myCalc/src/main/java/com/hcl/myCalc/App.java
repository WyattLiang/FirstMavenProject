package com.hcl.myCalc;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
        //System.out.println( "Hello World! This my calculator" );
        printUI();
        
        Scanner sc = new Scanner(System.in);
        while(true) {
        	System.out.print("---Please enter the first number: ");
            double num1 = sc.nextDouble();
            System.out.print("---Please enter the second number: ");
            double num2 = sc.nextDouble();
            System.out.print("---Please enter the operation: ");
            char op = sc.next().charAt(0);
            
            Calculator myCalc = new Calculator(num1,num2,op);
            
            if(myCalc.calculate()) {
            	System.out.println("The result is: "+myCalc.getResult());
            }
        	System.out.print("Do you have another operation? [Y/N] ");
        	char yORn = sc.next().charAt(0);
        	if(Character.toUpperCase(yORn) == 'N') {
        		System.out.println("See you around!");
        		break;
        	} 
        }
        
        
        
        
        
    }
    
    public static void printUI() {
    	System.out.println("---Thanks for using Wyatt's calculator");
    	System.out.print("---You can do these operations: ");
    	System.out.println("+, -, *, /, ^, %");
    }
    
    
}

class Calculator {
	private double num1;
	private double num2;
	private char op;
	private double result;
	
	Calculator(double num1, double num2, char op) {
		this.num1 = num1;
		this.num2 = num2;
		this.op = op;
		
		
	}
	
	boolean calculate() {
		boolean validOp = true;
	
		switch (op) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			try {
				result = num1/(int)num2;
				if(Double.isInfinite(result)) {
					validOp = false;
					throw new ArithmeticException();
				}
					
			}
			catch(ArithmeticException e) {
				System.out.println("divider can not be 0");
			}
			break;
			
		case '^':
			result = Math.pow(num1,num2);
			break;
			
		case '%':
			result = num1 % num2;
			break;	
			
		default:
			System.out.println("No such operation, please try again");
			validOp = false;
			break;
		}
		return validOp;
	}
	
	double getResult() {
		return result;
	}
	

}




