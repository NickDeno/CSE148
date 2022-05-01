package p1;

import java.util.ArrayList;


public class Demo {

	public static void main(String[] args) {
		// 1.
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(3);
		list1.add(5);
		list1.add(7);
		
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(4);
		list2.add(6);
		list2.add(8);
		
		System.out.println(merge(list1,list2));
		
	}
	
	public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
		ArrayList<Integer> c = new ArrayList<>();
		for(int i = 0; i < Math.max(a.size(), b.size()); i++) {
			if(i < a.size()) {
				c.add(a.get(i));
			}
			if(i < b.size()) {
				c.add(b.get(i));
			}
		}
		return c;
	}
}


