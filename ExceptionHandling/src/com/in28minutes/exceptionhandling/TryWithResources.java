package com.in28minutes.exceptionhandling;

import java.util.Scanner;

public class TryWithResources {
public static void main(String[] args) {
	try(Scanner scanner = new Scanner(System.in)){
	
	int[] numbers = {12,3,4,5};
	
	int number= numbers[5];

	}
	//implicitly calls Scanner.close
	
	
	
	
	
}
}
