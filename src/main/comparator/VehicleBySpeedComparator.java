package comparator;

import java.util.Comparator;

public class VehicleBySpeedComparator implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle one, Vehicle other) {
		return Integer.valueOf(one.getMaxSpeed())
				.compareTo(other.getMaxSpeed());
	}

}
