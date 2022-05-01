package p1;

public class Demo {

	public static void main(String[] args) {
		//Using setters to create student object
		Student s1 = new Student();
		s1.setName("John");
		s1.setAge(21);
		s1.setPhone("631-849-3453");
		s1.setGpa(3.7);
		
		//Using constructor to create student object
		Student s2 = new Student("Jose", 22, "631-556-3537", 3.9);

	}

}
