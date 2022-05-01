package p1;

public class Demo {

	public static void main(String[] args) {
		BookBag theBag = new BookBag(10);
		theBag.insert(new Book("A", 10.99));
		theBag.insert(new Book("B", 1.99));
		theBag.insert(new Book("C", 101.99));
		theBag.display();
	}

}
