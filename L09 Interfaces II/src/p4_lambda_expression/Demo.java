package p4_lambda_expression;

public class Demo {

	public static void main(String[] args) {
		Student s1 = new Student("Adam", 2.5, () -> System.out.println("Play basketball"));
		s1.playSports();
	
	}
}
