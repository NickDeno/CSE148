package p1;

public class Fish extends Pet {
	private double length;
	private String color;
	
	public Fish(String name, double weight, double length, String color) {
		super(name, weight);
		this.length = length;
		this.color = color;
	}
	
	public double getLength() {
		return length;
	}
	
	public void setLength(double length) {
		this.length = length;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Fish [" + super.toString() + ", length=" + length + ", color=" + color + "]";
	}

	@Override
	public void show() {
		System.out.println(this.toString());
	}
}
