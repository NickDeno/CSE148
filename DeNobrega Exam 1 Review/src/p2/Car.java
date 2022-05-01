package p2;

public class Car extends Veichle {
	private int doors;

	public Car(String make, String year, double price, Name ownerName, int doors) {
		super(make, year, price, ownerName);
		this.doors = doors;
	}

	public Car(Car car) {
		this(car.getMake(), car.getYear(), car.getPrice(), new Name(car.getOwnerName()), car.doors);
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	@Override
	public String toString() {
		return "Car [" + super.toString() + ", doors=" + doors + "]";
	}

}
