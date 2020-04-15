package com.reactiveworks.practice.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamsFromFilesExample {

	public static void main(String[] args) {
		long uniqueWords;
		Path filePath = Paths
				.get("C:\\Users\\reactiveworks13\\eclipse-workspace\\java8practice\\src\\main\\resources\\test.txt");
		
		System.out.println(filePath);
		try (Stream<String> lines = Files.lines(filePath)) {
			
			uniqueWords = lines.flatMap(l -> Arrays.stream(l.split(""))).distinct().count();
			System.out.println("uniqueWords: "+uniqueWords);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}