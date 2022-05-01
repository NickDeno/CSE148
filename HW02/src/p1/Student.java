package p1;

import java.util.Arrays;

public class Student {
	private Name name;
	private double gpa;
	private Course[] courses = new Course[4];

	public Student(Name name, double gpa, Course[] courses) {
		this.name = name;
		this.gpa = gpa;
		this.courses = courses;
	}

	public Student(Name name, double gpa) {
		this.name = name;
		this.gpa = gpa;
	}

	public Student(Name name, Course[] courses) {
		this.name = name;
		this.courses = courses;
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

	public Course[] getCourses() {
		return courses;
	}

	public void setCourses(Course[] courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student " + name + ", GPA= " + gpa + ", " + Arrays.toString(courses) + "]";
	}
}
