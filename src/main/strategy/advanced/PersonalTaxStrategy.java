package strategy.advanced;

public class PersonalTaxStrategy implements TaxStrategy<Person> {

	@Override
	public long calculateTax(Person person) {
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
