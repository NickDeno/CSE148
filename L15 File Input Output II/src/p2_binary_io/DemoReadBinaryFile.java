package p2_binary_io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DemoReadBinaryFile {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("dataFolder/data.txt");
			DataInputStream dis = new DataInputStream(fis);
			double d = dis.readDouble();
			int i = dis.readInt();
			String str = dis.readUTF();
			dis.close();
			System.out.println(d + " " + i + str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
			
		}
		
	}

}
