package com.in28minutes.exceptionhandling;

import java.util.Scanner;

public class FinallyRunner {
public static void main(String[] args) {
	Scanner scanner=null;
	try {
	scanner = new Scanner(System.in);
	
	int[] numbers = {12,3,4,5};
	
	int number= numbers[5];

	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		System.out.println("Before scanner class");
		if(scanner!=null) {
			/*if some problem occurs at 
			  line 9 i.e 
			  when initialising cuz of which if statement is used
			*/
			scanner.close();
		}
		System.out.println("Scanner closed");
	}
	
	
	
	
	
}
}
