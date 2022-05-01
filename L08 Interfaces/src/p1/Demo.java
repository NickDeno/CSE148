package p1;

public class Demo {

	public static void main(String[] args) {
		Animal s = new Student();
		s.eat();
		s.walk();
		s.jump();
		
		s.show();
		Animal.drink(); // Since drink method is static, it belongs to Animal interface
	}

}
