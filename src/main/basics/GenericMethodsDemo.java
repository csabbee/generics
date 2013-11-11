package basics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class GenericMethodsDemo {
	public static void main(String[] args) {
		List<String> text = new ArrayList<String>();
		text.add("one");
		text.add("two");

		List<String> synchText = Collections.synchronizedList(text);
		assert synchText.equals(text);

		// automatically inferred type parameter
		List<String> stringList = Arrays.asList("one", "two", "three");
		assert stringList.size() == 3;

		// TODO: fix by adding explicit type param
		//List<Object> listOfObject = Arrays.asList("text", new Date(), Math.PI);
		//assert listOfObject.size() == 3;

		// selecting another valid supertype
		List<Serializable> listOfSerializable = Arrays.<Serializable> asList(
				"text", new Date(), Math.PI);
		assert listOfSerializable.size() == 3;

		// doesn't compile - wrong type param - will get back to this when
		// discussing type system
		// List<Number> integers = Arrays.asList(1, 2);
		List<Number> integers = Arrays.<Number> asList(1, 2);
		assert integers.size() == 2;

		// doesn't compile - wrong type param - will get back to this when
		// discussing wildcards
		// List<Number> numbers = Arrays.asList(1, Math.PI);
		List<Number> numbers = Arrays.<Number> asList(1, Math.PI);
		assert numbers.size() == 2;
	}
}
