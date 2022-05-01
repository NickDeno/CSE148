package p2_binary_io;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoWriteBinaryFile {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("dataFolder/data.dat");
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeDouble(15.5);
			dos.writeInt(25);
			dos.writeUTF("Hello");
			dos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
