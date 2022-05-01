package p1;

public class Student {
	
	private String name;
	private int age;
	private String phone;
	private double gpa;
	
	
	public Student(String name, int age, String phone, double gpa) {
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.gpa = gpa;
	}
	
	public Student() {
		
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public double getGpa() {
		return gpa;
	}
}
