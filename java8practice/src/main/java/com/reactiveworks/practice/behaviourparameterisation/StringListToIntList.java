package com.reactiveworks.practice.behaviourparameterisation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StringListToIntList {

	public static <S,I> List<I> map(List<S> strList, Function<S, I> func) {
		List<I> intList = new ArrayList<I>();
		for (int index = 0; index < strList.size(); index++) {
			intList.add(func.apply(strList.get(index)));
		}

		return intList;
	}

	public static void main(String[] args) {
        List<String> strList=new ArrayList<String>();
        strList.add("e");
        strList.add("es");
        strList.add("edf");
        strList.add("eghj");
		Function<String, Integer> funcInterface = list -> list.length();
		List<Integer> intList=map(strList,funcInterface);
		System.out.println(strList);
		System.out.println(intList);
	}

}
