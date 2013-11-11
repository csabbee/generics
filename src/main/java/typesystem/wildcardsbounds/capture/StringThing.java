package typesystem.wildcardsbounds.capture;

import java.util.HashSet;
import java.util.Set;

public class StringThing implements SomeThing<String> {
	private int counter;

	@Override
	public String createThing() {
		counter++;
		return String.valueOf(counter);
	}

	@Override
	public void doSomething(String one, String other) {
		// ...here is the magic puzzle solver algorithm...
		assert !one.equals(other);
	}

	@Override
	public Set<String> getThings() {
		Set<String> result = new HashSet<String>();
		// ...fill result set...
		return result;
	}
}
