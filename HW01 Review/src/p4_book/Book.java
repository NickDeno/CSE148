package p4_book;

public class Book {
	private String title; // Instance variable
	private double price;

	public Book(String title, double price) {
		super();
		this.title = title; // Assignment: assign value on the left to the variable on the right
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}

}
