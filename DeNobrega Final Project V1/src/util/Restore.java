package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import model.Person;
import model.PersonBag;
import model.TextbookBag;

public class Restore {
	
	public static PersonBag restorePersonBag() {
		try {
			FileInputStream fis = new FileInputStream("backupFolder/Persons.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			PersonBag personBag = (PersonBag) ois.readObject();
			Person.setIdCount(personBag.getnElems());
			ois.close();
			return personBag;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static TextbookBag restoreTextbookBag() {
		try {
			FileInputStream fis = new FileInputStream("backupFolder/Textbooks.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			TextbookBag textbookBag = (TextbookBag) ois.readObject();
			ois.close();
			return textbookBag;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
