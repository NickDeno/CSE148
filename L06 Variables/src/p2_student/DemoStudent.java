package p2_student;

public class DemoStudent {

	public static void main(String[] args) {
		Name name1 = new Name("A", "AAAA");
		
		Name name2 = new Name("B", "BBBB");
		//name1.setFirstName("ZZZZ");
		int age = 20;
		Student s1 = new Student(name1, age, 3.5);
		//s1.setAge(60);
		s1.getName().setFirstName("Z");
		s1.setName(name2);
		
		
//		System.out.println(s1);
		
		Student s2 = new Student(s1);
		s2.setGpa(1.0);
		
		System.out.println(s2);
		System.out.println(s1);
		
	}

}
