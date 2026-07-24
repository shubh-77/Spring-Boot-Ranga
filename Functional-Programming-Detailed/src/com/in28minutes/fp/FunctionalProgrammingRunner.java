package com.in28minutes.fp;

import java.util.List;

public class FunctionalProgrammingRunner {
	
	
	public static void main(String[] args) {
		
 		List<String> list = List.of("Apple","Bat","Cat","Dog");
		
// 		System.out.println("Print with BASIC");
// 		printBasic(list);
// 		System.out.println("Print with FP");
// 		printWithFP(list);
 		
 		System.out.println("Basic filter");
 		printBasicWithFiltering(list);
 		
 		System.out.println("FP filter");
 		printFPWithFiltering(list);
 		
 		
 		
		
		
	}

	private static void printBasic(List<String> list) {
		for(String str: list) {
 			System.out.println(str);
 		}
	}
	
	
	private static void printFPWithFiltering(List<String> list) {
		list.stream().filter(str->str.endsWith("at"))
		.forEach(str->System.out.print(str+" "));
	}
	
	private static void printBasicWithFiltering(List<String> list) {
		for(String str: list) {
 			if(str.endsWith("at")) {
 				System.out.println(str);
 			}
 		}
	}
	
	private static void printWithFP(List<String> list) {
		list
		.stream()
		.forEach(str->System.out.print(str+" "));
	}
	
	
}
