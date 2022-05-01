package p1;

public class StudentHelper {
	private static final int MAX_STUDENT_COURSES = 4;

	private static final int MIN_NUM_OF_COURSES = 1;
	private static final int MAX_NUM_OF_COURSES = 4;

	public static Student[] createStudents(Student[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Student(randomName(), randomGpa(), randomCourses(MAX_STUDENT_COURSES));
		}
		return arr;

	}

	public static void printStudents(Student[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].toString());
		}
	}

	private static Name randomName() {
		String firstName = "";
		String lastName = "";

		for (int i = 0; i < 5; i++) {
			if (i == 0) {
				firstName += (char) ('A' + (int) (Math.random() * 26));
				lastName += (char) ('A' + (int) (Math.random() * 26));
			} else {
				firstName += (char) ('a' + (int) (Math.random() * 26));
				lastName += (char) ('a' + (int) (Math.random() * 26));
			}
		}
		return new Name(firstName, lastName);
	}

	private static double randomGpa() {
		return (Math.random() * 3.0) + 1.0;
	}

	private static Course[] randomCourses(int maxStudentCourses) {
		Course[] studentCourses = new Course[maxStudentCourses];
		int numOfCourses = (int) ((Math.random() * (MAX_NUM_OF_COURSES - MIN_NUM_OF_COURSES + 1)) + MIN_NUM_OF_COURSES);
		for (int i = 0; i < numOfCourses; i++) {
			studentCourses[i] = new Course(randomCourseNumber(), randomCourseTitle(), randomCredits());
		}

		return studentCourses;
	}

	private static String randomCourseNumber() {
		String[] courseList = { "CSE", "CST", "MAT", "ENG", "PHY", "BUS", "PSY" };
		int randNum = (int) ((Math.random() * (299 - 100) + 1) + 100);

		return courseList[(int) (Math.random() * courseList.length)] + randNum;
	}

	private static String randomCourseTitle() {
		String courseTitle = "";
		int titleLength = (int) ((Math.random() * (20 - 10)) + 10);

		for (int i = 0; i < titleLength; i++) {
			courseTitle += (char) ('a' + (int) (Math.random() * 26));
		}

		return courseTitle;
	}

	private static int randomCredits() {
		return (int) ((Math.random() * 4) + 1);
	}

}
