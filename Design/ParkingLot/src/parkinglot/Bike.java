package parkinglot;

public class Bike extends Vehicle {
	private static int size = InitSettings.VehicleSizes.get(InitSettings.VehicleType.BIKE);
	public Bike(String licensePlate) {
		super(licensePlate, size);
		// TODO Auto-generated constructor stub
	}

}
