package com.reactiveworks.practice.spliterator;

import java.util.List;
import java.util.Spliterator;
import java.util.Arrays;

public class SpliteratorExample {

	public static void main(String[] args) {

		List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		Spliterator<Integer> spliterator1 = numList.stream().spliterator();

		System.out.println(spliterator1.estimateSize());

		Spliterator<Integer> spliterator2 = spliterator1.trySplit();

		System.out.println("elements processed by spliterator1 ");
		spliterator1.forEachRemaining(t -> System.out.println(t));

		if (spliterator2 != null) {
			System.out.println("elements processed by spliterator2 ");
			spliterator2.forEachRemaining(t -> System.out.println(t));
		}

	}

}
