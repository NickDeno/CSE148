package p3_checked_exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DemoCheckedExceptions {
	// A compiler is a Java program that turns source code into machine code
	// Checked (by compiler) exception. Must be handled!
	public static void main(String[] args) {
		File file = new File("Data.txt");
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} 
		System.out.println("The end");
	}

}
