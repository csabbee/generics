package basics;

import java.util.Arrays;
import java.util.List;

public class GenericNumberUtils {
	private static double square(Number number) {
		double square = number.doubleValue() * number.doubleValue();
		System.out.println("square of " + number.getClass() + ": " + square);
		return square;
	}

	private static double sum(List<Number> numbers) {
		double sum = 0.0d;
		for (Number n : numbers) {
			sum += n.doubleValue();
		}
		System.out.println("sum of " + numbers + ": " + sum);
		return sum;
	}

	public static void main(String[] args) {
		square(1);
		square(2.0d);

		List<Number> ints = Arrays.<Number> asList(1, 2, 3);
		List<Number> doubles = Arrays.<Number> asList(1.1d, 2.2d, 3.3d);

		sum(ints);
		sum(doubles);

		// List<Integer> realInts = Arrays.asList(1, 2, 3);
		// List<Double> realDoubles = Arrays.asList(1.1, 2.2, 3.3);
		//
		// sum(realInts);
		// sum(realDoubles);

	}
}
