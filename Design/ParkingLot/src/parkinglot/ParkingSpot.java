package parkinglot;
public abstract class ParkingSpot {
	private boolean isOccupied;
	private long slotNumber;
	private String licensePlate;
	int spotSize;
	
	public ParkingSpot(int slotNumber, int spotSize){
		this.isOccupied = false;
		this.slotNumber = slotNumber;
		this.spotSize = spotSize;
	}
	public boolean isOccupied(){
		return isOccupied;
	}
	public long getSlotNumber(){
		return slotNumber;
	}
	public void park(){
		this.isOccupied = true;
	}
	public void unPark(){
		this.isOccupied = false;
	}
	public void setLicensePlate(String licensePlate){
		this.licensePlate = licensePlate;
	}	
	public int getSpotSize(){
		return spotSize;
	}
	public void setSpotSize(int spotSize){
		this.spotSize = spotSize;
	}
	
}

