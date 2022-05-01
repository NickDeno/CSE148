package p5;

import java.util.Arrays;
import java.util.function.Predicate;

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

	@Override
	public Person getPersonWithHighestID() {
		String maxId = arr[0].getId();
		Person maxIdPerson = arr[0];
		
		for(int i = 1; i < nElems; i ++) {
			if(maxId.compareTo(arr[i].getId()) < 0) {
				maxIdPerson = arr[i];
			}
		}
		return maxIdPerson;
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
	
	public Person[] search(Analyzable analyzable) {
		return analyzable.analyze(Arrays.copyOf(arr, nElems));
	}
	

	
	
	

}
