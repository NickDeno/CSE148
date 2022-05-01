package p1_text_io;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DemoWriteTextFile {

	public static void main(String[] args) {
		try {
			char[] arr = {'a', 'b', 'c'};
			FileWriter fw = new FileWriter("dataFolder/data.txt" , false);
			PrintWriter pw = new PrintWriter(fw);
			pw.printf("%10s%10.2f%10d%n", "John", 3.93943, 65);
			pw.printf("%10s%10.2f%10d%n", "Jane", 2.00943, 55);
			pw.println(66);
			for(char a: arr) {
				pw.print(a + " ");
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done writing!");
	}

}
