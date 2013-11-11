package comparator;

import java.util.Comparator;

public class LorryByLoadComparator implements Comparator<Lorry> {

	@Override
	public int compare(Lorry lorry, Lorry otherLorry) {
		return Integer.valueOf(lorry.getMaxLoad()).compareTo(
				otherLorry.getMaxLoad());
	}

}
