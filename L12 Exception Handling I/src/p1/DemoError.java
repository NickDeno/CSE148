package p1;

public class DemoError {

	public static void main(String[] args) {
		int n = 0;
		greetings(n);
		
	}

	private static void greetings(int n) { // recursion
		System.out.println("Hi " + n);
		try {
			Thread.sleep(1);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		greetings(++n);
	}

}
