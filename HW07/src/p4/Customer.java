package p4;

public class Customer {
	private String name;
	private double sales;

	public Customer(String name, double sales) {
		super();
		this.name = name;
		this.sales = sales;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", sales=" + sales + "]";
	}

}
