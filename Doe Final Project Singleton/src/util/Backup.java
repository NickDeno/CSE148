package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.PersonBag;

public class Backup {
	
	public static void backupPersonBag() {
		try {
			FileOutputStream fos = new FileOutputStream("backupFolder/PersonBag.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(PersonBag.getPersonBag(1000));
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}