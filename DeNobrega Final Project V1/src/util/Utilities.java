package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import model.Instructor;
import model.Name;
import model.PersonBag;
import model.Student;
import model.Textbook;
import model.TextbookBag;

public class Utilities {
	private static Random rand = new Random();
	private static String firstNames = "rawData/names/firstNames.txt";
	private static String lastNames = "rawData/names/lastNames.txt";
	private static String majors = "rawData/majors/Majors.txt";
	private static String isbns = "rawData/Textbooks/textbook_isbns.txt";
	private static String titles = "rawData/Textbooks/textbook_titles.txt";

	private static String[] firstNameArr = makeArr(firstNames);
	private static String[] lastNameArr = makeArr(lastNames);
	private static String[] majorArr = makeMajorArray(majors);
	private static String[] titleArr = makeArr(titles);
	private static String[] isbnArr = makeArr(isbns);
	private static String[] rankArr = {"Instructor", "Assistant Professor", "Associate Professor", "Professor"};
	
	public static Name emitName() {
		String randFirstName = firstNameArr[rand.nextInt(firstNameArr.length)];
		String randLastName = lastNameArr[rand.nextInt(lastNameArr.length)];
		return new Name(randFirstName, randLastName);
	}
	
	public static String[] emitTitleAndIsbn() {
		int randNum = (int)(Math.random() * titleArr.length);
		String[] textbook = {titleArr[randNum], isbnArr[randNum]};
		return textbook;
	}

	public static double emitPrice() {
		double randomNum = Math.random() * 200.0;
		return Math.round(randomNum * 100.0) / 100.0;
	}
	
	public static String emitMajor() {
		return majorArr[(int)(Math.random() * majorArr.length)];
		
	}
	
	public static String emitRank() {
		return rankArr[(int)(Math.random() * rankArr.length)];
	}
	
	public static double emitGpa() {
		return  Math.round((Math.random() * 4.0) * 10.0)/10.0;
	}
	
	public static void importStudents(PersonBag personBag) {
		for(int i = 0; i < 1000; i++) {
			Student student = new Student(emitName(), emitGpa(), emitMajor());
			personBag.insert(student);
		}
	}
	
	public static void importInstructors(PersonBag personBag) {
		for(int i = 0; i < 500; i++) {
			double randSalary = Math.round(((Math.random() * 90000 ) + 10000) * 100.0)/100.0;
			Instructor instructor = new Instructor(emitName(), emitRank(), randSalary );
			personBag.insert(instructor);
		}
	}
	
	public static void importTextbooks(TextbookBag textbookBag) {
		for(int i = 0; i < titleArr.length; i++) {
			Textbook textbook = new Textbook(titleArr[i], isbnArr[i], emitName(), emitPrice());
			textbookBag.insert(textbook);
		}
	}
	
	public static String[] makeArr(String fileName) {
		int lineCnt = 0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			while(br.readLine() != null) {
				lineCnt++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String textArr[] = new String[lineCnt];
		
		try {
			br = new BufferedReader(new FileReader(fileName));
			for(int i = 0; i < textArr.length; i++) {
				textArr[i] = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return textArr;
	}
	
	public static String[] makeMajorArray(String fileName) {
		File file = new File(fileName);
		String[] arr;
		try {
			Scanner sc = new Scanner(file);
			String line = sc.nextLine();
			arr = line.split(", ");
			sc.close();
			return arr;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
//	private static String[][] titleAndIsbnArr = makeBookTitleIsbnArr(titles, isbns);
	
//	private static String[][] makeBookTitleIsbnArr(String titles, String isbns) {
//	String[][] arr = new String[]
//	
//	String[] txtBookTitles = makeArr(titles);
//	String[] txtBookIsbns = makeArr(isbns);
//	
//	
//}

	
//	public static String[] makeArray(String fileName) {
//		File file = new File(fileName);
//		int lineCount = 0;
//
//		try {
//			Scanner s1 = new Scanner(file, "UTF-8");
//			while (s1.hasNextLine()) {
//				lineCount++;
//				s1.nextLine();
//			}
//			String[] textArr = new String[lineCount];
//			s1.close();
//
//			Scanner s2 = new Scanner(file, "UTF-8");
//			for (int i = 0; i < lineCount; i++) {
//				textArr[i] = s2.nextLine();
//			}
//			s2.close();
//			return textArr;
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

}
