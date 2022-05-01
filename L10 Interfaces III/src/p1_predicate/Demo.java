package p1_predicate;

import java.util.Arrays;
import java.util.function.Predicate;

public class Demo {
	public static void main(String[] args) {
		Truck t1 = new Truck("HONDA", "2012", 10000.99, new Name("John", "Doe"), false);
		Truck t2 = new Truck("CHEVY", "2013", 13000.99, new Name("Jeff", "Adams"), true);
		Truck t3 = new Truck("FORD", "2015", 12000.99, new Name("Carlos", "Smith"), false);
		Car c1 = new Car("TESLA", "2016", 9000.99, new Name("Adam", "Jeff"), 4);
		Car c2 = new Car("TESLA", "2016", 10000.99, new Name("Joe", "Jeff"), 4);
		
		VeichleBag myBag = new VeichleBag(10);
		myBag.insert(t1);
		myBag.insert(t2);
		myBag.insert(t3);
		myBag.insert(c2);
		myBag.insert(c1);
		
//		Veichle[] veichlesFound = myBag.search(new Predicate<Veichle>() {
//
//			@Override
//			public boolean test(Veichle t) {
//				return t.getMake().equals("TESLA") && t.getPrice() >= 10000;
//			}
//
//		});
		
		Veichle[] veichlesFound = myBag.search((Veichle t) -> {
			return t.getMake().equalsIgnoreCase("Tesla") && t.getPrice() >= 10000;
		});
		
		System.out.println(Arrays.toString(veichlesFound));
		
	}
}
