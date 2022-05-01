package p1;

// Adding "abstract" prevents Pet objects from being created by user.
// Adding "final" to a class prevent subclasses from being made of the class
public abstract class Pet {
	private String name;
	private double weight;

	public Pet(String name, double weight) {
		super();
		this.name = name;
		this.weight = weight;
	}
	
	public abstract void show();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public final double getWeight() { // Adding "final" to method means subclass cannot override the method 
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Pet [name=" + name + ", weight=" + weight + "]";
	}

}
