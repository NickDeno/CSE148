package p3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		int sentinel = 0;
		double customerSales = 0;
		String customerName = "";
		ArrayList<String> customers = new ArrayList<>();
		ArrayList<Double> sales = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter customer sales and name:");
			while(true) {
				try {
					customerSales = input.nextDouble();
					break;
				} catch(InputMismatchException e) {
					input.nextLine();
					System.out.println("Sales is invalid, enter customer sales as integer/decimal then enter customer name as String:");
				}
			}
			
			if(customerSales == sentinel) {
				break;
			}
			
			while(true) {
				try {
					customerName = input.next();
					break;
				} catch(InputMismatchException e) {
					input.nextLine();
					System.out.println("Name is invalid, enter customer sales as integer/decimal then enter customer name as String:");
				}
			}
			sales.add(customerSales);
			customers.add(customerName);
		}
		System.out.println("Name of best customer:");
		System.out.println(nameOfBestCustomer(sales,customers));
		input.close();
	}

	public static String nameOfBestCustomer(ArrayList<Double> sales, ArrayList<String> customers) {
		double largestSale = 0;
		for(int i = 0; i < sales.size(); i++) {
			if(sales.get(i) > largestSale) {
				largestSale = sales.get(i);
			}
		}
		return customers.get(sales.indexOf(largestSale));
	}
}


