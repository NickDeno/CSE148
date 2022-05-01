package p3;

public class Demo {

	public static void main(String[] args) {
		Cat cat1 = new Cat("Luna");
		
		for(int i = 0; i<5; i++) {
			cat1.feed(Math.random() * ((15.0-5.0) + 1) + 5.0);
		}
		
		System.out.printf("%-9s%10s%21s\n", "Name", "Weight(in pounds)", "Weight(in ounces)");
		System.out.printf("%-9s%-21.2f%-3.2f\n", cat1.getName(), cat1.getWeight()/16, cat1.getWeight());
	}
}
