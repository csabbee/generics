package typesystem.wildcardsbounds.upperboundsuper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCopy {
	public static <T> void copy1(List<T> source, List<T> destination) {
		destination.clear();
		for (T item : source) {
			destination.add(item);
		}
	}

	public static <T> void copy2(List<T> source, List<? super T> destination) {
		destination.clear();
		for (T item : source) {
			destination.add(item);
		}
	}

	public static <T> void copy3(List<? extends T> source, List<T> destination) {
		destination.clear();
		for (T item : source) {
			destination.add(item);
		}
	}

	public static <T> void copy4(List<? extends T> source,
			List<? super T> destination) {
		destination.clear();
		for (T item : source) {
			destination.add(item);
		}
	}

	public static void main(String[] args) {
		List<Integer> source = Arrays.asList(1, 2, 3);
		List<Integer> intDestination = new ArrayList<Integer>();

		copy1(source, intDestination);

		List<Number> numberDestination = new ArrayList<Number>();
		List<Serializable> sers = new ArrayList<Serializable>();

		ListCopy.<Number>copy4(source, sers);

		// compile error
		// copy1(source, numberDestination);
		copy2(source, numberDestination);
		copy3(source, numberDestination);
		copy4(source, numberDestination);
	}

}
