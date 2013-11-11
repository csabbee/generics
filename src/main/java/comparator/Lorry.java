package comparator;

public class Lorry extends Vehicle {
	private final int maxLoad;

	public Lorry(int maxSpeed, int horsePowers, int maxLoad) {
		super(maxSpeed, horsePowers);
		this.maxLoad = maxLoad;
	}

	public int getMaxLoad() {
		return maxLoad;
	}

	@Override
	public String toString() {
		return super.toString() + ", maxLoad: " + maxLoad;
	}
}
