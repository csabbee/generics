package typesystem.wildcardsbounds.multiple;

import java.util.Collection;
import java.util.Iterator;

public class CollectionsMax {
	public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll) {
		Iterator<? extends T> i = coll.iterator();
		T candidate = i.next();

				while (i.hasNext()) {
				T next = i.next();
				if (next.compareTo(candidate) > 0) {
				candidate = next;
			}
		}
		return candidate;
	}

}
