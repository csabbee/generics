package related;

import java.util.Arrays;

public class VarArgsDemo {
	public static void main(String[] args) {
		String[] strings = { "String1", "String2" };
		Object[] objects = { "Object1", "Object2" };

		// no warning
		Object[] stringsAsObjects = strings;

		// no warning
		arrayTest(strings);
		arrayTest(objects);
		arrayTest(stringsAsObjects);

		// no warning
		varargTest(objects);
		varargTest(stringsAsObjects);

		// warning
		varargTest(strings);

		varargTest((Object) strings);
		varargTest((Object[]) strings);
	}

	public static void arrayTest(Object[] p) {
		System.out.println("arrayTest, # of params: " + p.length + ", params: "
				+ Arrays.toString(p));
	}

	public static void varargTest(Object... p) {
		System.out.println("varargTest, # of params: " + p.length
				+ ", params: " + Arrays.toString(p));
	}
}
