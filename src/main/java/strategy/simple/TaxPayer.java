package strategy.simple;

public abstract class TaxPayer {
	private final long myIncome;

	protected TaxPayer(long income) {
		myIncome = income;
	}

	public long getIncome() {
		return myIncome;
	}
}
