package basics.erasure;


public class StaticDemo<T> {
	private static int ourCounter = 0;
	private static String ourType;

	public StaticDemo(String type) {
		ourCounter++;
		ourType = type;
		System.out.println("Created StaticDemo<" + type + ">");
	}

	public static void main(String[] args) {
		StaticDemo<Integer> intInstance = new StaticDemo<Integer>("Integer");
		StaticDemo<String> stringInstance = new StaticDemo<String>("String");
		System.out.println("final type: " + ourType + ", instance counter: "
				+ ourCounter);
		System.out.println("Type of intInstance: " + intInstance.getClass().getName());
		System.out.println("Type of stringInstance: " + stringInstance.getClass().getName());
	}
}
