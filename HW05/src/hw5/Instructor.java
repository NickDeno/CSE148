package hw5;

public class Instructor extends Person {
	private double salary;

	public Instructor(Name name, String phone, double salary) {
		super(name, phone);
		this.salary = salary;
	}
	
	public Instructor(Instructor instructor) {
		super(new Name(instructor.getName()), instructor.getPhone());
		this.salary = instructor.getSalary();
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Instructor [" + super.toString() + ", salary=" + salary + "]";
	}

}
