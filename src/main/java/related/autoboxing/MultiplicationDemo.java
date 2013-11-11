package related.autoboxing;

import java.util.HashMap;
import java.util.Map;

public class MultiplicationDemo {
	public static void main(String[] args) {
		Map<String, Double> operands = new HashMap<String, Double>();
		operands.put("multiplicand", 1.0);
		operands.put("multiplier", 2.0);
		printProduct(operands);
	}

	public static void printProduct(Map<String, Double> operands) {
		System.out.println(operands.get("multiplicant")
				* operands.get("multiplier"));
	}
}
