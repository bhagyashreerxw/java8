package com.reactiveworks.practice.streams.parallelstreams;

import java.util.function.Function;
import java.util.stream.Stream;

class ParallelStreams {

	public static long sequentialSum(long n) {
		return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);

	}
	
	public static long iterativeSum(long n) {
		long result = 0;
		for (long i = 1L; i <= n; i++) {
		result += i;
		}
		return result;
		}
	
	public static long parallelSum(long n) {
		return Stream.iterate(1L, i -> i + 1).parallel().limit(n).reduce(0L, Long::sum);

	}

}

public class Performance {

	public static long measureSumPerf(Function<Long, Long> add, long n) {
		long fastest = Long.MAX_VALUE;
		for (int index = 0; index < 10; index++) {
			long start = System.nanoTime();
			add.apply(n);
			long duration = (System.nanoTime() - start) / 1000000;
			if (duration < fastest)
				fastest = duration;
		}
		return fastest;
	}

	public static void main(String[] args) {

		System.out.println(
				"Sequential sum done in: " + measureSumPerf(ParallelStreams::sequentialSum, 10_000_000) + " msecs");

		System.out.println("Iterative sum done in: " +
				measureSumPerf(ParallelStreams::iterativeSum, 10_000_000) + " msecs");
		
		System.out.println("Parallel sum done in: " +
				measureSumPerf(ParallelStreams::parallelSum, 10_000_000) + " msecs" );
		
	}

}
