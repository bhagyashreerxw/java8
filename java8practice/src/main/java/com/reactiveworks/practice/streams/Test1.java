package com.reactiveworks.practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {

	public static void main(String[] args) {
         
		List<String> words=Arrays.asList("hello", "world" );
		//List<String> strList=words.stream().map(word->word.split(""))
		//.map(Arrays::stream).collect(Collectors.toList());   //produces Stream<Stream<Strings>>
		
		List<String> strList=words.stream().map(word->word.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(Collectors.toList()); 
        System.out.println(strList);
	}

}
