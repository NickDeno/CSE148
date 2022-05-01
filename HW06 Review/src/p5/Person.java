package p5;

public abstract class Person {
	private Name name;
	private String id;
	
	private static int idCount = 0;
	
	public Person(Name name) {
		this.name = name;
		this.id = String.valueOf(++idCount);
	}
	
	public Person(String firstName, String lastName) {
		this.name = new Name(firstName, lastName);
		this.id = String.valueOf(++idCount);
	}
	
//	public Person(Person person) {
//		this.name = new Name(person.name);
//		this.id = String.valueOf(idCount++);	
//	}

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
