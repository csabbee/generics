package typesystem.wildcardsbounds.capture;

public class CaptureDemo {
	public static void main(String[] args) {
		new ThingTest().test(new IntegerThing());
		new ThingTest().test(new StringThing());
	}
}
