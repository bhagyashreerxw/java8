package com.reactiveworks.practice.functionalinterface;

@FunctionalInterface
interface example{
	public void m1();
	//public void m2(); //more than one method is not allowed
}

interface exp{
	public void m();
	default public void m2() { //default method
		
	}
}

public class FunctionalInterfaceExample {
   public static void main(String args[]){
	   
   }
}
