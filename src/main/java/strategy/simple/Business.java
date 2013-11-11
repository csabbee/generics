package strategy.simple;

public class Business extends TaxPayer {
	private final int myNumberOfEmployees;
	public Business(long income, int numberOfEmployees) {
		super(income);
		myNumberOfEmployees = numberOfEmployees;
	}
	public int getNumberOfEmployees() {
		return myNumberOfEmployees;
	}
}
