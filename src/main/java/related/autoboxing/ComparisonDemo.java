package related.autoboxing;

public class ComparisonDemo {
	public static void main(String[] args) {
		int smallI = 1;
		int smallJ = 1;
		Integer wrappedSmallI = smallI;
		Integer wrappedSmallJ = smallJ;
		compare(smallI, smallJ, wrappedSmallI, wrappedSmallJ);

		int bigI = 12345;
		int bigJ = 12345;
		Integer wrappedBigI = bigI;
		Integer wrappedBigJ = bigJ;
		compare(bigI, bigJ, wrappedBigI, wrappedBigJ);
	}

	private static void compare(int i, int j, Integer wrappedI, Integer wrappedJ) {
		System.out.println("i: " + i + ", j: " + j + ", wrappedI: " + wrappedI
				+ ", wrappedJ: " + wrappedJ);
		System.out.println("i == j: " + (i == j));
		System.out.println("wrappedI == wrappedJ: " + (wrappedI == wrappedJ));
		System.out.println("wrappedI.equals(wrappedJ): " + wrappedI.equals(wrappedJ));
	}


}

