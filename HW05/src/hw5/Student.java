package hw5;

public class Student extends Person {
	private double gpa;
	private String major;

	public Student(Name name, String phone, double gpa, String major) {
		super(name, phone);
		this.gpa = gpa;
		this.major = major;
	}

	public Student(Student student) {
		super(new Name(student.getName()), student.getPhone());
		this.gpa = student.getGpa();
		this.major = student.getMajor();
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student [" + super.toString() + ", gpa=" + gpa + ", major=" + major + "]";
	}

}
