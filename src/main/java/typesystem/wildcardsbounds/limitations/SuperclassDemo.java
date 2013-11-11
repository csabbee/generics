package typesystem.wildcardsbounds.limitations;

import java.util.ArrayList;

public class SuperclassDemo<T, C> extends ArrayList<T> implements Comparable<C> {
	private static final long serialVersionUID = 1821451761594908629L;

	public static void main(String[] args) {
		SuperclassDemo<?, ? extends Number> instance = null;
		// new SuperclassDemo<?, ? extends Number>();
		// can't create an instance:
		// can't call supertype constructor to create ArrayList<?> - list of
		// unknown type
		// and
		// Comparable to an unknown, but concrete subtype of Number ?
		assert instance == null;
	}

	@Override
	public int compareTo(C o) {
		return o != null ? 0 : 1;
	}
}
