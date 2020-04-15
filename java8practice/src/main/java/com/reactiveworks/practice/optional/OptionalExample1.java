package com.reactiveworks.practice.optional;

import java.util.Optional;

class Person {
	private Optional<Car> car = Optional.empty();

	public Optional<Car> getCar() {
		return car;
	}
}

class Car {
	private Optional<Insurance> insurance;

	public Optional<Insurance> getInsurance() {
		return insurance;
	}
}

class Insurance {
	private String name = "asd";

	public String getName() {
		return name;
	}
}

public class OptionalExample1 {

	public static void main(String[] args) {
//		String str = "sfggg";
//		Optional<String> optionalString  ;
//		Optional<String> optionalModifiedString = optionalString.map(s -> s + " modified").map(s -> s);
//		System.out.println("optionalModifiedString " + optionalModifiedString);
//		System.out.println(optionalString.map(string -> string.length()).get());
//		System.out.println(optionalString.isPresent());

		Optional<String> optStr = Optional.empty(); // cannot use optional variable without initialization
		System.out.println(optStr);

		Person person = new Person();
		Optional<Car> optVarCar = person.getCar();
		System.out.println(optVarCar.isPresent());
	}

}