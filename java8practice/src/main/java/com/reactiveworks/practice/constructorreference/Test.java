package com.reactiveworks.practice.constructorreference;

class Sample{
	String value;
	public Sample() {
		value="asdfff";
		
		System.out.println("Sample class constructor execution");
	}
}

interface Interf {
	public Sample get();
}

public class Test {

	public static void main(String[] args) {
		
		Interf interf=Sample::new;
		Sample sampleObj1=interf.get();	
		Sample sampleObj2=interf.get();	
		System.out.println(sampleObj1.value);
		System.out.println(sampleObj2.value);

	}

}
