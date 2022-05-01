package p3;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		Truck t1 = new Truck("Honda", "2012", 10000.99, new Name("John", "Doe"), false);
		Truck t2 = new Truck("Chevy", "2013", 13000.99, new Name("Jeff", "Adams"), true);
		Truck t3 = new Truck("Ford", "2015", 12000.99, new Name("Carlos", "Smith"), false);

		Car c1 = new Car("Nissian", "2016", 9000.99, new Name("Adam", "Jeff"), 4);
		Car c2 = new Car("Nissian", "2016", 10000.99, new Name("Adam", "Jeff"), 4);

		VeichleBag myBag = new VeichleBag(10);
		myBag.insert(t1);
		myBag.insert(t2);
		myBag.insert(t3);
		myBag.insert(c2);
		myBag.insert(c1);
		myBag.display();
		
		Veichle[] foundByDoors = myBag.searchByDoors(4);
		System.out.println(Arrays.toString(foundByDoors));
		
		myBag.removeNonEv();
		System.out.println();
		myBag.display();

	}

}
