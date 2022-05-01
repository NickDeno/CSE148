package p2;

// When you have an abstract class with all methods being abstract, the class is and "Interface" instead of class.
// All the methods in interface are abstract and public so there is no need to initiliaze them with "public abstract"
public interface Animal {
	//In an interface, all variables are public, final, and static.
	int count = 10;
	
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

