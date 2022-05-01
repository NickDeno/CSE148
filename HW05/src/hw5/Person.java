package hw5;

public class Person {
	private Name name;
	private String id;
	private String phone;

	private static int idCount = 0;

	public Person(Name name, String phone) {
		this.name = name;
		this.id = String.valueOf(++idCount);
		this.phone = phone;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + ", phone=" + phone + "]";
	}

}
