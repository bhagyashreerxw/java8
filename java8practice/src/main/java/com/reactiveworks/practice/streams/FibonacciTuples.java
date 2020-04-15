package com.reactiveworks.practice.streams;

import java.util.stream.Stream;

public class FibonacciTuples {

	public static void main(String[] args) {
		
		Stream.iterate(new int[] {0,1},(f->new int[] {f[1],f[0]+f[1]}))
		      .limit(5).forEach(t->System.out.println("("+t[0]+","+t[1]+")"));

	}

}
