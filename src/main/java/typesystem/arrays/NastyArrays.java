package typesystem.arrays;

import java.util.Arrays;

public class NastyArrays {
	public static void main(String[] args) {
		arrayDemo();
		// listDemo();
	}

	private static void arrayDemo() {
		Integer[] ints = new Integer[] { 1, 2, 3 };

		// Number is assignable from Integer, and their arrays behave the same
		// way
		Number[] numbers = ints;

		numbers[0] = 1.0;

		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(ints));
	}

	// private static void listDemo() {
	// List<Integer> ints = Arrays.asList(1, 2, 3);
	//
	// // Number is assignable from Integer, but their collections
	// // don't behave that way
	// List<Number> numbers = ints;
	//
	// numbers.set(0, 1.0);
	//
	// System.out.println(numbers);
	// System.out.println(ints);
	// }

}
