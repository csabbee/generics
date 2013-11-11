package typesystem.wildcardsbounds.getput;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PutDemo {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		List<Integer> ints = new ArrayList<Integer>();
		List<Number> numbers = new ArrayList<Number>();
		List<Serializable> sers = new ArrayList<Serializable>();
		List<Object> objects = new ArrayList<Object>();

		List<String> hello3 = Arrays.asList("hello", "hello", "hello");
		assert appendCopies(strings, "hello", 3).equals(hello3);
		assert appendCopies(sers, "hello", 3).equals(hello3);
		assert appendCopies(objects, "hello", 3).equals(hello3);

		objects.clear();

		List<Number> list111 = Arrays.<Number> asList(1, 1, 1);
		assert appendCopies(ints, 1, 3).equals(list111);
		assert appendCopies(numbers, 1, 3).equals(list111);
		assert appendCopies(objects, 1, 3).equals(list111);

		// List<Double> doubles = new ArrayList<Double>();
		// compile-time error: Double is not supertype of Integer
		// assert appendCopies(doubles, 1, 3).equals(list123);

		List<? extends Number> unknowNumberList = ints;

		// you can read from it, though:
		Number firstElement = unknowNumberList.get(0);
		assert firstElement.equals(1);

		ints.clear();

		// can't put numbers into a list of an unknown subtype
		// can use a cast to (List<Integer>), but that will give a warning
		// assert appendCopies(unknowNumberList, 1, 3).equals(list111);

		// try direct modification, it will fail
		// unknowNumberList.add(1);
		// unknowNumberList.add(2.2);
	}

	// For inserting (putting) values, you may use a super wildcard
	// We'll be 'inserting values into' add() (calling the method with parameters)
	private static <T> List<? super T> appendCopies(List<? super T> list,
			T item, int nCopies) {
		for (int i = 0; i < nCopies; i++) {
			list.add(item);
		}
		return list;
	}

}

