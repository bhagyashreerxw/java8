package com.reactiveworks.practice.streams.parallelstreams;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.function.Function;
import java.util.stream.LongStream;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {

	private static final long serialVersionUID = 1L;
	private long[] numbers;
	private int start;
	private int end;

	public static final int THRESHOLD = 10000;

	public ForkJoinSumCalculator(long[] numbers, int start, int end) {
		super();
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}

	public ForkJoinSumCalculator(long[] numbers) {
		this(numbers, 0, numbers.length);

	}

	@Override
	protected Long compute() {

		int length = end - start;
		if (length < THRESHOLD) {
			return computeSequentially(numbers, start, end);
		}

		ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + end / 2);
		leftTask.fork();

		ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + end / 2, end);
		long rightTaskResult = rightTask.compute();
		long leftTaskResult = leftTask.join();
		long result = rightTaskResult + leftTaskResult;
		return result;
	}

	public long computeSequentially(long numbers[], int start, int end) {
		long sum = 0;
		for (int i = start; i < end; i++) {
			sum += numbers[i];
		}
		return sum;
	}

	public static long forkJoinSum(long n) {
		long[] numbers = LongStream.rangeClosed(1, n).toArray();
		ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
		return new ForkJoinPool().invoke(task);
	}

	public static long measureSumPerf(Function<Long, Long> add, long n) {
		long fastest = Long.MAX_VALUE;
		for (int index = 0; index < 5; index++) {
			long start = System.nanoTime();
			add.apply(n);
			long duration = (System.nanoTime() - start) / 1000000;
			if (duration < fastest)
				fastest = duration;
		}
		return fastest;
	}

	public static void main(String args[]) {
		System.out.println(forkJoinSum(10));
		System.out.println(	"ForkJoin sum done in: " +
		measureSumPerf(ForkJoinSumCalculator::forkJoinSum, 10_000_000) + " msecs");
	}
}