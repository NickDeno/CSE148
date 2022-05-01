package p6;

public class Demo {
	
	public static void main(String[] args) {
		Name name1 = new Name("Adam", "Smith");
		Course c1 = new Course("CSE148", "OOP",4);
		Course c2 = new Course("CSE118", "FOP",3);
		Course c3 = new Course("MAT141", "Calc I",4);
		Course[] arr = {c1,c2,c3};
		
		Student s1 = new Student(name1 ,3.5, arr);
		System.out.println(s1.toString());
	}
}
