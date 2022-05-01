package p5;

public class Student extends Person {
	private double gpa;

	public Student(Name name, double gpa) {
		super(name);
		this.gpa = gpa;
	}

//	public Student(Student student) {
//		super(new Name(student.getName()));
//		this.gpa = student.gpa;
//	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [" + super.toString() + ", gpa=" + gpa + "]";
	}

}
