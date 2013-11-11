package strategy.simple;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SimpleStrategyTest {
	@Test
	public void testPerson() {
		Person p = new Person(10_000, 2);
		PersonalTaxStrategy personalTaxStrategy = new PersonalTaxStrategy();
		assertThat(personalTaxStrategy.calculateTax(p), is(500L));
	}

	@Test
	public void testBusiness() {
		Business b = new Business(30_000, 3);
		BusinessTaxStrategy businessTaxStrategy = new BusinessTaxStrategy();
		assertThat(businessTaxStrategy.calculateTax(b), is(3_000L));
	}

	@Test
	public void testMixed() {
		Person p = new Person(10_000, 2);
		BusinessTaxStrategy businessTaxStrategy = new BusinessTaxStrategy();
		assertThat(businessTaxStrategy.calculateTax(p), is(3_000L));
	}
}
