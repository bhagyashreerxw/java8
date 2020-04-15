package com.reactiveworks.practice.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {
	private String name;
	private double percentage;

	public Student(String name, double percentage) {
		this.name = name;
		this.percentage = percentage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", percentage=" + percentage + "]";
	}
	
	

}

public class ToMapExample {

	public static void main(String[] args) {

		List<Student> studentList = Arrays.asList(new Student("a", 89.7), new Student("b", 80), new Student("c", 50),
				new Student("d", 45), new Student("e", 40));
		Map<String, Double> studentData = studentList.stream()
				.collect(Collectors.toMap(Student::getName, Student::getPercentage));
		System.out.println("studentData: " + studentData);

		// toCollection()
		ArrayList<Student> studentArrList = studentList.stream().collect(Collectors.toCollection(ArrayList::new));
		System.out.println("studentArrList: " + studentArrList);

		LinkedList<Student> studentLinkedList = studentList.stream().collect(Collectors.toCollection(LinkedList::new));
		System.out.println("studentLinkedList: "+studentLinkedList);

	}

}
