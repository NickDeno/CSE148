package p2;

public class Truck extends Veichle {
	private boolean isEV;

	public Truck(String make, String year, double price, Name ownerName, boolean isEV) {
		super(make, year, price, ownerName);
		if(isEV) {
			setPrice(price * 0.9);
		}
		else {
			setPrice(price * 1.1);
		}
		this.isEV = isEV;
	}

	public Truck(Truck truck) {
		//this(truck.getMake(), truck.getYear(), truck.getPrice(), new Name(truck.getOwnerName()), truck.isEV);
		super(truck.getMake(), truck.getYear(), truck.getPrice(), new Name(truck.getOwnerName()));
		this.isEV = truck.isEV;
	}

	public boolean getIsEV() {
		return isEV;
	}

	public void setIsEV(boolean isEV) {
		if(this.isEV && !isEV) {
			setPrice(getPrice() * 1.11111);
			this.isEV = isEV;
		}
		
		if(!this.isEV && isEV) {
			setPrice(getPrice() * 0.9);
			this.isEV = isEV;
		}
	}

	@Override
	public String toString() {
		return "Truck [" + super.toString() + ", isEV=" + isEV + "]";
	}

}
