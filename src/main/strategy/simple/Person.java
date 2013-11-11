package strategy.simple;

public class Person extends TaxPayer {
	private final int myNumberOfChildren;
	public Person(long income, int numberOfChildren) {
		super(income);
		myNumberOfChildren = numberOfChildren;
	}
	public int getNumberOfChildren() {
		return myNumberOfChildren;
	}
}
