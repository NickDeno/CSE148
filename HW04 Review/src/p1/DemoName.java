package p1;

public class DemoName {

	public static void main(String[] args) {
		Name n1 = new Name("A", "AA");
//		Name n2 = n1; //Shallow copy
		Name n2 = new Name(n1);
		n2.setFirstName("Z");
		n1.setFirstName("M");
		
		System.out.println(n1);
		System.out.println(n2);
	}

}
