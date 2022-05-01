package p1;

public class Demo {

	public static void main(String[] args) {
		Student s1 = new Student("Adam", 3.5, new BasketballPlayable());
		s1.playSports();
		
		Student s2 = new Student("Billy", 4.0, new HockeyPlayable());
		s2.playSports();
		
		Student s3 = new Student("Cathy", 3.0, new BasketballPlayable());
		s2.playSports();
	}

}
