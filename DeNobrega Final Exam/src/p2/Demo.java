package p2;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		String[] titles = ExportAndImport.importBooks("bookData/textbook_titles.txt");
		System.out.println(Arrays.toString(titles));
		
		ExportAndImport.exportBooks(titles, "bookData/exported_books.txt");
		
	}

}
