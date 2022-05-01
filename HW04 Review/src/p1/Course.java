package p1;

public class Course {
	private String number;
	private String title;
	private int credits;
	
	public Course(String number, String title, int credits) {
		super();
		this.number = number;
		this.title = title;
		this.credits = credits;
	}
	
	public Course(Course course) {
		super();
		this.number = course.number;
		this.title = course.title;
		this.credits = course.credits;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "Course [number=" + number + ", title=" + title + ", credits=" + credits + "]";
	}
	
}
