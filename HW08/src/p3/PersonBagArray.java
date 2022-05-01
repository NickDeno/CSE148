package p3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class PersonBagArray {
	private Person[] arr;
	private int nElems;
	
	public PersonBagArray(int maxSize) {
		arr = new Person[maxSize];
		nElems = 0;
	}
	
	public Person[] getArr() {
		return arr;
	}

	public void insert(Person person) {
		arr[nElems++] = person;
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	public Person[] search(Predicate<Person> predicate) {
		Person[] temp = new Person[nElems];
		int count = 0;
		for(int i = 0; i <nElems; i++) {
			if(predicate.test(arr[i])) {
				temp[count++] = arr[i];
			}
		}
		return Arrays.copyOf(temp, count);
	}
	
	public Person[] remove(Predicate<Person> predicate) {
		Person[] temp = new Person[nElems];
		int count = 0;
		for(int i = 0; i <nElems; i++) {
			if(predicate.test(arr[i])) {
				temp[count++] = arr[i];
				
				for(int j = i; j < nElems-1; j++) {
					arr[j] = arr[j+1];
				}
				nElems--;
				i--;
			}
		}
		return Arrays.copyOf(temp, count);
	}
	
	public Person[] sort(Person[] arr) throws CloneNotSupportedException {
		Person[] temp = new Person[nElems];
		for(int i = 0; i < nElems; i++) {
			temp[i] = arr[i].clone();
			temp[i].setName(arr[i].getName().clone());
		}
		Arrays.sort(temp);
		return temp;
		
	}
	
}
