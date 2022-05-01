package p7;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo {
	public static void main(String[] args) {
		Student s1 = new Student(new Name("John","Brown"), 3.5);
		Student s2 = new Student(new Name("Jack","Brown"), 3.9);
		Student s3 = new Student(new Name("Caleb", "Smith"), 3.7);
		Instructor i1 = new Instructor(new Name("Bin", "Li"), "Professor");
		Instructor i2 = new Instructor(new Name("Xingben", "Chen"), "Associate Professor");
		Instructor i3 = new Instructor(new Name("John", "Smith"), "Professor");
		
		PersonBagArray myBag = new PersonBagArray(6);
		myBag.insert(s1);
		myBag.insert(s2);
		myBag.insert(s3);
		myBag.insert(i1);
		myBag.insert(i2);
		myBag.insert(i3);
		
		Student s4 = new Student(new Name("Tom","Casey"), 3.5);
		Student s5 = new Student(new Name("Jordan","Blue"), 3.9);
		Student s6 = new Student(new Name("Caleb", "Smith"), 3.7);
		Instructor i4 = new Instructor(new Name("Jack", "Capell"), "Professor");
		Instructor i5 = new Instructor(new Name("Dan", "Spallina"), "Associate Professor");
		Instructor i6 = new Instructor(new Name("Connor", "Hamilton"), "Professor");
		
		PersonBagList myList = new PersonBagList(6);
		myList.insert(s4);
		myList.insert(s5);
		myList.insert(s6);
		myList.insert(i4);
		myList.insert(i5);
		myList.insert(i6);
			
		//Testing sort method in PersonBagArray by first name:
		System.out.println("PersonBagArray sorted by first name:");
		Person[] sortedBag = null;
		try {
			sortedBag = myBag.sort(myBag.getArr(), (o1,o2) -> o1.getName().getFirstName().compareTo(o2.getName().getFirstName()));
		} catch (CloneNotSupportedException e) {
			e.getMessage();
		}
		System.out.println(Arrays.toString(sortedBag));
		System.out.println();
		
	
		//Testing sort method in PersonBagList by first name
		System.out.println("PersonBagList sorted by first name:");
		ArrayList<Person> sortedList = null;
		try {
			sortedList = myList.sort(myList.getArr(), (o1,o2) -> o1.getName().getFirstName().compareTo(o2.getName().getFirstName()));
		} catch (CloneNotSupportedException e) {
			e.getMessage();
		}
		System.out.println(sortedList);
		System.out.println();
		
		
		//Testing GpaException error
		s1.setGpa(4.1);
		System.out.println(s1.getGpa());
		System.out.println();
		
		//Testing RankException error
		i1.setRank("Student");
		System.out.println(i1.getRank());
		System.out.println();
			
	}
}
