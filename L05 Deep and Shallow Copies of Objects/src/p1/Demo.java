package p1;

public class Demo {
	public static void main(String[] args) {
		//Shallow copy = copy memory address, Deep copy = copy data
		
		Name name1 = new Name("Alan", "Smith"); // name1 is a reference variable, holds memory address
		Name name2 = new Name("Jose", "Smith"); //name2, name3, name4 are also reference variables
		Name name3 = new Name("Bill", "Smith");
		Name name4 = name1; // Not creating a new object since there is no "new Name". Just assigning the memory address of name1 to name4
		
		// reference variable
		String firstName = "Joe";
		
		//primitive variables, not holding memory address but instead hold data
		int number = 10; // 4 bytes
		double gpa = 4.0; // 8 bytes
		boolean isHot = true;
		// also long, short, float, byte, char
		
		System.out.println(name1 == name4);
		name1.setFirstName("Zack");
		System.out.println(name4.getFirstName());
		
		
		
//		Course c1 = new Course("CSE110", "CS College Seminar", 1);
//		Course c2 = new Course("CSE118", "Intro to Programming", 3);
//		Course c3 = new Course("CSE148", "Object Oriented Programming", 4);
//		Course[] arr1 = {c1};
//		Course[] arr2 = {c1, c2};
//		Course[] arr3 = {c1, c2, c3};
//		
//		Student s1 = new Student(name1, arr1);
//		Student s2 = new Student(name2, arr2);
//		Student s3 = new Student(name3, arr3);
//		
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
		
	}
}
