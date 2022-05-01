package p2_contract;

public class Calculator implements Computable {

	@Override
	public double add(double n1, double n2) {
		return n1 + n2;
	}

	@Override
	public double subtract(double n1, double n2) {
		return n1 - n2;
	}
	
}
