package p0;

public class Demo {

	public static void main(String[] args) {
		Student s1 = new Student("Xavier", 3.5);
		s1.getName();
		
		Student s2 = new Student("Javier", 4.0);
		s2.getName();
		
		double score1 = 90;
		double score2 = 80;
		double score3 = 100;
		double average = getAverage(score1, score2, score3); // Function
		
		
	
	}

	public static double getAverage(double d1, double d2, double d3) { // Self contained/function
		return (d1+ d2 + d3);
	}

}
