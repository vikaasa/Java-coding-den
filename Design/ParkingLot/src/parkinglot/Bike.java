package parkinglot;

import parkinglot.InitSettings.VehicleType;

public class Bike extends Vehicle {
	private static int size = InitSettings.VehicleSizes.get(VehicleType.BIKE);
	private static VehicleType vehicleType = VehicleType.CAR;
	public Bike(String licensePlate) {
		super(licensePlate, size, vehicleType);
		// TODO Auto-generated constructor stub
	}

}
