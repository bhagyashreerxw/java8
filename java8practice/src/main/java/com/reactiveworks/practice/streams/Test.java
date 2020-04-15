package com.reactiveworks.practice.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("assd");
		list.add("kl;pf");
		list.add("rtyu");
		list.add("bghj");
		list.add("vfgh");
		list.add("mlkoik");
		List<String> strList=list.stream().sorted((s1,s2)->s2.compareTo(s1)).collect(Collectors.toList());//sorting in descending order
		System.out.println(list);
		System.out.println(strList);
            
	}

}
