package p5;
import java.util.Arrays;

public class Student {
	private Name name;
	private String id;
	private Course arr[];
	
	private static int idCount = 0;
	
	public Student(Name name, Course[] arr) {
		super();
		this.name = name;
		this.id = String.valueOf(++idCount);
		this.arr = arr;
	}
	
	public Student(Name name) {
		super();
		this.name = name;
		this.id = String.valueOf(++idCount);
		this.arr = new Course[4];
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

	public Course[] getArr() {
		return arr;
	}

	public void setArr(Course[] arr) {
		this.arr = arr;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", arr=" + Arrays.toString(arr) + "]";
	}
}
