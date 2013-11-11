package typesystem.wildcardsbounds.getput;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetDemo {
	public static void main(String[] args) {
		getDemo();
		putDemo();
	}

	private static void getDemo() {
		List<Integer> ints = Arrays.asList(1, 2, 3);
		List<Double> doubles = Arrays.asList(4.4, 5.5, 6.6);
		List<Number> expectedResult = Arrays.<Number> asList(1, 2, 3, 4.4, 5.5,
				6.6);
		assert mergeLists(ints, doubles).equals(expectedResult);
		assert betterMergeLists(ints, doubles).equals(expectedResult);
	}

	private static List<Number> mergeLists(List<Integer> ints,
			List<Double> doubles) {
		List<Number> numbers = new ArrayList<Number>();
		// boolean addAll(Collection<? extends E> c);
		// For extracting values, you may use an extends wildcard
		// we'll be extracting values from (using return values of methods)
		// in those collections
		numbers.addAll(ints);
		numbers.addAll(doubles);
		return numbers;
	}

	private static <T> List<T> betterMergeLists(List<? extends T>... lists) {
		List<T> resultList = new ArrayList<T>();
		for (List<? extends T> currentList : lists) {
			resultList.addAll(currentList);
		}
		return resultList;
	}

	private static void putDemo() {
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
	private static <T> List<? super T> appendCopies(List<? super T> list,
			T item, int nCopies) {
		for (int i = 0; i < nCopies; i++) {
			list.add(item);
		}
		return list;
	}
}
