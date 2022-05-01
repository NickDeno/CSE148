package hw5;

import java.util.Arrays;

public class PersonBag {
	private Person[] arr;
	private int nElems;

	public PersonBag(int maxSize) {
		arr = new Person[maxSize];
		nElems = 0;
	}

	public void insert(Person person) {
		arr[nElems++] = person;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
	}

	public Person[] searchByLastName(String lastName) {
		Person[] temp = new Person[nElems];
		int count = 0;

		for (int i = 0; i < nElems; i++) {
			if (arr[i].getName().getLastName().equals(lastName)) {
				temp[count++] = arr[i];
			}
		}
		return Arrays.copyOf(temp, count);
	}

	public Person searchById(String id) {
		for (int i = 0; i < nElems; i++) {
			if (arr[i].getId().equals(id)) {
				return arr[i];
			}
		}
		return null;
	}

	public Person[] removeByLastName(String lastName) {
		Person[] temp = new Person[nElems];
		int count = 0;
		
		for(int i = 0; i < nElems; i++) {
			if(arr[i].getName().getLastName().equals(lastName)) {
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

	public Person removeById(String id) {
		int i = 0;
		for(; i < nElems; i++) {
			if(arr[i].getId().equals(id)) {
				break;
			}
		}
			if(i == nElems) {
				return null;
			}
			else {
				Person temp = arr[i];
				for(int j = i; j< nElems-1; j++) {
					arr[j] = arr[j + 1];
				}
				nElems--;
				return temp;
			}
		
	}
}
