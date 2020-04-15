package com.reactiveworks.practice.functionalinterface;

import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		Predicate<String> p = (str) -> str.length() > 5;
		System.out.println("string length is greater than 5? " + p.test("fghj"));
		System.out.println("string length is greater than 5? " + p.test("fghjkk"));
	}

}
