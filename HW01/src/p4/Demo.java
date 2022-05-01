package p4;

import java.util.Random;

public class Demo {

	public static void main(String[] args) {
		Random rand = new Random();
		Book bookList[] = new Book[1000];
		System.out.printf("%-10s%-12s%-6s\n", "SERIAL", "TITLE", "PRICE");
		
		//Creates 1000 books and prints them
		for(int i = 0; i< 1000;i++) {
			bookList[i] = new Book(bookTitle(), 99.99 * rand.nextDouble());
			System.out.printf("%-10d%-12s$%-6.2f\n", i+1, bookList[i].getTitle(), bookList[i].getPrice());
		}	
	}
	
	public static String bookTitle() {
		Random rand = new Random();
		String title = "";
		
		for(int i = 0;i< rand.nextInt(5)+ 5;i++) {
			title += (char)(rand.nextInt(26) + 'A');
		}
		return title;	
	}

}
