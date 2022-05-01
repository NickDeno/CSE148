package p1_text_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DemoReadTextFile {

	public static void main(String[] args) {
		File file = new File("dataFolder/data.txt");
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
