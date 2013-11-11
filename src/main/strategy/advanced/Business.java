package strategy.advanced;

public class Business extends TaxPayer<Business> {
	private final int myNumberOfEmployees;

	public Business(long income, TaxStrategy<Business> taxStrategy, int numberOfEmployees) {
		super(income, taxStrategy);
		myNumberOfEmployees = numberOfEmployees;
	}

	public int getNumberOfEmployees() {
		return myNumberOfEmployees;
	}

    @Override
    protected Business getThis() {
        return this;
    }
}