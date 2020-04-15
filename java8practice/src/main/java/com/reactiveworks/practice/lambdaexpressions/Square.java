package com.reactiveworks.practice.lambdaexpressions;

interface ISquare{
	public int squareIt(int n);
}

public class Square {

	public static void main(String[] args) {
		int m=9;
		ISquare square=n->n*n;
		System.out.println("square of "+m+" is: "+square.squareIt(m));	
	}

}
