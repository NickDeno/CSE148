package p1_arrays;

import java.util.Arrays;

public class DemoArrays {
	
	public static void main(String[] args) {
		int n = 10;
		int[] arr = {1, 2, 3, 4};
		
		display(n, arr);
		System.out.println("\nIn main method, n: " + n);
		System.out.println(Arrays.toString(arr));
	}

	//In java, any data passing (parameters and arguments) is by vaule!!!!!!
	private static void display(int n, int[] rra) {
		rra[0] = 100;
		System.out.println("In the display method, n: " + n);
		System.out.println(Arrays.toString(rra));
	}
}
