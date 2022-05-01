package model;

import java.io.Serializable;

public class PersonBag implements Serializable {
	private Person[] arr;
	private int nElems;
	private static PersonBag personBag;
	
	private PersonBag(int maxSize) {
		arr = new Person[maxSize];
	}
	
	public static PersonBag getPersonBag(int maxSize) {
		if(personBag == null) {
			personBag = new PersonBag(maxSize);
		}
		return personBag;
	}
	
	public void insert(Person person) {
		arr[nElems++] = person; 
	}
	
	public void display() {
		for(int i = 0; i< nElems; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public int getnElems() {
		return nElems;
	}
}
