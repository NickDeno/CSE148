package p0;

public class Student {
	// Instance variables reflecting the STATE of an object (State: name gpa... Usually are nouns)
	private String name;
	private double gpa;
	
	// Instance variable reflecting the BEHAVIOR of an object (Usually are verbs)
	//private Playable playable; // function

	public Student(String name, double gpa) {
		super();
		this.name = name;
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gpa=" + gpa + "]";
	}

}
