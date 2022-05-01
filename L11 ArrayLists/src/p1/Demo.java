package p1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

public class Demo {
	// ArrayLists only works for objects, not primitive types
	public static void main(String[] args) {
		// Used to store objects ONLY, Integer, Double, Boolean, String, .....
		// It is mean to store data of the same reference type
		// An arrayList is based on an array, but its sugar coated
		// ArrayLists are created with a default array size of 10
		// It expands and shrinks as needed when you add or remove data
		// Good choice of data structure if the data size is unknown
		// Also a disadvantage to use an ArrayList b/c it is slower then array since you have to copy data from old array list to new one as it expands
		// You could set the initial ArrayList size to whatever u want
		
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(10);
		list1.add(20);
		list1.add(40);
		list1.add(15);
		list1.add(50);
		
		ArrayList<Integer> list2 = new ArrayList<>();
		list1.add(5);
		list1.add(7);
		list1.add(30);
		
		list1.addAll(list2);
		
		Collections.sort(list1);
		System.out.println(list1);
		
		
//		list1.removeIf(t -> t % 20 == 0);
		
//		list1.forEach(t -> System.out.println(t*t));	
		
//		list1.forEach(new Consumer<Integer>() {
//
//			@Override
//			public void accept(Integer t) {
//				System.out.println(t*t);
//				
//			}
//			
//		});
		
//		System.out.println(list1.size()); // .size tells you how many elems there is in array
		
//		System.out.println(list1.containsAll(list2));
		
	}

}
