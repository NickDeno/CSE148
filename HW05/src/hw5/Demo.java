package hw5;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		Person s1 = new Student(new Name("John", "Smith"), "631-865-4532", 3.4, "CS");
		Person s2 = new Student(new Name("Joe", "Jones"), "631-332-6512", 3.6, "Mathematics");
		Person s3 = new Student(new Name("Matt", "Ryans"), "631-985-6731", 3.8, "Biology");
		Person s4  = new Student((Student)s3);
		
		Person i1 = new Instructor(new Name("Jack", "Smith"), "631-887-7854", 60000.99);
		Person i2 = new Instructor(new Name("Robert", "Junior"), "631-103-7101", 50000.99);
		Person i3 = new Instructor(new Name("Bill", "Roberts"), "631-764-3564", 90000.99);

		PersonBag myBag = new PersonBag(7);
		myBag.insert(s1);
		myBag.insert(s2);
		myBag.insert(s3);
		myBag.insert(s4);
		myBag.insert(i1);
		myBag.insert(i2);
		myBag.insert(i3);
		System.out.println("Orignal Bag:");
		myBag.display();

		String lastNameChosen = "Smith";
		String idChosen = "6";

		Person[] foundByLastName = myBag.searchByLastName(lastNameChosen);
		System.out.println("People found with last name: " + lastNameChosen);
		System.out.println(Arrays.toString(foundByLastName));
		System.out.println();

		Person foundById = myBag.searchById(idChosen);
		System.out.println("Person found with id: " + idChosen);
		System.out.println(foundById);
		System.out.println();

		myBag.removeByLastName(lastNameChosen);
		System.out.println("Bag after removing people with last name: " + lastNameChosen);
		myBag.display();

		myBag.removeById(idChosen);
		System.out.println("Bag after removing person with id: " + idChosen);
		myBag.display();

	}

}
