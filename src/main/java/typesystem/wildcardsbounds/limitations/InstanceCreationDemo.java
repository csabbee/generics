package typesystem.wildcardsbounds.limitations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstanceCreationDemo {
	public static void main(String[] args) {
		testCreateWildcard();
		testCreateBoundedWildcard();
		testUseWildcard();
		testCreateNestedWildcard();
	}

	// you cannot create an instance parameterised with a wildcard
	// there would be no point: what could you insert into it,
	// what could you retrieve?
	private static void testCreateWildcard() {
		// A list of an unknown type...
		// List<?> list = new ArrayList<?>();
	}

	// Even if bounded, the type is still unknown
	private static void testCreateBoundedWildcard() {
		// List<? extends Number> list = new ArrayList<? extends Number>();

	}

	private static void testUseWildcard() {
		List<String> text = new ArrayList<String>(
				Arrays.asList("hello", "world"));
		List<Integer> ints = new ArrayList<Integer>(Arrays.asList(1, 2, 3));

		// it's OK to assign an existing object to a wildcard parameter
		useWildcard(text, ints);

		// "hello", "world", null
		assert text.size() == 3;

		// 1, 2, 3, null
		assert ints.size() == 4;
	}

	private static void useWildcard(List<?> unknown,
			List<? extends Number> numbers) {
		// can insert null - the only value compatible with any type
		unknown.add(null);
		numbers.add(null);

		// the only variable type that can reference an instance of any type
		Object object = unknown.get(0);
		assert "hello".equals(object);

		// A Number variable can hold a reference to any subtype of Number
		Number number = numbers.get(0);
		assert Integer.valueOf(1).equals(number);
	}

	private static void testCreateNestedWildcard() {
		List<List<?>> listOfLists = new ArrayList<List<?>>();

		listOfLists.add(Arrays.asList("epam", "rulez"));
		listOfLists.add(Arrays.<Number> asList(1, 2.2));

		List<?> firstList = listOfLists.get(0);
		assert "epam".equals(firstList.get(0));

		List<?> otherList = listOfLists.get(1);
		assert Integer.valueOf(1).equals(otherList.get(0));
	}
}
