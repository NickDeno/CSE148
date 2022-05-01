package p5;

import java.util.Arrays;
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
		
		PersonBag myBag = new PersonBag(10);
		myBag.insert(i4);
		myBag.insert(i3);
		myBag.insert(i2);
		myBag.insert(i1);
		myBag.insert(s3);
		myBag.insert(s1);
		myBag.insert(s2);
		
		//Predicate
		//Person[] personsFound = myBag.search((Person s) -> s.getName().getFirstName().equals("Jack"));
		Person[] personsFound = myBag.search(new Predicate<Person>() {

			@Override
			public boolean test(Person s) {
				return s.getName().getFirstName().equals("Jack");
			}
			
		});
		System.out.println(Arrays.toString(personsFound));
		
		

	}

}
