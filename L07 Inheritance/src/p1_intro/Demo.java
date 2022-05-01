package p1_intro;

public class Demo {

	public static void main(String[] args) {
//		Student s1 = new Student(new Name("A", "AA"));
//		Student s2 = new Student(s1);
//		
//		s1.getName().setFirstName("B");
//		System.out.println(s1);
//		System.out.println(s2);
//		
//		System.out.println();
//		Instructor i1 = new Instructor(new Name("B", "BB"));
//		Instructor i2 = new Instructor(i1);
//		
//		System.out.println(i1);
//		System.out.println(i2);
		
		Student s1 = new Student(new Name("A", "AA"));
		Student s2 = new Student(s1);
		System.out.println(s1);
		System.out.println(s2);
		
		Instructor i1 = new Instructor(new Name("B", "BB"), "Professor");
		Instructor i2 = new Instructor(i1);
		System.out.println(i1);
		System.out.println(i2);
		
	}

}
