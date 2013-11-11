package related.autoboxing;

public class AutoBoxingCallsDemo {
	public static void main(String[] args) {
		double pi = Math.PI;
		Double autoBoxedPi = pi;

		float floatPi = 3.14f;
		Float autoBoxedFloatPi = floatPi;
//		Double badlyBoxedPi = floatPi;

		printValue("pi", pi);
		printValue("autoBoxedPi", autoBoxedPi);
		// promote float to double
		printValue("floatPi", floatPi);
		// unbox Float to float, promote to double
		printValue("autoBoxedFloatPi", autoBoxedFloatPi);

		printPrimitive(pi);
		// unbox automatically
		printPrimitive(autoBoxedPi);

		// autobox to Double
		printObject(pi);
		printObject(autoBoxedPi);
		// autobox to Float
		printObject(floatPi);
	}

	// comment out for demo :-)
	public static void printValue(String msg, double number) {
		System.out.println(msg + " - the primitive double value is " + number);
	}

	public static void printValue(String msg, Double number) {
		System.out.println(msg + " - the wrapped Double value is " + number);
	}

	public static void printPrimitive(double number) {
		printValue("from printPrimitive", number);
	}

	public static void printObject(Object o) {
		System.out.println("The object is of type " + o.getClass()
				+ ", value: " + o);
	}
}
