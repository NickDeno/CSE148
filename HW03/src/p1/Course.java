package p1;

public class Course {
	private String number;
	private String title;
	private String description;
	private int numberOfCredit;
	private Textbook textbook;
	private Instructor instructor;

	public Course(String number, String title, String description, int numberOfCredit, Textbook textbook, Instructor instructor) {
		super();
		this.number = number;
		this.title = title;
		this.description = description;
		this.numberOfCredit = numberOfCredit;
		this.textbook = textbook;
		this.instructor = instructor;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumberOfCredit() {
		return numberOfCredit;
	}

	public void setNumberOfCredit(int numberOfCredit) {
		this.numberOfCredit = numberOfCredit;
	}

	public Textbook getTextbook() {
		return textbook;
	}

	public void setTextbook(Textbook textbook) {
		this.textbook = textbook;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course [number=" + number + ", title=" + title + ", numberOfCredit=" + numberOfCredit + ", textbook="
				+ textbook + ", instructor=" + instructor + "]";
	}

}
