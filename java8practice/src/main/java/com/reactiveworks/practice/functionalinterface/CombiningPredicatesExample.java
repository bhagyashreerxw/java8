package com.reactiveworks.practice.functionalinterface;

import java.util.ArrayList;
import java.util.function.Predicate;

class Student {
	int rollNo;
	String name;
	int marks;

	public Student(int rollNo, String name, int marks) {
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", marks=" + marks + "]";
	}

}

public class CombiningPredicatesExample {

	public static void main(String[] args) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(1, "jkl", 90));
		studentList.add(new Student(10, "bnm", 10));
		studentList.add(new Student(6, "uioo[p", 30));
		studentList.add(new Student(11, "asf", 50));
		studentList.add(new Student(14, "hjk", 35));
		studentList.add(new Student(8, "hli", 40));
		Predicate<Student> p1 = student -> student.marks >= 35;
		Predicate<Student> p2 = student -> student.rollNo > 10;

		for (Student obj : studentList) {
			if ((p1.and(p2)).negate().test(obj)) {

				System.out.println(obj);
			}
			
			if ((p1.and(p2)).test(obj)) {
				System.out.print("satisfies condition: ");
				System.out.println(obj);
			}
		}

	}

}
