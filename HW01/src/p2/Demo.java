package p2;

import p1.Student;

public class Demo {

	public static void main(String[] args) {
		Student s1 = new Student("Jack", 23, "631-567-4437", 3.5);
		Student s2 = new Student("John", 19, "631-678-5684", 4.0);
		Student s3 = new Student("Joe", 21, "631-978-9368", 3.9);
		
		Student studentArr[] = new Student[10];
		studentArr[0] = s1;
		studentArr[1] = s2;
		studentArr[2] = s3;
		
		showStudents(studentArr);

	}
	
	private static void showStudents(Student arr[]) {
		System.out.printf("%-5s%6s%14s%5s\n", "NAME", "AGE", "PHONE NUMBER", "GPA");
		
		for(int i = 0; i<arr.length && arr[i] != null; i++) {
			System.out.printf("%-5s%5d%15s%5.1f\n", arr[i].getName(), arr[i].getAge(), arr[i].getPhone(), arr[i].getGpa());
		}
	}

}
