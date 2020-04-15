package com.reactiveworks.practice.streams;
import java.util.Arrays;
import java.util.List;
public class ReduceExample {

	public static void main(String[] args) {
		List<Integer> intList=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		//int sum=intList.stream().reduce(0, (n1,n2)->(n1+n2));
		int sum=intList.stream().reduce(0, Integer::sum);
		int product=intList.stream().reduce(1, (n1,n2)->(n1*n2));
		System.out.println("sum: "+sum);
		System.out.println("product: "+product);

	}

}
