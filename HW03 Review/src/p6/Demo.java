package p6;

import p5.Course;
import p5.Name;
import p5.Student;

public class Demo {
	public static void main(String[] args) {
		Name name1 = new Name("Alan", "Smith");
		Name name2 = new Name("Jose", "Smith");
		Name name3 = new Name("Bill", "Smith");
		Course c1 = new Course("CSE110", "CS College Seminar", 1);
		Course c2 = new Course("CSE118", "Intro to Programming", 3);
		Course c3 = new Course("CSE148", "Object Oriented Programming", 4);
		Course[] arr1 = {c1};
		Course[] arr2 = {c1, c2};
		Course[] arr3 = {c1, c2, c3};
		
		Student s1 = new Student(name1, arr1);
		Student s2 = new Student(name2, arr2);
		Student s3 = new Student(name3, arr3);
		
		StudentBag theBag = new StudentBag(100);
		theBag.insert(s1);
		theBag.insert(s2);
		theBag.insert(s3);
		theBag.display();
		System.out.println("Search Student by ID 3: ");
		System.out.println(theBag.searchById("3"));
		
	}
}
