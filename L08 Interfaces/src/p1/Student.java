package p1;

public class Student implements Animal {

	@Override
	public void jump() {
		System.out.println("Jump!");
	}

	@Override
	public void walk() {
		System.out.println("Walk!");
	}

	@Override
	public void eat() {
		System.out.println("Eat!");
	}
	
	public void show() {
		System.out.println("Student Show!");
	}

}
