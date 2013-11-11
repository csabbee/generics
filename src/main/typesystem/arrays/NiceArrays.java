package typesystem.arrays;

import java.util.Arrays;

public class NiceArrays {
	private static double square(Number number) {
		double square = number.doubleValue() * number.doubleValue();
		System.out.println("square of " + number + " (" + number.getClass()
				+ "): " + square);
		return square;
	}

	private static double sum(Number[] numbers) {
		double sum = 0.0d;
		for (Number n : numbers) {
			sum += n.doubleValue();
		}
		System.out.println("sum of " + Arrays.toString(numbers) + ": " + sum);
		return sum;
	}

	public static void main(String[] args) {
		square(1);
		square(2.0d);

		sum(new Integer[] { 1, 2, 3 });
		sum(new Double[] { 1.1d, 2.2d, 3.3d });
	}

}
