package strategy.simple;

public class PersonalTaxStrategy implements TaxStrategy {

	public long calculateTax(TaxPayer tp) {
		Person person = (Person) tp;
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
