package p5;

public class Course {
	private String courseNumber;
	private String courseTitle;
	private int numCredits;

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

	public int getNumCredits() {
		return numCredits;
	}

	public void setNumCredits(int numCredits) {
		this.numCredits = numCredits;
	}

	public Course(String courseNumber, String courseTitle, int numCredits) {
		super();
		this.courseNumber = courseNumber;
		this.courseTitle = courseTitle;
		this.numCredits = numCredits;
	}

	@Override
	public String toString() {
		return "Course [courseNumber=" + courseNumber + ", courseTitle=" + courseTitle + ", numCredits=" + numCredits
				+ "]";
	}

}
