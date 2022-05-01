package p4_and_p5;

import java.util.Arrays;
import java.util.function.Predicate;

import p1.Analyzable;
import p1.GpaAnalyzable;
import p1.IdAnalyzable;
import p1.RankAnalyzable;
import p2.Person;
import p3.Instructor;
import p3.Student;


public class PersonBag implements IdAnalyzable {
	private Person[] arr;
	private int nElems;
	
	public PersonBag(int maxSize) {
		arr = new Person[maxSize];
	}
	
	public void insert(Person person) {
		arr[nElems++] = person;
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
	}
	
	public Person[] search(Predicate<Person> predicate) {
		Person[] temp = new Person[nElems];
		int count = 0;
		for(int i = 0 ; i < nElems; i++) {
			if(predicate.test(arr[i])) {
				temp[count++] = arr[i];
			}
		}
		return Arrays.copyOf(temp, count);
	}
	
	public Person[] search(RankAnalyzable rankAnalyzable) {
		Person[] temp = new Person[nElems];
		int count = 0;
		for(int i = 0 ; i < nElems; i++) {
			if(arr[i] instanceof Instructor) {
				if(rankAnalyzable.analyzeRank((Instructor)arr[i]) != null) {
					temp[count++] = arr[i];
				}
			}
		}
		return Arrays.copyOf(temp,count);
	}
	
	public Person[] search(GpaAnalyzable gpaAnalyzable) {
		Person[] temp = new Person[nElems];
		int count = 0;
		for(int i = 0 ; i < nElems; i++) {
			if(arr[i] instanceof Student) {
				if(gpaAnalyzable.analyzeGpa((Student)arr[i])!= null) {
					temp[count++] = arr[i];
				}
			}
		}
		return Arrays.copyOf(temp,count);
	
	}
	
	public Person[] search(Analyzable analyzable) {
		return analyzable.analyze(arr);
	}

	@Override
	public Person getPersonWithHighestID() {
		Person highestId = arr[0];
		for(int i = 1; i < nElems; i ++) {
			if(Integer.valueOf(arr[i].getId()) > Integer.valueOf(highestId.getId())) {
				highestId = arr[i];
			}
		}
		return highestId;
	}

	
	
	

}
