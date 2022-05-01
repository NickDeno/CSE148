package p5;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Demo {

	public static void main(String[] args) {
		Student s1 = new Student(new Name("John","Brown"), 3.5);
		Student s2 = new Student(new Name("Jack","Brown"), 3.9);
		Student s3 = new Student(new Name("Caleb", "Smith"), 3.7);
		Instructor i1 = new Instructor(new Name("Bin", "Li"), "Professor");
		Instructor i2 = new Instructor(new Name("Xingben", "Chen"), "Associate Professor");
		Instructor i3 = new Instructor(new Name("John", "Smith"), "Professor");
		Instructor i4 = new Instructor(new Name("Michael", "Bonanno"), "Lecturer");
		
		//Testing constructor and insert method
		PersonBag myBag = new PersonBag(10);
		myBag.insert(s1);
		myBag.insert(s2);
		myBag.insert(s3);
		myBag.insert(i1);
		myBag.insert(i2);
		myBag.insert(i3);
		myBag.insert(i4);
		
		//Testing display method:
		System.out.println("Original PersonBag:");
		myBag.display();
		
		//Testing predicate search method using lambda expression
		ArrayList<Person> foundByFirstName = myBag.search((Person p) -> {
			return p.getName().getFirstName().equals("Jack");
		});
		System.out.println();
		System.out.println("Found by first name using predicate: ");
		System.out.println(foundByFirstName);
		
		//2nd Testing predicate search method. Search by gpa
		ArrayList<Person> foundByGpa = myBag.search((Person p) -> {
				if(p instanceof Student) {
					return ((Student) p).getGpa() == 3.5;
				}
				return false;
			
		});
		System.out.println();
		System.out.println("Found by Gpa of 3.5");
		System.out.println(foundByGpa);
	}

}
