package p2_unchecked_exceptions;

public class DemoUnchecked {

	public static void main(String[] args)  {
		// Also known as Runtime Exception.
		int[] arr = {10, 20, 30, 40, 50};
		System.out.println(arr[0]);
		System.out.println(arr[4]);
		try {
			System.out.println(arr[5]);
		} catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println(e.getMessage());
		}
		System.out.println("Finished");
	}

}
