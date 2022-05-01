package p2;

public class Truck extends Veichle {
	private boolean isEV;

	public Truck(String make, String year, double price, Name ownerName, boolean isEV) {
		super(make, year, price, ownerName);
		this.isEV = isEV;
	}

	public Truck(Truck truck) {
		super(truck.getMake(), truck.getYear(), truck.getPrice(), new Name(truck.getOwnerName().getFirstName(), truck.getOwnerName().getLastName()));
		this.isEV = truck.getIsEV();
	}

	public boolean getIsEV() {
		return isEV;
	}

	public void setIsEV(boolean isEV) {
		this.isEV = isEV;
	}
	

	@Override
	public String toString() {
		return "Truck [" + super.toString() + ", isEV=" + isEV + "]";
	}

}
