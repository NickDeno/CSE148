package p3_object_io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DemoWriteObjectIO {
	
	public static void main(String[] args) {
		Student s1 = new Student("A", 3.0);
		Student s2 = new Student("B", 2.5);
		
		try {
			FileOutputStream fos = new FileOutputStream("dataFolder/dataObject.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(s1);
			oos.writeObject(s2);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done writing!");
	}
}
