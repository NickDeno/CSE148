package p1_courses;

public class Course {
	private String courseNumber;
	private String courseTitle;
	private int credits;

	// Overloaded constructors
	public Course(String courseNumber, String courseTitle, int credits) {
		super();
		this.courseNumber = courseNumber;
		this.courseTitle = courseTitle;
		this.credits = credits;
	}

	public Course(String courseNumber, int credits) {
		super();
		this.courseNumber = courseNumber;
		this.credits = credits;
	}

	public Course(String courseNumber) {
		super();
		this.courseNumber = courseNumber;
	}

	public Course(int credits) {
		super();
		this.credits = credits;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "Course [courseNumber=" + courseNumber + ", courseTitle=" + courseTitle + ", credits=" + credits + "]";
	}
	
	

}
