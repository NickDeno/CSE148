package p5;

import java.util.Scanner;

public class Student extends Person {
	private double gpa;

	public Student(Name name, double gpa) {
		super(name);
		Scanner input = new Scanner(System.in);
		while(true) {
			try {
				if(gpa > 4.0) {
					throw new IncorrectGpaException("Gpa is too big. Enter a valid gpa: ");
				}
				break;
			} catch (IncorrectGpaException e) {
				System.out.println(e.getMessage());
				gpa = input.nextDouble();
			}
		}
		
		
		while(true) {
			try {
				if(gpa < 0.0) {
					throw new IncorrectGpaException("Gpa is too small. Enter a valid gpa: ");
				}
				break;
			} catch (IncorrectGpaException e) {
				System.out.println(e.getMessage());
				gpa = input.nextDouble();
			}
		}
		this.gpa = gpa;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		Scanner input = new Scanner(System.in);
		while(true) {
			try {
				if(gpa > 4.0) {
					throw new IncorrectGpaException("Gpa is too big. Enter a valid gpa: ");
				}
				break;
			} catch (IncorrectGpaException e) {
				System.out.println(e.getMessage());
				gpa = input.nextDouble();
			}
		}
		
		while(true) {	
			try {
				if(gpa < 0.0) {
					throw new IncorrectGpaException("Gpa is too small. Enter a valid gpa: ");
				}
				break;
			} catch (IncorrectGpaException e) {
				System.out.println(e.getMessage());
				gpa = input.nextDouble();
			}
		}
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [" + super.toString() + ", gpa=" + gpa + "]";
	}

}
