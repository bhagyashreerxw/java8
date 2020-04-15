package com.reactiveworks.practice.streams.parallelstreams;

import java.util.stream.*;

public class SumPfInts {

	public static void main(String[] args) {
		
		//sequential stream
		int sum1=Stream.iterate(1, num->num+1)
				      .limit(10)
				      .reduce(0, Integer::sum);
		
		//parallel stream
		int sum2=Stream.iterate(1, num->num+1)
				        .limit(10)
				        .parallel()
				        .reduce(0, Integer::sum);
		
		System.out.println("sum1: "+sum1);
		System.out.println("sum2: "+sum2);
		System.out.println(Runtime.getRuntime().availableProcessors());
		

	}

}
