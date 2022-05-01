package p4_book;

public class Demo {

	private static final int BOOKS_TO_CREATE = 1000;
	private static final String FORMAT = "%-10d%10s%10.2f\n";
	
	public static void main(String[] args) {
		BookHelper.printFormattedBooks(BOOKS_TO_CREATE,FORMAT);
	}
	
}
