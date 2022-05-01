package p1_intro;

public class Instructor extends Person {
	private String rank;
	
	public Instructor(Name name, String rank) {
		super(name);
		this.rank = rank;
	}
	
	public Instructor(Instructor instructor) {
		super(instructor);
		this.rank = instructor.rank;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Instructor [" + super.toString() + ", rank=" + rank + "]";
	}

	
	
	
}
