package p1;

import java.util.Arrays;

public class Student {
	private static final int MAXNUM_OF_COURSES = 4;

	private Name name;
	private String id;
	private Course[] courses = new Course[MAXNUM_OF_COURSES];
	
	private static int idCount = 0; //Static variable can only have one instance for a class. All objects in the class share this variable.
	

	public Student(Name name, Course[] courses) {
		super();
		this.name = name;
		this.id = String.valueOf(++idCount);
		this.courses = courses;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Course[] getCourses() {
		return courses;
	}

	public void setCourses(Course[] courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", courses=" + Arrays.toString(courses) + "]";
	}

}
