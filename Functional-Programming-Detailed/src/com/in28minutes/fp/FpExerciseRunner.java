package com.in28minutes.fp;

import java.util.List;
import java.util.stream.IntStream;

public class FpExerciseRunner {
public static void main(String[] args) {
	
	//Print squares of first 10 numbers
	IntStream.range(1, 11)
	.map(n->n*n)
	.forEach(n->System.out.print(n+" "));
	
	
	
	
	//List.of("Apple","Ant","Bat").stream()
	//Map all of these to lowercase and print them
	List<String>fruits= List.of("Apple","Ant","Bat");
	System.out.println("\nLowercase");
	fruits.stream().map(str->str.toLowerCase()).forEach(n->System.out.print(n+" "));
	
	//Length of each string
	System.out.println("\nLength of each element");
	fruits.stream().map(str->str+" "+str.length()).forEach(n->System.out.println(n));
	
		
	
	
}
}
