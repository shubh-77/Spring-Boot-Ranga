package com.in28minutes.exceptionhandling;

public class CheckedExceptionRunner {
public static void main(String[] args) {
	
	try {
		someOtherMethod();
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	someOtherMethod2();
	
}


private static void someOtherMethod2() throws RuntimeException{
	
}
private static void someOtherMethod() throws InterruptedException {
	// TODO Auto-generated method stub
	
	Thread.sleep(2000);
}
}
