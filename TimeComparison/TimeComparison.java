/*****************************************************
Tester for Fibonacci functions, it's going to measure
the time between each execution

Code by: Hernán Guillermo Dulcey Morán
October 2019
*****************************************************/
package TimeComparison;

import FibonacciProject.*;
import java.util.concurrent.TimeUnit;

public class TimeComparison {
	public static void main(String[] args) {
		int value = Integer.parseInt(args[0]);

		long durationRecursion = timeRecursion(value);
		long durationLoop = timeLoop(value);

		System.out.printf("It took Recursion %d nanoseconds to find the %d value of the secuence%n", durationRecursion, value);
		System.out.printf("It took Loop %d nanoseconds to find the %d value of the secuence%n", durationLoop, value);
	}

	/**********************************************************************
	To calculate the time, is needed two clock measurements: the start and 
	end time. The difference in both is the time it took the function to
	finish the computation. Expressed in Nanoseconds
	**********************************************************************/

	static long timeRecursion(int value){
		Long startTime = System.nanoTime();

		long secuenceValue = Fibonacci.fibonacci(value);

		Long endTime = System.nanoTime();

		long duration = endTime - startTime;

		return duration;
	}

	static long timeLoop(int value){
		Long startTime = System.nanoTime();

		long secuenceValue = FibonacciLoop.fibonacci(value);

		Long endTime = System.nanoTime();

		long duration = endTime - startTime;

		return duration;
	}
}