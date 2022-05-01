package p6;

import java.util.Scanner;

public class Instructor extends Person {
	private String rank;
	public Instructor(Name name, String rank) {
		super(name);
		Scanner input = new Scanner(System.in);
		while(true) {
			try {
				if(!(rank.equalsIgnoreCase("Professor") || rank.equalsIgnoreCase("Assistant Professor") || rank.equalsIgnoreCase("Associate Professor") || rank.equalsIgnoreCase("Lecture"))) {
					throw new IncorrectRankException("Invalid rank. Enter a valid rank");
				}
				break;
			} catch (IncorrectRankException e) {
				System.out.println(e.getMessage());
				rank = input.nextLine();
			}
		}
		this.rank = rank;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		Scanner input = new Scanner(System.in);
		while(true) {
			try {
				if(!(rank.equalsIgnoreCase("Professor") || rank.equalsIgnoreCase("Assistant Professor") || rank.equalsIgnoreCase("Associate Professor") || rank.equalsIgnoreCase("Lecture"))) {
					throw new IncorrectRankException("Invalid rank. Enter a valid rank");
				}
				break;
			} catch (IncorrectRankException e) {
				System.out.println(e.getMessage());
				rank = input.nextLine();
			}
		}
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Instructor [" + super.toString() + ", rank=" + rank + "]";
	}

}
