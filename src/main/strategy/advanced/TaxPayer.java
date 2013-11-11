package strategy.advanced;

public abstract class TaxPayer<P extends TaxPayer<P>> {
	private final long myIncome;
	private final TaxStrategy<P> myTaxStrategy;

	protected TaxPayer(long income, TaxStrategy<P> taxStrategy) {
		myIncome = income;
		myTaxStrategy = taxStrategy;
	}

	public long getIncome() {
		return myIncome;
	}

	public long getTax() {
		return myTaxStrategy.calculateTax(getThis());
	}

    protected abstract P getThis();
}
