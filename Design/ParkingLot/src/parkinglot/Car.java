package parkinglot;

import parkinglot.InitSettings.VehicleType;

public class Car extends Vehicle {
	private boolean isHandicapped;
	private static VehicleType vehicleType = VehicleType.CAR;
	private static int size = InitSettings.VehicleSizes.get(VehicleType.CAR);
	public Car(String licensePlate, boolean isHandicapped) {
		super(licensePlate, size, vehicleType);
		// TODO Auto-generated constructor stub
		this.setHandicapped(isHandicapped);
	}
	public boolean getIsHandicapped() {
		return isHandicapped;
	}
	public void setHandicapped(boolean isHandicapped) {
		this.isHandicapped = isHandicapped;
	}
	
}
