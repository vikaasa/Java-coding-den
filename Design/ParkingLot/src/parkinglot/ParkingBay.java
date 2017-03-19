package parkinglot;

import java.util.ArrayList;
import parkinglot.InitSettings.GeneralParkingTypes;

public class ParkingBay extends ParkingLevel {
	private int numberOfGeneralParking;
	private int numberOfHandicappedParking;
	private int numberOfBikeParking;
	private int currentRow = 0;
	private int positionInRow = 0;
	public ParkingBay(char levelName, int overallParkingSpotCounter) {
		super(levelName, overallParkingSpotCounter);
		// TODO Auto-generated constructor stub
		numberOfGeneralParking = (int) (getTotalParkingSpotsForLevel()*InitSettings.parkingTypeRatios.get(InitSettings.GeneralParkingTypes.NON_HANDICAPPED));
		numberOfHandicappedParking = (int) (getTotalParkingSpotsForLevel()*InitSettings.parkingTypeRatios.get(InitSettings.GeneralParkingTypes.HANDICAPPED));
		numberOfBikeParking = (int) (getTotalParkingSpotsForLevel()*InitSettings.parkingTypeRatios.get(InitSettings.GeneralParkingTypes.BIKE));
		createParkingSpots();
	}
	public int getNumberOfHandicappedParking() {
		return numberOfHandicappedParking;
	}
	public void setNumberOfHandicappedParking(int numberOfHandicappedParking) {
		this.numberOfHandicappedParking = numberOfHandicappedParking;
	}
	public int getNumberOfGeneralParking() {
		return numberOfGeneralParking;
	}
	public void setNumberOfGeneralParking(int numberOfGeneralParking) {
		this.numberOfGeneralParking = numberOfGeneralParking;
	}
	public int getNumberOfBikeParking() {
		return numberOfBikeParking;
	}
	public void setNumberOfBikeParking(int numberOfBikeParking) {
		this.numberOfBikeParking = numberOfBikeParking;
	}
	
	public void createGeneralParkingSpotsHelper(int currentRow, int positionInRow, int parkingSpotsForType, GeneralParkingTypes parkingType){
		ArrayList<ParkingSpot> parkingSpotRow = null;	
		int parkingSlotsPerRow = getTotalParkingSpotsForLevel()/getRows();
		for(int i = 0; i<parkingSpotsForType;i++){
			if(positionInRow+2 > parkingSlotsPerRow){
				currentRow +=1;
				positionInRow=0;
			}
			if(positionInRow == 0){
				parkingSpotRow = new ArrayList<ParkingSpot>(parkingSlotsPerRow);
				rowsInLevel.add(parkingSpotRow);
			}	
			switch(parkingType){
			case NON_HANDICAPPED:
				GeneralParkingSpot generalParkingSpot = new GeneralParkingSpot(getOverallParkingSpotCounter(), InitSettings.VehicleSizes.get(InitSettings.VehicleType.CAR), false);
				parkingSpotRow.add(generalParkingSpot);
				positionInRow += InitSettings.VehicleSizes.get(InitSettings.VehicleType.CAR);
				setOverallParkingSpotCounter(InitSettings.VehicleSizes.get(InitSettings.VehicleType.CAR));
				
			case HANDICAPPED:
				GeneralParkingSpot handicappedParkingSpot = new GeneralParkingSpot(getOverallParkingSpotCounter(), InitSettings.VehicleSizes.get(InitSettings.VehicleType.CAR), true);
				parkingSpotRow.add(handicappedParkingSpot);
				positionInRow += InitSettings.VehicleSizes.get(InitSettings.VehicleType.CAR);
				setOverallParkingSpotCounter(InitSettings.VehicleSizes.get(InitSettings.VehicleType.CAR));

			case BIKE:
				GeneralParkingSpot bikeParkingSpot = new GeneralParkingSpot(getOverallParkingSpotCounter(), InitSettings.VehicleSizes.get(InitSettings.VehicleType.BIKE), true);
				parkingSpotRow.add(bikeParkingSpot);
				positionInRow += InitSettings.VehicleSizes.get(InitSettings.VehicleType.BIKE);
				setOverallParkingSpotCounter(InitSettings.VehicleSizes.get(InitSettings.VehicleType.BIKE));
				
			default:
				break;
			}
		}
			
	}
	public void createParkingSpots(){
		createGeneralParkingSpotsHelper(currentRow, positionInRow, numberOfHandicappedParking, GeneralParkingTypes.HANDICAPPED);
		createGeneralParkingSpotsHelper(currentRow, positionInRow, numberOfGeneralParking, GeneralParkingTypes.NON_HANDICAPPED);
		createGeneralParkingSpotsHelper(currentRow, positionInRow, numberOfBikeParking, GeneralParkingTypes.BIKE);
	}

}
