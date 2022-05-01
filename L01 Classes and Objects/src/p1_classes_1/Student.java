package p1_classes_1;

/*A class is a template used to create objects
 * 
 */

//private: visible (accessible) inside the class.
//public: visible (accessible) to every program in the world.
//nothing (Default): visible (accessible) inside the same package. Package (Default) access

public class Student {
	
	// State of a student, involves data (nouns)
	// Instance (object) variables, fields, attributes, properties, instance fields
	private String name; 
	private double gpa; 
	private int age; 
	
	//Static variables: belongs to the class not to any objects
	private static String major = "CS"; //class variable
	
	//methods, behavior, involves action (verbs)
	
	//Constructors. Overloaded constructors
	public Student(String name,double gpa, int age) {
		this.name = name;
		this.gpa = gpa;
		this.age = age;
	}
	
	public Student(String name, int age, double gpa) {
		this.name = name;
		this.age = age;
		this.gpa = gpa;
	}
	
	public Student() {
		
	}
	
	public void setName(String name) { //This "name" has a local scope
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public double getGpa() {
		return gpa;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getMajor() {
		return major;
	}
	
	//Overrides java default .toString method which prints the memory address of object
	public String toString() { // Returns the values stored in the object in a string format
		return name + ": " + major + ", " + gpa + ", " + age;
	}
	
	
	
}
