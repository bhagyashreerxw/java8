package com.reactiveworks.practice.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MaxByExample {

	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,3);
		Optional<Integer> numbers=list.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
		if(numbers.isPresent()) {
			System.out.println(numbers.get());
		} else {
			System.out.println("no value");
		}

	}

}
