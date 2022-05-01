package p1;

public class Dog extends Pet {
	private String breed;

	public Dog(String name, double weight, String breed) {
		super(name, weight);
		this.breed = breed;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "Dog [" + super.toString() + ", breed=" + breed + "]";
	}

	@Override
	public void show() {
		System.out.println(this.toString());
	}

}
