package p4_lambda_expression;

public class Student {
	// Instance variables reflecting the STATE of an object (State: name gpa... Usually are nouns)
	private String name;
	private double gpa;
	
	// Instance variable reflecting the BEHAVIOR of an object (Usually are verbs)
	private Playable playable; // function

	// An interface allows unimplemented functions (function placeholders) to be passed to a class.
	// These placeholders can be filled with actual implemented functions
	public Student(String name, double gpa, Playable playable) { 
		super();
		this.name = name;
		this.gpa = gpa;
		this.playable = playable;
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
	
	public void playSports() {
		playable.play();
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gpa=" + gpa + "]";
	}

}
