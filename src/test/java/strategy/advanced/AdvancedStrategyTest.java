package strategy.advanced;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AdvancedStrategyTest {
	private final PersonalTaxStrategy personalTaxStrategy = new PersonalTaxStrategy();
	private final BusinessTaxStrategy businessTaxStrategy = new BusinessTaxStrategy();
	private Person person;
	private Business business;

	@Test
	public void testCorrectStrategy() {
		person = new Person(10_000, personalTaxStrategy, 2);
		business = new Business(30_000, businessTaxStrategy, 3);
		assertThat(person.getTax(), is(500L));
		assertThat(business.getTax(), is(3_000L));
	}

	@Test
	public void testIncorrectStrategyForPerson() {
		person = new Person(10_000, businessTaxStrategy, 2);
		assertThat(person.getTax(), is(0L));
	}
}
