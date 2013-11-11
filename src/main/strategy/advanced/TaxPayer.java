package strategy.advanced;

public abstract class TaxPayer {
	private final long myIncome;
	private final TaxStrategy myTaxStrategy;

	protected TaxPayer(long income, TaxStrategy taxStrategy) {
		myIncome = income;
		myTaxStrategy = taxStrategy;
	}

	public long getIncome() {
		return myIncome;
	}

	public long getTax() {
		return myTaxStrategy.calculateTax(this);
	}
}
