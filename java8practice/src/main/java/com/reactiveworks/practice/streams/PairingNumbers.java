package com.reactiveworks.practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PairingNumbers {

	public static void main(String[] args) {
		List<Integer> numList1=Arrays.asList(1,2,3);
		List<Integer> numList2=Arrays.asList(4,5);
		List<Integer[]> list=numList1.stream().flatMap(i-> numList2.stream()
				                                                    .map(j->new Integer[] {i,j}))
				                                                    .collect(Collectors.toList());
        System.out.println(list);
	}

}
