package com.in28minutes.fp;

import java.util.List;

public class MethodRefrencesRunner {
	
	private static void print(Integer n) {
		System.out.println(n+" ");
		
	}
	
	private static boolean isEven(Integer n) {
		return n%2==0;
	}
public static void main(String[] args) {
	
	
	List<String> list=List.of("Ant","Bat","Cat","Dog","Elephant");
	
	System.out.println("\nLambda Functions:");
	list.stream()
	.map(n->n.length())
	.forEach(n->System.out.print(n+" "));
	
	System.out.println("\nMethod Refrence:");
	list.stream()
	.map(String::length) //using instance method of class
	.forEach(MethodRefrencesRunner::print); //using static method of class
	
	
	
	
	
	Integer max=List.of(56,23,45,67,34,88)
	.stream()
	.filter(MethodRefrencesRunner::isEven)
	.max(Integer::compare).orElse(0);
	System.out.println("Max number: "+max);
}
}
