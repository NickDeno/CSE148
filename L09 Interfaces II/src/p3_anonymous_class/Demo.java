package p3_anonymous_class;

public class Demo {

	public static void main(String[] args) {
		Student s1 = new Student("Adam", 3.5, new Playable() {

			@Override
			public void play() {
				System.out.println("Play hockey!");
			}
			
		});
		
		s1.playSports();
	}
}
