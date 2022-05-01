package p1;

public class BookBag {
	private Book[] arr;
	private int nElems; //To track the number of actual book objects in array
	
	public BookBag(int maxSize) {
		arr = new Book[maxSize];
		nElems = 0;
	}
	
	public void insert(Book book) {
		arr[nElems++] = book;
	}
	
	public void display() {
		for(int i = 0; i< nElems; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
	}
}
