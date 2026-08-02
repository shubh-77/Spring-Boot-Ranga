package com.in28minutes.exceptionhandling;
public class ExceptionHandlingRunner2 {
	public static void main(String[] args) {
		method1();
		System.out.println("main ended");
	}

	private static void method1() {
		method2();
		System.out.println("method1 ended");
	}

	private static void method2() {
		try {
			//String str=null;
			//str.length();
			int[] i = {1,2};
			int number= i[3];
			System.out.println("method2 ended");
		}
		catch(NullPointerException e) {
			System.out.println("Matched NullPointerException");
			e.printStackTrace();
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Matched ArrayIndexOutOfBoundsException");
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("Matched Exception");
			e.printStackTrace();
		}

	}
}
