package typesystem.wildcardsbounds.upperboundsuper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContraVariantSubtypingDemo {
	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<Integer>(Arrays.asList(1, 2, 3));

		// Integer is accepted as 'supertype' of itself
		List<? super Integer> superList = ints;
		assert superList.size() == 3;

		List<Number> numbers = new ArrayList<Number>(Arrays.<Number> asList(1, 2.0, null));
		// assignment is OK, so List<Number> is a subtype of List<? super Integer>
		superList = numbers;
		assert superList.size() == 3;
		// cannot insert just any Number (e.g. a Double), superList points at a List of an unknown supertype of Integer
		// Number aDouble = 1.1;
		// superList.add(aDouble);

		// it's safe to insert an Integer
		superList.add(1);
		assert superList.size() == 4;

		List<Object> objects = new ArrayList<Object>(Arrays.<Object>asList(1, "hello"));
		superList = objects;
		assert superList.size() == 2;

		superList.add(null);
		superList.add(3);
		assert superList.size() == 4;

		// type-safe, cannot corrupt Integer list
		// superList.add("hi");
		// superList.add(new Object());

		// Double is not a supertype of Integer
		// List<Double> doubles = Arrays.asList(1.1, 2.2);
		// superList = doubles;
		// assert superList.size() == 3;
	}
}
