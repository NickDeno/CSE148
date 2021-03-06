package p3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BackupAndRestore {
	
	public static void backupFiveBooksArrayList() {
		ArrayList<String> bookList = new ArrayList<>();
		File titles = new File("bookData/textbook_titles.txt");
		try {
			Scanner sc = new Scanner(titles);
			for(int i = 0; i < 4; i++ ) {
				bookList.add(sc.nextLine());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			FileOutputStream fos = new FileOutputStream("bookData/fiveBooksArrayList.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(bookList);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> restoreTwoBooksList(){
		try {
			FileInputStream fis = new FileInputStream("bookData/fiveBooksArrayList.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<String> bookList = (ArrayList<String>) ois.readObject();
			ArrayList<String> twoBookArrayList = new ArrayList<>();
			
			twoBookArrayList.add(0, bookList.get(0));
			twoBookArrayList.add(1, bookList.get(1));
			return twoBookArrayList;
		} catch (IOException  | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
