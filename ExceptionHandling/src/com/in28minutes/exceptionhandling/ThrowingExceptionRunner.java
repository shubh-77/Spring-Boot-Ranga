package com.in28minutes.exceptionhandling;

//custom Exception
class CurrenciesDoNotMatchException extends Exception{
	
	
	public CurrenciesDoNotMatchException(String msg) {
		super(msg);
	}
}


class Amount{
	
	private String currency;
	private int amount;
	
	
	public Amount(String currency, int amount) {
		super();
		this.currency = currency;
		this.amount = amount;
	}
	
	
	public void add(Amount that) throws Exception{
		
		if(!this.currency.equals(that.currency)) {
			// throw new Exception("Currencies Don't match "+this.currency+" "+that.currency);
			throw new CurrenciesDoNotMatchException("Currencies Don't match "+this.currency+" "+that.currency);
		}
	
		this.amount=this.amount+that.amount;

	}
	public String toString() {
		return String.format("currency-%s , amount - %d", currency,amount);
		
	}
	
	
}




public class ThrowingExceptionRunner {
	public static void main(String[] args) throws Exception {
		
		Amount amt1= new Amount("USD",10);
		Amount amt2= new Amount("EUR",20);
		amt1.add(amt2);
		System.out.println(amt1);
		
		
		
	}
}
