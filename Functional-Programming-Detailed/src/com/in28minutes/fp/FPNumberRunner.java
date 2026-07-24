package com.in28minutes.fp;

import java.util.List;

public class FPNumberRunner {
public static void main(String[] args) {
	List<Integer> numbers = List.of(4,6,8,13,3,15);
	
	
	System.out.println("Basic sum:");
	System.out.println(basicSum(numbers));
	System.out.println("FP sum:");
	System.out.println(fpSum(numbers));

	System.out.println("FP Odd sum:");
	System.out.println(fpOddSum(numbers));

	
}
	private static int basicSum(List<Integer> list) {
		int sum=0;
		for(int i: list) {
			sum+=i;
		}
		return sum;
		
	}
	
	private static int fpSum(List<Integer> list) {
		return list.stream().
				reduce(0,(n1,n2)->n1+n2);
		//return list.stream().reduce(Integer::sum).orElse(0);

	}
	
	//Mutation
	private static int fpOddSum(List<Integer> list) {
		return list.stream()
		.filter(n->n%2==1)
		.reduce(0,(n1,n2)->n1+n2);
	}
	
	
}
