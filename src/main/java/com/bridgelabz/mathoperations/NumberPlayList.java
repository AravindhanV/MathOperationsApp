package com.bridgelabz.mathoperations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberPlayList {
	public static void main(String[] args) {
		List<Integer> numberList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			numberList.add(i);
		}

		// Proper class
		class MyConsumer implements Consumer<Integer> {
			public void accept(Integer number) {
				System.out.println("Proper class: " + number);
			}
		}
		MyConsumer consumer = new MyConsumer();
		numberList.forEach(consumer);

		// Anonymous class
		numberList.forEach(new Consumer<Integer>() {
			public void accept(Integer number) {
				System.out.println("Anonymous class: " + number);
			}
		});

		// Explicit Lambda Function
		Consumer<Integer> explicitConsumer = number -> {
			System.out.println("Explicit class: " + number);
		};
		numberList.forEach(explicitConsumer);

		// Implicit Lambda Function
		numberList.forEach(number -> {
			System.out.println("Implicit class: " + number);
		});

		Function<Integer, Double> function = Integer::doubleValue;
		numberList.forEach(number -> {
			System.out.println("Double Value: " + function.apply(number));
		});

		Predicate<Integer> predicate = n -> n > 0 && n % 2 == 0;
		numberList.forEach(number -> {
			System.out.println(number + " is even number: " + predicate.test(number));
		});

		numberList.stream().forEach(n -> {
			System.out.println("Stream in forEach: " + n);
		});

		List<Double> doubleList = numberList.stream().filter(predicate).map(function).collect(Collectors.toList());
		System.out.println("Double List: " + doubleList);

		Integer firstEven = numberList.stream().filter(predicate).findFirst().orElse(null);
		System.out.println("First Even: " + firstEven);

		Integer min = numberList.stream().filter(predicate).min((n1, n2) -> n1 - n2).orElse(null);
		System.out.println("Min Value: " + min);

		Integer max = numberList.parallelStream().filter(predicate).max((n1, n2) -> n1 - n2).orElse(null);
		System.out.println("Max Value: " + max);

		Integer sum = numberList.stream().reduce(0, (n1, n2) -> n1 + n2);
		System.out.println("Sum: "+sum);
		
		Integer average = (int) (sum/(numberList.stream().count()));
		System.out.println("Average: "+average);
		
		boolean allEven = numberList.parallelStream().allMatch(predicate);
		System.out.println("All Even: "+allEven);
		boolean oneEven = numberList.parallelStream().anyMatch(predicate);
		System.out.println("One Even: "+oneEven);
	}
}
