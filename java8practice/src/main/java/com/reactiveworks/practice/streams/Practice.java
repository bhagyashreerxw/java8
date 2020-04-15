package com.reactiveworks.practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Trader {
	private final String name;
	private final String city;

	public Trader(String n, String c) {
		this.name = n;
		this.city = c;
	}

	public String getName() {
		return this.name;
	}

	public String getCity() {
		return this.city;
	}

	public String toString() {
		return "Trader:" + this.name + " in " + this.city;
	}
}

class Transaction {
	private final Trader trader;
	private final int year;
	private final int value;

	public Transaction(Trader trader, int year, int value) {
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	public Trader getTrader() {
		return this.trader;
	}

	public int getYear() {
		return this.year;
	}

	public int getValue() {
		return this.value;
	}

	public String toString() {
		return "{" + this.trader + ", " + "year: " + this.year + ", " + "value:" + this.value + "}";
	}
}

public class Practice {

	public static void main(String[] args) {

		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		List<Transaction> transactions = Arrays.asList(
		new Transaction(brian, 2011, 300),
		new Transaction(raoul, 2012, 1000),
		new Transaction(raoul, 2011, 400),
		new Transaction(mario, 2012, 710),
		new Transaction(mario, 2012, 700),
		new Transaction(alan, 2012, 950)
		);
		
	   List<Transaction> transactionList=transactions.stream().filter(t->t.getYear()==2011)
			             .sorted((t1,t2)->((Integer)t1.getValue())
			            .compareTo((Integer)t2.getValue()))
			             .collect(Collectors.toList());
	   System.out.println(transactionList);
	   
	   List<String> citiesList=transactions.stream().map(t->t.getTrader()
			                                         .getCity()).distinct()
			                                         .collect(Collectors.toList());
	   System.out.println(citiesList);
	}

}
