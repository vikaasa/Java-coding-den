package parkinglot;

public class GeneralParkingSpot extends ParkingSpot{
	private boolean isHandicapped;
	public GeneralParkingSpot(int slotNumber, int spotSize, boolean isHandicapped) {
		super(slotNumber, spotSize);
		// TODO Auto-generated constructor stub
		this.setHandicapped(isHandicapped);
	}
	public boolean isHandicapped() {
		return isHandicapped;
	}
	public void setHandicapped(boolean isHandicapped) {
		this.isHandicapped = isHandicapped;
	}
	
}
