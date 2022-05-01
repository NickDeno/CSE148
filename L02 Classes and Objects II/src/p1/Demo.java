package p1;

public class Demo {

	public static void main(String[] args) {
		Car c1 = new Car("BMW", 2022, "Red", 2, true, 60000.00);
		System.out.println("Numbers of Cars Created: " +Car.getNumberOfCars());
		Car c2 = new Car("BENZ", 2020, "White", 4, false, 70000.00);
		System.out.println("Numbers of Cars Created: " +Car.getNumberOfCars());
		Car c3 = new Car("GMC", 2016, "Blue", 3, true, 60000.00);
		System.out.println("Numbers of Cars Created: " +Car.getNumberOfCars());
		Car c4 = new Car("HONDA", 2010, "Black", 4, false, 70000.00);
		System.out.println("Numbers of Cars Created: " +Car.getNumberOfCars());
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);

	}

}
