package typesystem.wildcardsbounds.capture;

import java.util.HashSet;
import java.util.Set;

public class IntegerThing implements SomeThing<Integer> {
	private int counter;
	private Integer resultThing;

	@Override
	public Integer createThing() {
		int value = counter;
		counter++;
		return value;
	}

	@Override
	public void doSomething(Integer one, Integer other) {
		// ...here is the magic puzzle solver algorithm...
		assert !one.equals(other);
		resultThing = createThing();
	}

	@Override
	public Set<Integer> getThings() {
		Set<Integer> result = new HashSet<Integer>();
		result.add(resultThing);
		return result;
	}
}
