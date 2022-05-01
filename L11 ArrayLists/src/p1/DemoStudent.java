package p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DemoStudent {

	public static void main(String[] args) {
		Student s1 = new Student("M", 3.5);
		Student s2 = new Student("Z", 1.5);
		Student s3 = new Student("A", 4.0);
		
		ArrayList<Student> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
//		Collections.sort(list, new Comparator<Student>() {
//
//			@Override
//			public int compare(Student o1, Student o2) {
//				return Double.compare(o1.getGpa(), o2.getGpa());
//			
//			});
		
		Collections.sort(list, (o1, o2) -> Double.compare(o1.getGpa(), o2.getGpa()));
		
		System.out.println(list);

	}

}
