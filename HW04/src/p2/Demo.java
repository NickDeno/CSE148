package p2;

import p1.Course;
import p1.Name;
import p1.Student;

public class Demo {
	
	public static void main(String[] args) {
		Name n1 = new Name("Jose", "Smith");
		Course c1 = new Course("CSE148", "OOP", 4);
		Course c2 =  new Course("CSE118", "FOP", 3);
		
		Course[] courses = {c1, c2};
		
		Student s1 = new Student(n1, courses);
		Student s2 = new Student(n1, courses);
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println();
		
		n1.setFirstName("John");
		n1.setLastName("Jones");
		s1.setName(n1);
		System.out.println(s1);
		System.out.println(s2);
		
	}
}
