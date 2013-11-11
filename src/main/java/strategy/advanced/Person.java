package strategy.advanced;

public class Person extends TaxPayer {
	private final int myNumberOfChildren;

	public Person(long income, TaxStrategy taxStrategy, int numberOfChildren) {
		super(income, taxStrategy);
		myNumberOfChildren = numberOfChildren;
	}

	public int getNumberOfChildren() {
		return myNumberOfChildren;
	}
}
