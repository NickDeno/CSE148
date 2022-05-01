package p1;

public class Instructor {
	private Name name;
	private String id;
	private String rank;
	private double salary;
	private String officeNumber;
	
	private static int idCount = 0;

	public Instructor(Name name, String rank, double salary, String officeNumber) {
		super();
		this.name = name;
		this.id = String.valueOf(++idCount);
		this.rank = rank;
		this.salary = salary;
		this.officeNumber = officeNumber;
	}

	public Instructor(Name name, String officeNumber) {
		super();
		this.name = name;
		this.id = String.valueOf(++idCount);
		this.officeNumber = officeNumber;
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

	public void setId(String id) {
		this.id = id;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}

	@Override
	public String toString() {
		return "Intstructor [name=" + name + ", id=" + id + ", rank=" + rank + ", salary=" + salary + ", officeNumber="
				+ officeNumber + "]";
	}

}
