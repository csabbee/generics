package related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ForEachDemo {
	public static void main(String[] args) {
		List<String> strings = new ArrayList(Arrays.asList("hello", "world", "!"));

		deleteWithForEach(strings);
		deleteWithIterator(strings);
		System.out.println(strings);
	}

	private static void deleteWithForEach(List<String> strings) {
		System.out.println("Deleting from " + strings.getClass().toString());
		try {
			for (String string : strings) {
				if (string.length() == 1) {
					strings.remove(string);
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	private static void deleteWithIterator(List<String> copy) {
		for (Iterator<String> iterator = copy.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			if (string.length() == 1) {
				iterator.remove();
			}
		}
	}
}
