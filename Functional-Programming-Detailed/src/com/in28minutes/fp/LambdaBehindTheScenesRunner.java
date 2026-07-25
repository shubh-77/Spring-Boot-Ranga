package com.in28minutes.fp;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;



class EvenPredicate implements Predicate<Integer>{

	@Override
	public boolean test(Integer number) {
		// TODO Auto-generated method stub
		return number%2==0;
	}
	
}

class SysoutConsumer implements Consumer<Integer>{

	@Override
	public void accept(Integer number) {
		// TODO Auto-generated method stub
		
		System.out.println(number);
	}
	
}

class MapperClass implements Function<Integer, Integer>{

	@Override
	public Integer apply(Integer number) {
		// TODO Auto-generated method stub
		return number*number;
	}
	
}

public class LambdaBehindTheScenesRunner {

	
	
	
	public static void main(String[] args) {
	
	
	
	Predicate<? super Integer> evenPredicate = createEvenPredicate();
	Predicate<? super Integer> oddPredicate = n->n%2==1;

	
	List.of(23,43,34,45,36,48)
	.stream()
	.filter(evenPredicate)
	.map(n->n*n)
	.forEach(n->System.out.println(n));
	
	
	List.of(23,43,34,45,36,48)
	.stream()
	.filter(new EvenPredicate())
	.map(new MapperClass())
	.forEach(new SysoutConsumer());
	
	
}

	private static Predicate<? super Integer> createEvenPredicate() {
		return n->n%2==0;
	}

}
