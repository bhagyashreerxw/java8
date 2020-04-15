package com.reactiveworks.practice.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SkipExample {

	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		List<String> l=list.stream().skip(2).collect(Collectors.toList());
		System.out.println(l);
		
	}

}
