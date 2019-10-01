/************************************************
The loop way to solve the fibonacci secuence

Code by: Hernán Guillermo Dulcey Morán
September 2019
*************************************************/
package FibonacciProject;

public class FibonacciLoop {
	public static void main(String[] args) {
		int value = Integer.parseInt(args[0]);
		System.out.println("The "+value+" value of the Fibonacci secuence: "+fibonacci(value));
	}
	
	public static long fibonacci(int x){
		long[] n1n2 = new long[2];
		/*****************************************************************
		Again the number 0 is considered the first element in the secuence
		*****************************************************************/
		n1n2[0] = 0;
		n1n2[1] = 1;

		if(x == 1){
			return n1n2[0];
		}
		/******************************************************************************
		In this case, the base values are stored in an array of two elements.
		This elements are going to store the values we need to calculate the next value
		This way it doesn't need to use recursion to solve the secuence.
		******************************************************************************/
		for(int i = 2; i < x; i++){
			long newValue = n1n2[1] + n1n2[0];
			n1n2[0] = n1n2[1];
			n1n2[1] = newValue;
		}

		return n1n2[1];
	}
}