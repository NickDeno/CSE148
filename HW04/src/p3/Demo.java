package p3;

public class Demo {
	
	public static void main(String[] args) {
		Course c1 = new Course(randomCourseNumber(),randomCourseTitle(), randomCredits());
		Course c2 = new Course(randomCourseNumber(),randomCourseTitle(), randomCredits());
		Course c3 = new Course(randomCourseNumber(),randomCourseTitle(), randomCredits());
		Course c4 = new Course(randomCourseNumber(),randomCourseTitle(), randomCredits());
		
		CourseBag myBag = new CourseBag(4);
		myBag.insert(c1);
		myBag.insert(c2);
		myBag.insert(c3);
		myBag.insert(c4);
		myBag.display();
		
		Course c5 = myBag.searchByCourseNumber("CSE163");
		System.out.println(c5);
		c5.setCourseNumber("CSE148");
		
		System.out.println(myBag.searchByCourseNumber("CSE163"));
		System.out.println(c5);
	
	
	}
	
	
	
	
	private static String randomCourseNumber() {
		String[] courseList = { "CSE", "CST", "MAT", "ENG", "PHY", "CHE", "BIO", "HIS" };
		int randNum = (int) ((Math.random() * (299 - 100) + 1) + 100);

		return courseList[(int) (Math.random() * courseList.length)] + randNum;
	}

	private static String randomCourseTitle() {
		String courseTitle = "";
		int titleLength = (int) ((Math.random() * (40 - 20)) + 20);

		for (int i = 0; i < titleLength; i++) {
			courseTitle += (char) ('a' + (int) (Math.random() * 26));
		}

		return courseTitle;
	}
	
	private static double randomCredits() {
		return (Math.random() * 3) + 1;
	}

}
