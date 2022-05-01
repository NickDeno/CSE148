package p1;

public class Car {
	private String make;
	private int year;
	private String color;
	private int numberOfDoors;
	private boolean isGas;
	private double price;
	
	private static int numberOfCars = 0;

	public Car(String make, int year, String color, int numberOfDoors, boolean isGas, double price) {
		this.make = make;
		this.year = year;
		this.color = color;
		this.numberOfDoors = numberOfDoors;
		this.isGas = isGas;
		this.price = price;
		numberOfCars++;
	}
	
	public Car(String make, double price) {
		this.make = make;
		this.price = price;
		numberOfCars++;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	public boolean isGas() {
		return isGas;
	}

	public void setGas(boolean isGas) {
		this.isGas = isGas;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public static int getNumberOfCars() {
		return numberOfCars;
	}

	public static void setNumberOfCars(int numberOfCars) {
		Car.numberOfCars = numberOfCars;
	}
	
	@Override
	public String toString() {
		return "Car [make=" + make + ", year=" + year + ", color=" + color + ", numberOfDoors=" + numberOfDoors
				+ ", isGas=" + isGas + ", price=" + price + "]";
	}
	
	
}
