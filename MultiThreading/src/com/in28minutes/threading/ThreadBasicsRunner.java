package com.in28minutes.threading;
//extends Thread
//implements Runnable


class Task1 extends Thread{
	
	public void run() {
		System.out.print("\nTask 1 started");
		for(int i=101;i<=199;i++) {
			System.out.print(i+" ");
		}
		System.out.print("\nTask 1 done");
		
	}
}

class Task2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.print("\nTask 2 Kicked off");
		for(int i=201;i<=299;i++) {
			System.out.print(i+" ");
		}
		System.out.print("\nTask 2 done");
		
		
	}
	
}




public class ThreadBasicsRunner {
	public static void main(String[] args) throws InterruptedException {
		
		
		//Task1 - using thread class
		Task1 task1 = new Task1();
		task1.setPriority(1);
		task1.start();
		
		//Task2 - using runnable interface
		Task2 task2 = new Task2();
		Thread task2Thread = new Thread(task2);
		task2Thread.start();
		task2Thread.setPriority(10);
		System.out.println();
		
		
		//wait for task1 to complete
		task1.join();
		task2Thread.join();
		
		
		//Task3
		System.out.print("\nTask 3 Kicked off");
		for(int i=301;i<=399;i++) {
			System.out.print(i+" ");
		}
		System.out.print("\nTask 3 done");

		System.out.println("\nMain done");
	}
	
	
}
