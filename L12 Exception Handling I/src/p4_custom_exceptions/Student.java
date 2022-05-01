package p4_custom_exceptions;

public class Student {
	private String name;
	private double gpa;

	public Student(String name, double gpa)   {
		super();
		this.name = name;
		if(gpa > 4.0) {
			try {
				throw new IncorrectGpaException("The gpa is too big!");
			} catch(IncorrectGpaException e) {
				System.out.println(e.getMessage());
				gpa = 4.0;
			}
		}
		if (gpa < 0.0) {
			try {
				throw new IncorrectGpaException("The gpa is too small!");
			} catch(IncorrectGpaException e) {
				System.out.println(e.getMessage());
				gpa = 0.0;
			}
		}
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
