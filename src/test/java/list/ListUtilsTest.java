package list;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ListUtilsTest {
	@Test
	public void testReverseArray() {
		String[] input = { "hello", "world" };
		String[] expected = { "world", "hello" };
		Object[] reversed = ListUtils.reverse(input);

		assertArrayEquals(expected, reversed);
	}

	@Test
	public void testReverseList() {
		MinimaList input = new MinimaList();
		input.add("hello");
		input.add("world");

		MinimaList expected = new MinimaList();
		expected.add("world");
		expected.add("hello");

		MinimaList reversed = ListUtils.reverse(input);

		assertEquals(expected, reversed);
	}
}
