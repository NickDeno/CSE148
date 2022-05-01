package p2;

import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(5);
		list1.add(7);
		list1.add(1);
		list1.add(3);
		
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(8);
		list2.add(4);
		list2.add(6);
		
		System.out.println(mergeSorted(list1,list2));
	}
	
	public static ArrayList<Integer> mergeSorted(ArrayList<Integer> a, ArrayList<Integer> b){
		ArrayList<Integer> c = new ArrayList<>();
		int aIdx = 0;
		int bIdx = 0;
		while(aIdx < a.size() || bIdx < b.size()) {
			if(aIdx < a.size() && bIdx < b.size()) {
				if(a.get(aIdx) < b.get(bIdx)) {
					c.add(a.get(bIdx++));
				}else {
					c.add(b.get(bIdx++));
				}
			}else if(aIdx >= a.size()) {
				c.add(b.get(bIdx++));
			}else if(bIdx >= b.size()){
				c.add(a.get(aIdx++));
			}
		}
		return c;
	}
}
	
