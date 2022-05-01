package p1;

public class Demo {

	public static void main(String[] args) {
		Name cse110InstructorName = new Name("Xingbin", "Chen");
		Textbook cse110Textbook = new Textbook("CSE Seminar Textbook", "374-99-765", "Jack Black", 49.99);
		Instructor cse110Instructor = new Instructor(cse110InstructorName, "219");
		Course cse110 = new Course("CSE110", "Computer Science College Seminar","This course covers what to expect as a Computer Science Major", 1, cse110Textbook, cse110Instructor);

		Name cse118InstructorName = new Name("Bin", "Li");
		Textbook cse118Textbook = new Textbook("FOP Textbook", "514-67-987", "John Smith", 59.99);
		Instructor cse118Instructor = new Instructor(cse118InstructorName, "204");
		Course cse118 = new Course("CSE118", "Fundamentals of Programming","This course covers fundamental principles using Java", 4, cse118Textbook, cse118Instructor);

		Name cse148InstructorName = new Name("Xingben", "Chen");
		Textbook cse148Textbook = new Textbook("OOP Textbook", "713-45-435", "Jack Brown", 49.99);
		Instructor cse148Instructor = new Instructor(cse148InstructorName, "219");
		Course cse148 = new Course("CSE148", "Object Oriented Programming","This course covers object oriented programming principles using Java", 4, cse148Textbook, cse148Instructor);

		Name mat142InstructorName = new Name("Maria", "Alzugarry");
		Textbook mat142Textbook = new Textbook("Calculus 2 Textbook", "998-65-425", "Maddie Allen", 89.99);
		Instructor mat142Instructor = new Instructor(mat142InstructorName, "219");
		Course mat142 = new Course("CSE148", "Object Oriented Programming","This course covers principles of Calculus 2", 4, mat142Textbook, mat142Instructor);

		
		
		Name name1 = new Name("John", "Smith");
		Course[] arr1 = { mat142, cse148, cse118 };
		Student s1 = new Student(name1, arr1);

		Name name2 = new Name("Jose", "Perez");
		Course[] arr2 = { mat142, cse110 };
		Student s2 = new Student(name2, arr2);

		Name name3 = new Name("Nick", "Green");
		Course[] arr3 = { cse118, cse110 };
		Student s3 = new Student(name3, arr3);

		Name name4 = new Name("Bill", "Jones");
		Course[] arr4 = { cse148, mat142 };
		Student s4 = new Student(name4, arr4);

		
		
		StudentBag theBag = new StudentBag(4);
		theBag.insert(s1);
		theBag.insert(s2);
		theBag.insert(s3);
		theBag.insert(s4);
		theBag.display();
		System.out.println("Search Student by ID 3: ");
		System.out.println(theBag.findById("3"));
		theBag.removeById("3");
		System.out.println("\n" + "Student list after removing Student ID by 3");
		theBag.display();
		

	}

}
