/************************************************
The simplest way to solve the fibonacci secuence

Code by: Hernán Guillermo Dulcey Morán
September 2019
*************************************************/
package FibonacciProject;

public class Fibonacci {
	public static void main(String[] args) {
		int value = Integer.parseInt(args[0]);
		System.out.println("The "+value+" value of the Fibonacci secuence: "+fibonacci(value));
	}

	public static long fibonacci(int x){
		/***************************************************************
		There is some debate of rather the function begins with 0 or 1.
		For this example we take that 0 is the first number.
		***************************************************************/
		if(x == 1){
			return 0;
		}
		if(x == 2){
			return 1;
		}
		return fibonacci(x-1) + fibonacci(x-2);
	}
}