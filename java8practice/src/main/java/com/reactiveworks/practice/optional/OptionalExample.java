package com.reactiveworks.practice.optional;

import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {

		String str = "asdf";
        String str1=null;
		Optional<String> optionalString = Optional.ofNullable(str);
		Optional<String> optionalString2 = Optional.of(str1); //throws NPE

		System.out.println(optionalString.orElse("no value").charAt(0));
		//System.out.println(optionalString2.orElseThrow());
		System.out.println(optionalString2.orElseGet(()->"str1 is null"));
	}

}
