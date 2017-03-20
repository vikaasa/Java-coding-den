package parkinglot;

import parkinglot.InitSettings.VehicleType;

public abstract class Vehicle {
	private String licensePlate;
	private int size;
	private VehicleType vehicleType;
	public Vehicle(String licensePlate, int size, VehicleType vehicleType){
		this.licensePlate = licensePlate;
		this.size = size;
		this.vehicleType = vehicleType;
	}
	public String getLicensePlate(){
		return licensePlate;
	}
	public int getSize() {
		return size;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

}
