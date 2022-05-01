package p1;

public class Demo {
	private static final int STUDENTS_TO_CREATE = 50;
	
	public static void main(String[] args) {
		Student[] studentList = new Student[STUDENTS_TO_CREATE];
		studentList = StudentHelper.createStudents(studentList);
		StudentHelper.printStudents(studentList);
	}

}