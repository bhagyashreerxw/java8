package com.reactiveworks.practice.behaviourparameterisation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

interface BufferedReaderProcessor{
	public String process(BufferedReader buffReader) throws IOException;
}

public class Test {
	
	public static String processFile(BufferedReaderProcessor p) throws IOException {
		
		File file = new File(Test.class.getClassLoader().getResource("test.txt").getFile());
		
		try(BufferedReader buffReader=new BufferedReader(new FileReader(file))){
			
		  return p.process(buffReader);
		   
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReaderProcessor processor=(buffReader) -> buffReader.readLine()+" "+buffReader.readLine();
		
		System.out.println(processFile(processor));
	}

}
