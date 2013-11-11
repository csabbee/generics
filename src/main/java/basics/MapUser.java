package basics;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// convert this class to use generics
public class MapUser {
	public static void main(String[] args) {
		Map stringsToNumbers = new HashMap();
		stringsToNumbers.put("one", 1);
		// Math.pi is a double, autoboxed to Double, which is a subclass of
		// Number
		stringsToNumbers.put("pi", Math.PI);

		stringsToNumbers.put("now", System.currentTimeMillis());

		Number pi = (Number) stringsToNumbers.get("pi");
		System.out.println("pi is: " + pi);

		Number ludolphsConstant = (Number) stringsToNumbers.get(Math.PI);
		System.out.println("Ludolph's constant is: " + ludolphsConstant);

		// wrong type for key
		stringsToNumbers.put(3, 3);
		System.out.println(stringsToNumbers);

		// wrong type for value
		stringsToNumbers.put("pi", "'3.14'");
		System.out.println(stringsToNumbers);

		// signature of numbers.get() indicates a return type of Number
		// which cannot be assigned to a Double without an explicit cast
		Double doublePi = (Double) stringsToNumbers.get("pi");
		System.out.println("doublePi: " + doublePi);

		// wrong type for returned value
		Date d = (Date) stringsToNumbers.get("now");
		System.out.println("Date d: " + d);
	}
}
