package p2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExportAndImport {
	
	public static String[] importBooks(String fileName) {
		int lineCnt = 0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			while(br.readLine() != null) {
				lineCnt++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String textArr[] = new String[lineCnt];
		
		try {
			br = new BufferedReader(new FileReader(fileName));
			for(int i = 0; i < textArr.length; i++) {
				textArr[i] = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return textArr;
	}
	
	public static void exportBooks(String[] bookArr, String fileName) {
		try {
			FileWriter fw = new FileWriter(fileName);
			PrintWriter pw = new PrintWriter(fw);
			for(int i = 0 ; i < bookArr.length; i++) {
				double randNum = Math.random() * 199.9;
				pw.println(bookArr[i] + ": price: " + Math.round(randNum * 100.0)/100.0);
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done exporting.");
		
	}
}
