package p5;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PersonBag {
	private ArrayList<Person> arr;

	public PersonBag(int maxSize) {
		arr = new ArrayList<>(maxSize);
	}

	public void insert(Person person) {
		arr.add(person);
	}

	public void display() {
		for(int i = 0; i< arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
	
	public ArrayList<Person> search(Predicate<Person> predicate){
		ArrayList<Person> temp = new ArrayList<Person>(arr.size());
		for(Person person: arr) {
			if(predicate.test(person)) {
				temp.add(person);
			}
		}
		temp.trimToSize();
		return temp;
	}
	
	public ArrayList<Person> remove(Predicate<Person> predicate){
		ArrayList<Person> temp = new ArrayList<Person>(arr.size());
		for(Person person: arr) {
			if(predicate.test(person)) {
				temp.add(person);
				arr.remove(person);
			}
		}
		temp.trimToSize();
		return temp;
		
		
	}
	
}
