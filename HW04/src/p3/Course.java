package p3;


public class Course {
	private String courseNumber;
	private String courseTitle;
	private double credits;

	public Course(String courseNumber, String courseTitle, double credits) {
		this.courseNumber = courseNumber;
		this.courseTitle = courseTitle;
		this.credits = credits;
	}

	public Course(Course course) {
		this.courseNumber = course.getCourseNumber();
		this.courseTitle = course.getCourseTitle();
		this.credits = course.credits;
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

	public double getCredits() {
		return credits;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "Course [courseNumber=" + courseNumber + ", courseTitle=" + courseTitle + ", credits=" + credits + "]";
	}

}
