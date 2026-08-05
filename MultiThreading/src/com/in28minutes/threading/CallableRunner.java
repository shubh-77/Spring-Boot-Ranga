package com.in28minutes.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableTask implements Callable<String>{

	private String name;
	
	public CallableTask(String name) {
		this.name=name;
	}
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(1000);
		return "Hello "+name;
	}
	
}


public class CallableRunner {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
	
		
		ExecutorService executorService =Executors.newFixedThreadPool(1);
		
		Future<String> submit = executorService.submit(new CallableTask("in28minutes"));
		
		System.out.println("new CallableTask(\"in28minutes\") executed");
		String welcomeMessage = submit.get();	
		
		System.out.println(welcomeMessage);
		System.out.println("main completed");
		executorService.shutdown();
	
	}
}
