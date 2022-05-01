package p6;

public class Person implements Comparable<Person>, Cloneable {
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

	@Override
	public int compareTo(Person o) {
		return this.id.compareTo(o.getId());
	}
	
	@Override
	public Person clone() throws CloneNotSupportedException {
		return (Person) super.clone();
	}

}
