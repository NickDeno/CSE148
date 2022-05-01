package p1;

import java.util.Arrays;

public class Student {
	private Name name;
	private Course[] courses;

	public Student(Name name, Course[] courses) {
		this.setName(name);
		this.setCourses(courses);
	}

	public Student(Student student) {
		this.setName(student.name);
		this.setCourses(student.courses);
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = new Name(name.getFirstName(), name.getLastName());
	}

	public Course[] getCourses() {
		return courses;
	}

	public void setCourses(Course[] courses) {
		Course[] arr = new Course[courses.length];
		for (int i = 0; i < courses.length; i++) {
			arr[i] = new Course(courses[i]);
		}
		this.courses = arr;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", courses=" + Arrays.toString(courses) + "]";
	}

}
