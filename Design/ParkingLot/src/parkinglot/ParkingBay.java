package parkinglot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import parkinglot.InitSettings.ParkingType;

public class ParkingBay extends ParkingLevel {
	private int numberOfGeneralParking;
	private int numberOfHandicappedParking;
	private int numberOfBikeParking;
	private int currentRow = 0;
	private int positionInRow = 0;
	public ParkingBay(char levelName, int overallParkingSpotCounter) {
		super(levelName, overallParkingSpotCounter);
		// TODO Auto-generated constructor stub
		numberOfGeneralParking = (int) (getTotalParkingSpotsForLevel()*InitSettings.parkingTypeRatios.get(InitSettings.ParkingType.NON_HANDICAPPED));
		numberOfHandicappedParking = (int) (getTotalParkingSpotsForLevel()*InitSettings.parkingTypeRatios.get(InitSettings.ParkingType.HANDICAPPED));
		numberOfBikeParking = (int) (getTotalParkingSpotsForLevel()*InitSettings.parkingTypeRatios.get(InitSettings.ParkingType.BIKE));
		ArrayList<Boolean> currentLevelAvailability = new ArrayList<Boolean>(3);
		Collections.fill(currentLevelAvailability, Boolean.FALSE);
		setLevelAvailability(currentLevelAvailability);
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
	
	public void createGeneralParkingSpotsHelper(int currentRow, int positionInRow, int parkingSpotsForType, ParkingType parkingType){
		ArrayList<ParkingSpot> parkingSpotRow = null;	
		int parkingSlotsPerRow = getTotalParkingSpotsForLevel()/getRows();
		for(int i = 0; i<parkingSpotsForType;i++){
			if(positionInRow+2 > parkingSlotsPerRow){
				currentRow +=1;
				// creating Boolean ArrayList of size 3, where:
				// 0: HANDICAPPED
				// 1: NON_HANDICAPPED
				// 2: BIKE
				// all initialized to False
				ArrayList<Boolean> currentRowAvailability = new ArrayList<Boolean>(3);
				Collections.fill(currentRowAvailability, Boolean.FALSE);
				getRowAvailability().get(currentRow).addAll(currentRowAvailability);
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
				getRowAvailability().get(currentRow).set(0, Boolean.TRUE);
				positionInRow += InitSettings.VehicleSizes.get(InitSettings.VehicleType.CAR);
				setOverallParkingSpotCounter(InitSettings.VehicleSizes.get(InitSettings.VehicleType.CAR));
				break;
				
			case HANDICAPPED:
				GeneralParkingSpot handicappedParkingSpot = new GeneralParkingSpot(getOverallParkingSpotCounter(), InitSettings.VehicleSizes.get(InitSettings.VehicleType.CAR), true);
				parkingSpotRow.add(handicappedParkingSpot);
				getRowAvailability().get(currentRow).set(0, Boolean.TRUE);
				positionInRow += InitSettings.VehicleSizes.get(InitSettings.VehicleType.CAR);
				setOverallParkingSpotCounter(InitSettings.VehicleSizes.get(InitSettings.VehicleType.CAR));
				break;
				
			case BIKE:
				BikeParkingSpot bikeParkingSpot = new BikeParkingSpot(getOverallParkingSpotCounter(), InitSettings.VehicleSizes.get(InitSettings.VehicleType.BIKE));
				parkingSpotRow.add(bikeParkingSpot);
				getRowAvailability().get(currentRow).set(0, Boolean.TRUE);
				positionInRow += InitSettings.VehicleSizes.get(InitSettings.VehicleType.BIKE);
				setOverallParkingSpotCounter(InitSettings.VehicleSizes.get(InitSettings.VehicleType.BIKE));
				break;
				
			default:
				break;
			}
		}
			
	}
	public void createParkingSpots(){
		createGeneralParkingSpotsHelper(currentRow, positionInRow, numberOfHandicappedParking, ParkingType.HANDICAPPED);
		createGeneralParkingSpotsHelper(currentRow, positionInRow, numberOfGeneralParking, ParkingType.NON_HANDICAPPED);
		createGeneralParkingSpotsHelper(currentRow, positionInRow, numberOfBikeParking, ParkingType.BIKE);
	}

}
