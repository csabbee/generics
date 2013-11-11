package strategy.advanced;

public class BusinessTaxStrategy implements TaxStrategy<Business> {
	@Override
	public long calculateTax(Business business) {
		double rate;
		if (isSmall(business)) {
			rate = 0.1;
		} else {
			rate = 0.2;
		}
		return (long) (business.getIncome() * rate);
	}

	private boolean isSmall(Business b) {
		return b.getNumberOfEmployees() < 10 && b.getIncome() < 100000;
	}

}
