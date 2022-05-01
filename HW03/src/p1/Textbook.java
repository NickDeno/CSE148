package p1;

public class Textbook {
	private String title;
	private String isbn;
	private String authorName;
	private double price;

	public Textbook(String title, String isbn, String authorName, double price) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.authorName = authorName;
		this.price = price;
	}

	public Textbook(String title, String authorName, double price) {
		super();
		this.title = title;
		this.authorName = authorName;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Textbook [title=" + title + ", isbn=" + isbn + ", authorName=" + authorName + ", price=" + price + "]";
	}

}
