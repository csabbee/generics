package typesystem.wildcardsbounds.limitations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MethodCallDemo {
	private static final String HELLO = "hello";

	private static <T> List<T> getCopies(T item, int nCopies) {
		List<T> result = new ArrayList<T>(nCopies);
		for (int i = 0; i < nCopies; i++) {
			result.add(item);
		}
		return result;
	}

	public static void main(String[] args) {
		// you can call with an Object or any other type
		List<String> strings = getCopies(HELLO, 2);
		List<Object> objects = MethodCallDemo.<Object> getCopies(HELLO, 2);
		assert strings.equals(objects);
		assert strings.size() == 2;
		assert strings.get(0).equals(strings.get(1));
		assert HELLO.equals(strings.get(0));

		// you can't invoke with unknown type
		// List<?> unknowns = getCopies.<?>(text);

		// not even with a bounded wildcard
		// MethodCallDemo.<? extends Serializable>getCopies(HELLO, 2);
		// MethodCallDemo.<? super String>getCopies(HELLO, 2);

		// you can invoke it with nested wildcards
		List<?> unknowns = objects;
		List<? extends Serializable> sers = strings;
		List<List<?>> listOfUnknownLists = MethodCallDemo.<List<?>> getCopies(
				unknowns, 2);
		List<List<? extends Serializable>> listOfSerLists = MethodCallDemo
				.<List<? extends Serializable>> getCopies(sers, 2);
		assert listOfUnknownLists.equals(listOfSerLists);
	}
}
