package p6;

import java.util.Arrays;

public class Student {
	private Name name;
	private double gpa;
	private Course[] arr;

	public Student(Name name, double gpa, Course[] courses) {
		this.name = name;
		this.gpa = gpa;
		arr = courses;
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

	public Course[] getArr() {
		return arr;
	}

	public void setArr(Course[] arr) {
		this.arr = arr;
	}

	@Override
	public String toString() {
		return "Name " + name + ", Gpa =" + gpa + ", \nCourses =" + Arrays.toString(arr) ;
	}

}
