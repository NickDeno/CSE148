package p1;

import java.util.Arrays;

public class Student {
	private Name name;
	private Course[] arr;

	public Student(Name name, Course[] arr) {
		super();
		this.name = name;
		this.arr = arr;
	}

	public Student(Student student) {
		this.name = new Name(student.name);
		this.arr = new Course[student.arr.length];
		for (int i = 0; i < student.arr.length; i++) {
			arr[i] = new Course(student.arr[i]);
		}

	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = new Name(name);
	}

	public Course[] getArr() {
		return arr;
	}
	
	public Course[] getDeepArr() {
		Course[] a = new Course[arr.length];
		for(int i = 0; i < arr.length; i++) {
			a[i] = new Course(arr[i]);
		}
		return a;
	}

	public void setArr(Course[] arr) {
		this.arr = arr;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", arr=" + Arrays.toString(arr) + "]";
	}

}
