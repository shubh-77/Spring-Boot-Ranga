package com.in28minutes.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;



class StringLengthComparator implements Comparator<String> {
	

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o2.length(), o1.length());
	}
}
public class QueueRunner {
public static void main(String[] args) {
	Queue<String> q = new PriorityQueue<>(new StringLengthComparator());
	
	q.addAll(List.of("Zebra","Monkey","Cat"));

	

	System.out.println(q);
//	System.out.println(q.poll());
//	System.out.println(q.poll());
//	System.out.println(q.poll());
//	System.out.println(q.poll());

	
}
}
