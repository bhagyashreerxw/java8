package com.reactiveworks.practice.lambdaexpressions;

@FunctionalInterface
interface Calculator{
	public abstract void add(int a,int b);
}
public class LambdaExpressionExample {

	public static void main(String[] args) {
		//Calculator calculator= (a,b)->System.out.println("sum: "+(a+b));
		Calculator calculator= (a,b)->{System.out.println("sum: "+(a+b));};
		calculator.add(1,2);
	}

}
