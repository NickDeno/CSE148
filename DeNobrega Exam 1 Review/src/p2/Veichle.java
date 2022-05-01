package p2;

public abstract class Veichle {
	private String make;
	private String year;
	protected double price;
	private Name ownerName;

	public Veichle(String make, String year, double price, Name ownerName) {
		super();
		this.make = make;
		this.year = year;
		this.price = price;
		this.ownerName = ownerName;
	}
	
	public Veichle(Veichle veichle) {
		this.make = veichle.make;
		this.year = veichle.year;
		this.price = veichle.price;
		this.ownerName = new Name(veichle.ownerName);
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Name getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(Name ownerName) {
		this.ownerName = ownerName;
	}

	@Override
	public String toString() {
		return "Veichle [make=" + make + ", year=" + year + ", price=" + price + ", ownerName=" + ownerName + "]";
	}

}
