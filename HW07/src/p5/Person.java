package p5;

public class Person {
	private Name name;
	private static int idCount = 0;

	public Person(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public static int getIdCount() {
		return idCount;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

}
