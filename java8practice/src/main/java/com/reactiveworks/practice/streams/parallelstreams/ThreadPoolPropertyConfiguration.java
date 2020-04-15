package com.reactiveworks.practice.streams.parallelstreams;

public class ThreadPoolPropertyConfiguration {

	public static void main(String[] args) {
		
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");

	}

}
