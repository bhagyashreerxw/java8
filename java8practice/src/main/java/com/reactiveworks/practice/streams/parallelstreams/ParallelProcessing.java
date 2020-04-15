package com.reactiveworks.practice.streams.parallelstreams;

import java.util.Arrays;
import java.util.List;

class Student{
	private String name;
	private int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}


public class ParallelProcessing {

	public static void main(String[] args) {
		
		List<Student> studentList =Arrays.asList(new Student("a",20),
													new Student("b",23),
													new Student("v",25),
													new Student("f",28),
													new Student("d",30));
		
	}

}
