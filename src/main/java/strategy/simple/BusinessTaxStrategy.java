package strategy.simple;

public class BusinessTaxStrategy implements TaxStrategy {

	@Override
	public long calculateTax(TaxPayer p) {
		Business b = (Business) p;

		double rate;
		if (isSmall(b)) {
			rate = 0.1;
		} else {
			rate = 0.2;
		}
		return (long) (b.getIncome() * rate);
	}

	private boolean isSmall(Business b) {
		return b.getNumberOfEmployees() < 10 && b.getIncome() < 100000;
	}

}
