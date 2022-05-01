package p0;

import java.util.Arrays;
import java.util.function.Predicate;

public class Demo {

	public static void main(String[] args) {
		Student s1 = new Student(new Name("John","Brown"), 3.5);
		Student s2 = new Student(new Name("Jack","Brown"), 3.9);
		Student s3 = new Student(new Name("Caleb", "Smith"), 3.7);
		Instructor i1 = new Instructor(new Name("Bin", "Li"), "Professor");
		Instructor i2 = new Instructor(new Name("Xingben", "Chen"), "Associate Professor");
		Instructor i3 = new Instructor(new Name("John", "Smith"), "Professor");
		Instructor i4 = new Instructor(new Name("Michael", "Bonanno"), "Lecturer");
		
		PersonBag myBag = new PersonBag(10);
		myBag.insert(s1);
		myBag.insert(s2);
		myBag.insert(s3);
		myBag.insert(i1);
		myBag.insert(i2);
		myBag.insert(i3);
		myBag.insert(i4);
		System.out.println("Bag:");
		myBag.display();
		
		//a. Search for last name utilizing Predicate test method
		Person[] foundWithPredicate = myBag.search(new Predicate<Person>() {

			@Override
			public boolean test(Person t) {
				return t.getName().getLastName().equals("Brown");
			}
			
		});
		System.out.println("Found By Last Name:");
		System.out.println(Arrays.toString(foundWithPredicate));
		System.out.println();
		
		
		//b. Search for instructor rank utilizing RankAnalyzable with anonymous class
		Person[] foundWithRank = myBag.search(new RankAnalyzable() {
			
			@Override
			public Instructor analyzeRank(Instructor instructor) {
				if(instructor.getRank().equalsIgnoreCase("Associate Professor")) {
					return instructor;
				}
				return null;
			}
			
		});
		System.out.println("Instructors with rank " + "\"Associate Professor\":");
		System.out.println(Arrays.toString(foundWithRank ));
		System.out.println();
		
		
		//c. Search for two instructor ranks utilizing RankAnalyzable with anonymous class
		Person[] foundWithTwoRanks = myBag.search(new RankAnalyzable(){

			@Override
			public Instructor analyzeRank(Instructor instructor) {
				if(instructor.getRank().equalsIgnoreCase("Professor") || instructor.getRank().equalsIgnoreCase("Lecturer")) {
					return instructor;
				}
				return null;
			}
		
		});
		System.out.println("Instructors with rank " + "\"Professor\" or " + "\"Lecturer\":" );
		System.out.println(Arrays.toString(foundWithTwoRanks));
		System.out.println();
		
		
		//d. Search for gpa's less then criteria utilizing GpaAnalyzable with lambda expression
		Person[] foundByGpaCriteria = myBag.search((Student student) -> {
			if(student.getGpa() < 3.8) {
				return student;
			}
			return null;

		});
		System.out.println("Students found with gpa less then " + "\"3.8\":");
		System.out.println(Arrays.toString(foundByGpaCriteria));
		System.out.println();

		
		//e. Search for highest gpa's utilizing Analyzable ??
		Person[] highestGpasFound = myBag.search(new Analyzable() {

			@Override
			public Person[] analyze(Person[] arr) {
				Person[] temp = new Person[arr.length];
				int count = 0;
				for(int i = 0; i< arr.length; i++) {
					if(arr[i] instanceof Student) {
						if(((Student)arr[i]).getGpa() > 3.5) {
							temp[i] = arr[i];
							count++;
						}
					}
				}
				return Arrays.copyOf(temp, count);
			}
			
		});
		System.out.println("Highest Gpas:");
		System.out.println(Arrays.toString(highestGpasFound));
		System.out.println();
		
		//f. Search for highest ID number utilizing getPersonWithHighestID method
		Person highestID = myBag.getPersonWithHighestID();
		System.out.println("Person with highest ID number:");
		System.out.println(highestID);
		
		
	}

}
