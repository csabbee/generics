package typesystem;

import java.util.ArrayList;
import java.util.List;

public class RawTypeDemo {
	public static void main(String[] args) {
		testRaw();
		testWildcard();
	}

	private static void testRaw() {
		List rawList = createIntList();
		rawList.add("raw is unsafe");
		System.out.println(rawList);
	}

	private static void testWildcard() {
		List<?> wildcardList = createIntList();
		// wildcardList.add("wildcard is safe");
		System.out.println(wildcardList);
	}

	private static List<Integer> createIntList() {
		List<Integer> integers = new ArrayList<Integer>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		return integers;
	}
}
