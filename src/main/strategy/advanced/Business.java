package strategy.advanced;

public class Business extends TaxPayer {
	private final int myNumberOfEmployees;

	public Business(long income, TaxStrategy taxStrategy, int numberOfEmployees) {
		super(income, taxStrategy);
		myNumberOfEmployees = numberOfEmployees;
	}

	public int getNumberOfEmployees() {
		return myNumberOfEmployees;
	}
}