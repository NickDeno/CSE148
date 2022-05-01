package p2;

public class Demo {
	
	private static final String[] majorList = {"CSE", "CST", "MAT", "ENG", "PHY", "PED", "BUS", "PSY"};
	
	public static void main(String[] args) {

	}
	
	public static String getRandomMajor() {
		return majorList[(int)(Math.random() * majorList.length )];
	
	}
	
	public static int getRandomDigits() {
		return (int)(Math.random() * 200 )+ 100;
	}
}
