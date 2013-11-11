package typesystem.wildcardsbounds.multiple;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MultipleBoundsDemo {
	public static <T extends Serializable & Comparable<? super T>> byte[] writeSortedValues(
			Collection<? extends T> items) {
		List<T> list = new ArrayList<T>(items);
		Collections.sort(list);
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		try {
			ObjectOutputStream stream = new ObjectOutputStream(bytes);
			stream.writeObject(list);
			stream.flush();
			stream.close();
		} catch (IOException e) {
			throw new Error(e);
		}
		return bytes.toByteArray();
	}

	private static <T extends Serializable & Comparable<? super T>> void testWriteSortedValues(Collection<T> items) {
		byte[] bytes = writeSortedValues(items);
		restoreAndPrint(items, bytes);
	}

	private static void restoreAndPrint(Collection<?> originalItems, byte[] serialized) {
		ByteArrayInputStream bytes = new ByteArrayInputStream(serialized);
		try {
			ObjectInputStream stream = new ObjectInputStream(bytes);
			Object restored = stream.readObject();
			stream.close();
			System.out.println(originalItems + " -> " + restored);
		} catch (Exception e) {
			throw new Error(e);
		}
	}

	public static void main(String[] args) {
		testWriteSortedValues(Arrays.asList("generics", "are", "wonderful"));
		List<Integer> ints = Arrays.asList(2, 0, 1, 0);
		testWriteSortedValues(ints);

		// Number does not implement Comparable
		// List<Number> numbers = new ArrayList<Number>(ints);
		// testWriteSortedValues(numbers);
	}
}
