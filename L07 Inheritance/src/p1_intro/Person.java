package p1_intro;

public class Person {
	private Name name;
	private String id;
	private static int idCount = 0;
	
	public Person(Name name) {
		this.name = name;
		id = String.valueOf(idCount++);
	}
	
	public Person(Person person) {
		this.name = new Name(person.name); // Utilizing deep copy constructor of Name
		this.id = String.valueOf(idCount++);
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
