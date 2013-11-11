package typesystem.wildcardsbounds.lowerboundextends;

import java.util.ArrayList;
import java.util.List;

public class ExtendsIsTypeSafe {
	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(2);
		List<? extends Number> numbers = ints;
		Number number = numbers.get(0);
		assert number.equals(1);
		// won't compile
		// numbers.add(Math.PI);
	}
}
