package p6;

import p5.Student;

public class StudentBag {
	private Student[] arr;
	private int nElems;
	
	public StudentBag(int maxSize) {
		arr = new Student[maxSize];
		nElems = 0;
	}
	
	public Student searchById(String id) {
		int i = 0;
		for(i = 0; i < nElems; i++) {
			if(arr[i].getId().equals(id)) {
				return arr[i];
			}
		}
		return null;
	}	
	
	public void insert(Student student) {
		arr[nElems++] = student;
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
	}
}
