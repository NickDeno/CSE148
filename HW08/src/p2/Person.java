package p2;

public class Person {
	private Name name;
	private String id;
	private static int idCount = 0;

	public Person(Name name) {
		super();
		this.name = name;
		this.id = String.valueOf(++idCount);
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + "]";
	}

}
