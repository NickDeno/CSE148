package model;

import java.io.Serializable;

public class PersonBag implements Serializable {
	private Person[] arr;
	private int nElems;
	
	public PersonBag(int maxSize) {
		arr = new Person[maxSize];
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
