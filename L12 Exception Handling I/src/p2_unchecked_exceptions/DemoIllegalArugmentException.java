package p2_unchecked_exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DemoIllegalArugmentException {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age = 0;
		System.out.println("Please enter your age as integer: ");
		while(true) {
			try {
				age = sc.nextInt();
				break;
			}  catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("Hey the input is invalid!");
				System.out.println("Please enter a valid whole number");
			} catch(Exception e) {
				System.out.println("Hey the input is invalid! The exeptions is caught by the Exception catch clause");
				System.out.println("Please enter a valid whole number");
			} finally { // code in "finally" will always be executed
				System.out.println("Finally! It was always be executed");
			}
		}
		System.out.println("Your age is: " + age);
	
	}
}
