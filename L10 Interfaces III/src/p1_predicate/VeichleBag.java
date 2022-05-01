package p1_predicate;

import java.util.Arrays;
import java.util.function.Predicate;

public class VeichleBag {
	private Veichle[] arr;
	private int nElems;
	
	public VeichleBag(int maxSize) {
		arr = new Veichle[maxSize];
	}
	
	public void insert(Veichle veichle) {
		arr[nElems++] = veichle;
	}
	
	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
	}
	
	public Veichle[] search(Predicate<Veichle> predicate) {
		Veichle[] temp = new Veichle[nElems];;
		int count = 0;
		
		for(int i = 0; i < nElems; i++) {
			if(predicate.test(arr[i])) {
				temp[count++] = arr[i];
			}
		}
		return Arrays.copyOf(temp, count);
	}
	
	public Veichle[] searchByMake(String make) {
		Veichle temp[] = new Veichle[nElems];
		int count = 0;
		
		for (int i = 0; i < nElems; i++) {
			if (arr[i].getMake().equals(make)) {
				temp[count++] = arr[i];
			}
		}
		return Arrays.copyOf(temp, count);
	}
	
	public Veichle[] searchByDoors(int doors) {
		Veichle temp[] = new Veichle[nElems];
		int count = 0;
		
		for(int i = 0; i < nElems; i++) {
			if(arr[i] instanceof Car && ((Car)arr[i]).getDoors() == doors) {
				temp[count++] = (Car)arr[i];
			}
		}
		return Arrays.copyOf(temp, count);	
	}
	
	public Veichle[] removeNonEv() {
		Veichle[] temp = new Veichle[nElems];
		int count = 0;
		
		for(int i = 0; i < nElems; i++) {
			if(arr[i] instanceof Truck && ((Truck)arr[i]).getIsEV() == false) {
				temp[count++] = arr[i];
					
				for (int j = i; j < nElems - 1; j++) {
					arr[j] = arr[j + 1];
				}
				nElems--;
				i--;
			}
		}
		return Arrays.copyOf(temp, count);
		
	}
}
