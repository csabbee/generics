package strategy.advanced;

public class PersonalTaxStrategy implements TaxStrategy {

	@Override
	public long calculateTax(TaxPayer taxPayer) {
		Person person = (Person) taxPayer;
		return (long) (person.getIncome() * 0.1 * getTaxAdjustment(person));
	}

	private double getTaxAdjustment(Person p) {
		double adjustment;
		int children = p.getNumberOfChildren();
		if (children > 0) {
			adjustment = 1.0d / children;
		} else {
			adjustment = 1.0d;
		}
		return adjustment;
	}

}
