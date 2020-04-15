package com.reactiveworks.practice.methodreference;

public class MethodReferenceExample {
	
	public static void m() {
		for(int index=0;index<10;index++) {
			System.out.println("child thread");
		}
	}

	public static void main(String[] args) {
		
		Runnable r= MethodReferenceExample::m;
		Thread threadObj=new Thread(r);
		threadObj.start();
		
		for(int index=0;index<10;index++) {
			System.out.println("main thread");
		}

	}

}
