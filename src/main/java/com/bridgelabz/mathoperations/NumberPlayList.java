package com.bridgelabz.mathoperations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class NumberPlayList {
	public static void main(String[] args) {
		List<Integer> numberList = new ArrayList<>();
		for(int i=0;i<5;i++) {
			numberList.add(i);
		}
		
		//Proper class
		class MyConsumer implements Consumer<Integer> {
			public void accept(Integer number) {
				System.out.println("Proper class: "+number);
			}
		}
		MyConsumer consumer = new MyConsumer();
		numberList.forEach(consumer);
		
		//Anonymous class
		numberList.forEach(new Consumer<Integer> () {
			public void accept(Integer number) {
				System.out.println("Anonymous class: "+number);
			}
		});
		
		//Explicit Lambda Function
		Consumer<Integer> explicitConsumer = number -> {
			System.out.println("Explicit class: "+number);
		};
		numberList.forEach(explicitConsumer);
		
		//Implicit Lambda Function
		numberList.forEach(number -> {
			System.out.println("Implicit class: "+number);
		});
		
		Function<Integer, Double> function = Integer::doubleValue;
		numberList.forEach(number -> {
			System.out.println("Double Value: "+function.apply(number));
		});
	}
}
