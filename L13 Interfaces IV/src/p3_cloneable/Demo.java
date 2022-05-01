package p3_cloneable;

public class Demo {

	public static void main(String[] args) {
		Student s1 = new Student(new Name("AA", "BB"), 3.5);
		Student s2 = null;
		
		try {
			s2 = s1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println(s1 == s2);
		
		try {
			s2.setName(s1.getName().clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		s1.getName().setFirstName("ZZ");
		System.out.println(s2.getName().getFirstName());
		
	}

}
