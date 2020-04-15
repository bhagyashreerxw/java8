package com.reactiveworks.practice.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Dish {
	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;

	public Dish(String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public int getCalories() {
		return calories;
	}

	public Type getType() {
		return type;
	}

	public String toString() {
		return name;
	}

	public enum Type {
		MEAT, FISH, OTHER
	}
}

public class CollectorsMethodsExample {

	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));
		// returns the sum of elements in the stream
		int intCalories = menu.stream().collect(Collectors.summingInt(t -> t.getCalories()));
		// returns count,max,min,average
		IntSummaryStatistics menuStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));

		int sum = menu.stream().collect(Collectors.reducing(0, t -> t.getCalories(), Integer::sum));

		// concatenating strings
		String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(","));

		String shortMenu1 = menu.stream().map(Dish::getName).collect(Collectors.reducing((s1, s2) -> s1 + s2)).get();

		System.out.println(menuStatistics);
		System.out.println(intCalories);
		System.out.println(shortMenu);
		System.out.println("sum of calories of dishes: " + sum);
		System.out.println("menu : " + shortMenu1);

		// grouping

		Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(Collectors.groupingBy(t -> t.getType()));
		System.out.println("dishes grouped by type " + dishesByType);

		Map<CaloricLevel, List<Dish>> groupByCalories = menu.stream().collect(Collectors.groupingBy(dish -> {
			if (dish.getCalories() < 300)
				return CaloricLevel.DIET;
			else if (dish.getCalories() > 300 && dish.getCalories() < 400)
				return CaloricLevel.NORMAL;
			else
				return CaloricLevel.FAT;
		}));
		System.out.println("groupByCalories: " + groupByCalories);
		System.out.println();
		Map<Dish.Type, Long> noOfDishesByType = menu.stream()
				.collect(Collectors.groupingBy(t -> t.getType(), Collectors.counting()));
		System.out.println("noOfDishesByType: " + noOfDishesByType);

		// partitioning
		Map<Boolean, List<Dish>> partitionedMenu = menu.stream()
				.collect(Collectors.partitioningBy(dish -> dish.isVegetarian()));
		System.out.println(partitionedMenu);
		List<Dish> veg = partitionedMenu.get(true);
		System.out.println("veg list: " + veg);
		System.out.println();
		// prime or not
		List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 9, 11);
//		Map<Boolean, List<Integer>> partition = numList.stream().collect(Collectors.partitioningBy(n -> {
//
//			if (n < 2)
//				return false;
//			
//			for (int i = 2; i < n / 2; i++) {
//				if (n % i == 0)
//					return false;
//			}
//			
//			return true;
//
//		}));

	}

}

enum CaloricLevel {
	DIET, NORMAL, FAT
}
