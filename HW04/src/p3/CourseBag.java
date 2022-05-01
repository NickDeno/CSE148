package p3;

import java.util.Arrays;

public class CourseBag {
	
	private Course[] arr;
	private int nElems;
	
	public CourseBag(int maxSize) {
		arr = new Course[maxSize];
		nElems = 0;
	}
	
	public void insert(Course course) {
		arr[nElems++] = new Course(course);
	}
	
	public void display() {
		for(int i = 0; i< nElems; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
	}
	
	public Course searchByCourseNumber(String courseNumber) {
		for (int i = 0; i < nElems; i++) {
			if (arr[i].getCourseNumber().equals(courseNumber)) {
				return new Course(arr[i]);
			}
		}
		return null;
	}
	
	public Course removeByCourseNumber(String courseNumber) {
		int i = 0;
		for (i = 0; i < nElems; i++) {
			if (arr[i].getCourseNumber().equals(courseNumber)) {
				break;
			}
		}

		if (i == nElems) { // No match found
			return null;
		} else {
			Course temp = new Course(arr[i]);
			for (int j = i; j < nElems - 1; j++) {
				arr[j] = arr[j + 1];
			}
			nElems--;
			return temp;
		}
	}
	
	public Course[] searchByCredits(int credits) {
		 Course[] coursesFound = new Course[nElems];
		 int count = 0;
		 
		 for(int i = 0; i < nElems; i++) {
			 if(arr[i].getCredits() == credits) {
				 coursesFound[count++] = new Course(arr[i]);
			 }
		 }
		 return Arrays.copyOf(coursesFound, count);

	 }
	
	public Course[] removeByCredits(int credits) {
		Course[] coursesRemoved = new Course[nElems];
		int count = 0;
		for(int i = 0; i< nElems; i++) {
			if(arr[i].getCredits() == credits) {
				coursesRemoved[count++] = new Course(arr[i]);
				for(int j = i; j< nElems-1; j++) {
					arr[j] = arr[j+1];
				}
				i--;
				nElems--; //Since everytime the credits match, you remove the courses so nElems has to be decremented by one.
			}
			
		}
		
		return Arrays.copyOf(coursesRemoved, count);
	}
}
