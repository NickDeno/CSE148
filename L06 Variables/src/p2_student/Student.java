package p2_student;

public class Student {
	private Name name;
	private int age;
	private double gpa;

	public Student(Name name, int age, double gpa) {
		super();
		this.name = new Name(name.getFirstName(), name.getLastName()); // Deep copy of Name
		this.age = age;
		this.gpa = gpa;
	}
	
	public Student(Student student) {
		this.name = new Name(student.name.getFirstName(), student.name.getLastName());
		this.age = student.age;
		this.gpa = student.gpa;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = new Name(name.getFirstName(), name.getLastName());
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", gpa=" + gpa + "]";
	}

}
