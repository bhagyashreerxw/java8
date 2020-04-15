package com.reactiveworks.practice.streams.collect;

import java.util.ArrayList;

public class CountingExample {

	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("assd");
		list.add("kl;pf");
		list.add("rtyu");
		list.add("bghj");
		list.add("vfgh");
		list.add("mlkoik");
		long count=list.stream().count();
		System.out.println(count);

	}

}
