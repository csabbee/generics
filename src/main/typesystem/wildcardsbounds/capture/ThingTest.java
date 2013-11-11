package typesystem.wildcardsbounds.capture;

import java.util.Set;

public class ThingTest {
	public void test(SomeThing<?> underTest) {
		doTest(underTest);
	}

	private static <T> void doTest(SomeThing<T> underTest) {
		T thingA = underTest.createThing();
		T thingB = underTest.createThing();
		assert !thingA.equals(thingB);
		underTest.doSomething(thingA, thingB);
		Set<T> result = underTest.getThings();
		assert result.size() == 1;
		assert !result.contains(thingA);
	}
}
