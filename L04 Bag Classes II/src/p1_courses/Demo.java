package p1_courses;

import java.util.Arrays;

public class Demo {
	
	private static final int COURSEBAG_MAX_SIZE = 1000;
	
	public static void main(String[] args) {
		CourseBag myBag = new CourseBag(COURSEBAG_MAX_SIZE);
		Course c1 = new Course("CSE110", "CS College Seminar", 1);
		Course c2 = new Course("CSE118", "Fundamentals of Programming", 1);
		Course c3 = new Course("CSE148", "Object Oriented Programming", 4);
		myBag.insert(c1);
		myBag.insert(c2);
		myBag.insert(c3);
		myBag.display();
//		Course courseRemoved = myBag.removeByCourseNumber("CSE118");
//		myBag.display();
//		System.out.println();
//		System.out.println(courseRemoved);
		
//		Course[] coursesFound = myBag.searchByCredits(1);
//		System.out.println(Arrays.toString(coursesFound)); //Copies the array of coursesFound with parameter count to ensure it only copies elements in array and not null elements
		
		Course[] coursesRemoved = myBag.removeByCredits(1);
		System.out.println(Arrays.toString(coursesRemoved));
		System.out.println();
		System.out.println("After removal:");
		myBag.display();
	}
	
}
