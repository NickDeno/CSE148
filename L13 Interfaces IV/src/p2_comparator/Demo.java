package p2_comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Demo {

	public static void main(String[] args) {
		Student s1 = new Student("A", 4.0);
		Student s2 = new Student("Z", 2.5);
		Student s3 = new Student("M", 1.5);
		Student[] arr = {s1, s2, s3};
		
//		Arrays.sort(arr, new Comparator<Student>() {
//
//			@Override
//			public int compare(Student o1, Student o2) {
//				return o1.getName().compareTo(o2.getName());
//			}
//			
//		});
		Arrays.sort(arr, (o1, o2) -> o1.getName().compareTo(o2.getName()));
		System.out.println(Arrays.toString(arr));
		
		
		ArrayList<Student> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
//		Collections.sort(list, new Comparator<Student>() {
//
//			@Override
//			public int compare(Student o1, Student o2) {
//				return o1.getName().compareTo(o2.getName());
//			}
//			
//		});
		Collections.sort(list, (o1, o2) -> o1.getName().compareTo(o2.getName()) );
		System.out.println(list);
	}

}
