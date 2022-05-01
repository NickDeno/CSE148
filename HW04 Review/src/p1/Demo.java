package p1;

public class Demo {
	
	public static void main(String[] args) {
		Name name = new Name("John", "Doe");
		Course c1 = new Course("CST148", "OOP", 4);
		Course c2 = new Course("MAT141", "Calc I", 4);
		Course[] arr = {c1,c2};
		
		Student s1 = new Student(name, arr);
		
		Student s2 = new Student(s1);
		s1.getArr()[0] = new Course("PED100", "Walking", 1);
		
//		s1.getName().setFirstName("Joe");
//		Name name1 = s1.getName();
//		name1.setFirstName("Jane");
		
		System.out.println(s1);
		System.out.println(s2);
	}
}
