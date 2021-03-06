/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.bridgelabz.mathoperations;

@FunctionalInterface
interface IMathFunction {
	int calculate(int a, int b);
	static void printResult(String operation, int a, int b, IMathFunction function) {
		System.out.println(operation+" is "+function.calculate(a, b));
	}
}

public class MathOperationsApp {
	public static void main(String[] args) {
		IMathFunction add = (a,b) -> a+b;
		IMathFunction subtract = (a,b) -> a-b;
		IMathFunction divide = (a,b) -> a/b;

		IMathFunction.printResult("Addition", 3,4, add);
		IMathFunction.printResult("Subtraction", 6, 5, subtract);
		IMathFunction.printResult("Divide",18,3,divide);
	}
}
