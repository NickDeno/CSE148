package p1;

// Cat: Subclass, Child class, Derived class
// Pet: Superclass, Parent class, Base class
// A subclass (Cat) inherits non-private class members from the super (Pet) class
public class Cat extends Pet { // Cat class will inherit code from another class
	private String color;

	public Cat(String name, double weight, String color) {
		super(name, weight); // Must be the very first line in your constructor
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
//	@Override //Overrides superclass setName method with your own
//	public void setName(String name) {
//		super.setName("Happy Cat: " + name);
//	}
//	
//	@Override //Overrides superclass getName method with your own
//	public String getName() {
//		return "My cat is a " +super.getName();
//	}

	@Override
	public String toString() {
		return "Cat [" + super.toString() + ", color=" + color + "]";
	}

	@Override
	public void show() {
		System.out.println(this.toString()); 
	}

}
