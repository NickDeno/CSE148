package p3;

import java.util.Arrays;

public class VeichleBag {
	private Veichle[] arr;
	private int nElems;
	
	public VeichleBag(int maxSize) {
		arr = new Veichle[maxSize];
		nElems = 0;
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
			if(arr[i] instanceof Car) {
				if(((Car)arr[i]).getDoors() == doors) {
					temp[count++] = (Car)arr[i];
				}
				
			}
		}
		return Arrays.copyOf(temp, count);	
	}
	
	public Veichle[] removeNonEv() {
		Veichle[] temp = new Veichle[nElems];
		int count = 0;
		
		for(int i = 0; i < nElems; i++) {
			if(arr[i] instanceof Truck) {
				if(((Truck)arr[i]).getIsEV() == false) {
					temp[count++] = arr[i];
					
					for (int j = i; j < nElems - 1; j++) {
						arr[j] = arr[j + 1];
					}
					nElems--;
					i--;
				}
			}
		}
		return Arrays.copyOf(temp, count);
		
	}
}
