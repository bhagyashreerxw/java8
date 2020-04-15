package com.reactiveworks.practice.lambdaexpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionExample {

	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		List<String> list=Arrays.asList("adfgg","fhhk");
		Stream<String> stream = list.stream();
		System.out.println(Runtime.getRuntime().availableProcessors());
	    Map<String, Integer> collect = stream.collect(Collectors.toMap(s->s, s->s.length()));
	    List<String> collect2 = stream.collect(Collectors.toList());
		arrList.add(45);
		arrList.add(10);
		arrList.add(60);
		arrList.add(59);
		System.out.println(arrList);
		Comparator<Integer> c = (o1, o2) -> (o1 < o2) ? -1 : (o1 > o2) ? 1 : 0;
		Collections.sort(arrList, c);
		System.out.println(arrList);
	}

}
