package basics;

import java.io.Serializable;

public class GenericMethodParamDemo<T> {
	// instance method may reference T
	public <P extends T> T doIt(P p) {
		System.out.println("Class of parameter passed to instance method: "
				+ p.getClass().getName());
		return p;
	}

	// class method has no access to instance-level info, including T
	public static <S /* extends T */> S doItStatic(S s) {
		System.out.println("Class of parameter passed to static method: "
				+ s.getClass().getName());
		return s;
	}

	public static void main(String[] args) {
		// automatically inferred type
		doItStatic("demo");
		// explicitly specified type
		GenericMethodParamDemo.<Serializable> doItStatic(1);

		GenericMethodParamDemo<Number> numberDemo = new GenericMethodParamDemo<Number>();
		// wrong type, String does not extend Number
		// numberDemo.doIt("text");
		numberDemo.doIt(1);
		numberDemo.doIt(2.0);
	}

}
