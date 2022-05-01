package p7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

public class PersonBagList { 
	private ArrayList<Person> arr;

	public PersonBagList(int maxSize) {
		arr = new ArrayList<>(maxSize);
	}
	
	public ArrayList<Person> getArr() {
		return arr;
	}
	
	public void insert(Person person) {
		arr.add(person);
	}
	
	public void display() {
		for(Person p : arr) {
			System.out.println(p);
		}
	}
	
	public ArrayList<Person> search(Predicate<Person> predicate){
		ArrayList<Person> temp = new ArrayList<Person>(arr.size());
		for(Person p : temp) {
			if(predicate.test(p)) {
				temp.add(p);
			}
		}
		temp.trimToSize();
		return temp;
	}
	
	public ArrayList<Person> remove(Predicate<Person> predicate){
		ArrayList<Person> temp = new ArrayList<Person>(arr.size());
		for(Person p : temp) {
			if(predicate.test(p)) {
				temp.add(p);
				arr.remove(p);
			}
		}
		temp.trimToSize();
		return temp;
	}
	
	public ArrayList<Person> sort(ArrayList<Person> arr, Comparator<Person> comparator) throws CloneNotSupportedException {
		ArrayList<Person> temp = new ArrayList<Person>(arr.size());
		for(Person p: temp) {
			temp.add(p.clone());
			p.setName(p.getName().clone());
		}
		Collections.sort(temp, comparator);
		return temp;
	}
	
	
	
}
