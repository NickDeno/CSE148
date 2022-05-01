package p3;

public class Cat {
	
	private String name;
	private double weight = 15;
	
	
	public Cat(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void feed(double foodAmount) {
		this.weight += foodAmount/10;
	}
	
}
