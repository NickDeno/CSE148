package p3_cloneable;

public class Student implements Comparable<Student>, Cloneable {
	private Name name;
	private double gpa;

	public Student(Name name, double gpa) {
		super();
		this.name = name;
		this.gpa = gpa;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
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

	@Override
	public int compareTo(Student o) {
//		return this.name.compareTo(o.name);
		return Double.compare(this.gpa, o.gpa);
	}
	
	@Override
	public Student clone() throws CloneNotSupportedException {
		return (Student) super.clone();
	}

}
