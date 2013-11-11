package comparator;

public class Car extends Vehicle {
	private final int nPassangers;

	public Car(int maxSpeed, int horsePowers, int nPassangers) {
		super(maxSpeed, horsePowers);
		this.nPassangers = nPassangers;
	}

	public int getnPassangers() {
		return nPassangers;
	}

	@Override
	public String toString() {
		return super.toString() + ", nPassangers: " + nPassangers;
	}

}
