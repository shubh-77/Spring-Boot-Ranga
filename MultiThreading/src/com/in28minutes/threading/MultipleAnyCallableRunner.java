package com.in28minutes.threading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleAnyCallableRunner {
	public static void main(String[] args) throws InterruptedException, ExecutionException {


		ExecutorService executorService =Executors.newFixedThreadPool(3);

		
		List<CallableTask> tasks = List.of(new CallableTask("in28minutes"),new CallableTask("Ranga"),new CallableTask("Shubham"));
		
		
        String result = executorService.invokeAny(tasks); //executes any tasks
		
		System.out.println(result);
	
		executorService.shutdown();
	}
}
