package p4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		int sentinel = 0;
		double customerSales = 0;
		String customerName = "";
		ArrayList<Customer> customers = new ArrayList<>();
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
			customers.add(new Customer(customerName, customerSales));
		}
		System.out.println("Name of best customer:");
		System.out.println(nameOfBestCustomer(customers));
		input.close();
	}
	
	public static String nameOfBestCustomer(ArrayList<Customer> customers) {
		Customer maxSaleCustomer = customers.get(0);
		for(int i = 1; i < customers.size(); i++) {
			if(customers.get(i).getSales() > maxSaleCustomer.getSales()) {
				maxSaleCustomer = customers.get(i);
			}
		}
		return maxSaleCustomer.getName();
	}		
}


