package p1;

// When you have an abstract class with all methods being abstract, the class is and "Interface" instead of class.
// All the methods in interface are abstract and public so there is no need to initiliaze them with "public abstract"
public interface Animal {
	
	void jump();
	
	void walk();
	
	void eat();
	
	//Exceptions. If method has default or static in the signature.
	public default void show() {
		System.out.println("Show!");
	}
	
	public static void drink() {
		System.out.println("Drink!");
	}
}
