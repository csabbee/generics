package list;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinimaList<E> implements Iterable<E> {
	@SuppressWarnings("unchecked")
    private final E[] myArray = (E[]) new Object[100];
	private int myElementCount = 0;

	public void add(E o) {
		myArray[myElementCount] = o;
		myElementCount++;
	}

	public void clear() {
		myElementCount = 0;
	}

	public void addAll(MinimaList<E> otherList) {
		for (Iterator<E> i = otherList.iterator(); i.hasNext();) {
			add(i.next());
		}
	}

	public boolean isEmpty() {
		return myElementCount == 0;
	}

	public int size() {
		return myElementCount;
	}

	public E get(int position) {
		return myArray[position];
	}

	@Override
	public Iterator<E> iterator() {
		return new SimpleIterator();
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("[");
		Iterator<E> i = iterator();
		while (i.hasNext()) {
			s.append(i.next());
			if (i.hasNext()) {
				s.append(", ");
			}
		}
		s.append("]");
		return s.toString();
	}

	public E[] toArray(Class<E> type) {
	    E[] copy = (E[])Array.newInstance(type, myElementCount);
		System.arraycopy(myArray, 0, copy, 0, myElementCount);
		return copy;
	}

	@Override
	public boolean equals(Object other) {
		boolean areTheSame = (other instanceof MinimaList);
		if (areTheSame) {
			@SuppressWarnings("unchecked")
            MinimaList<E> otherList = (MinimaList<E>) other;
			areTheSame = Arrays.deepEquals(this.myArray, otherList.myArray);
		}
		return areTheSame;
	}

	@Override
	public int hashCode() {
		int hash = myElementCount;
		for (int i = 0; i < myElementCount; i++) {
			Object item = myArray[i];
			if (item != null) {
				hash ^= item.hashCode();
			}
		}
		return hash;
	}

	private class SimpleIterator implements Iterator<E> {
		private int myCurrentIndex = 0;

		@Override
		public boolean hasNext() {
			return myCurrentIndex < MinimaList.this.size();
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E item = MinimaList.this.get(myCurrentIndex);
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public void sort(Comparator<E> comparator) {
		Arrays.sort(myArray, 0, myElementCount, comparator);
	}
}
