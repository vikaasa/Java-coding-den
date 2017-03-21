package parkinglot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import parkinglot.InitSettings.ParkingType;
import parkinglot.InitSettings.VehicleType;

public class ParkingBay extends ParkingLevel {
	private int currentRow = 0;
	private int positionInRow = 0;
	public ParkingBay(int levelNumber, int overallParkingSpotCounter) {
		super(levelNumber, overallParkingSpotCounter);
		// TODO Auto-generated constructor stub
		ArrayList<Boolean> currentLevelAvailability = new ArrayList<Boolean>(3);
		Collections.fill(currentLevelAvailability, Boolean.FALSE);
		setLevelAvailability(currentLevelAvailability);
		createParkingSpots();
	}
	
	public void createGeneralParkingSpotsHelper(int currentLevel, int currentRow, int positionInRow, int parkingSpotsForType, ParkingType parkingType){
		ArrayList<ParkingSpot> parkingSpotRow = null;	
		int parkingSlotsPerRow = getTotalParkingSpotsForLevel()/getRows();
		int lastTypeInRowIdentifier = InitSettings.VehicleSizes.get(InitSettings.VehicleType.CAR);
		for(int i = 0; i<parkingSpotsForType;i++){
			if(positionInRow+lastTypeInRowIdentifier > parkingSlotsPerRow){
				setOverallParkingSpotCounter(getOverallParkingSpotCounter()+(parkingSlotsPerRow-positionInRow));
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
			//int[] currentLevelAndRow = {currentLevel, currentRow};
			switch(parkingType){
			case NON_HANDICAPPED:
				GeneralParkingSpot generalParkingSpot = new GeneralParkingSpot(getOverallParkingSpotCounter(), InitSettings.VehicleSizes.get(InitSettings.VehicleType.CAR), false);
				parkingSpotRow.add(generalParkingSpot);
				//ParkingLot.getParkingSlotMap().put(getOverallParkingSpotCounter(),currentLevelAndRow);
				getRowAvailability().get(currentRow).set(0, Boolean.TRUE);
				positionInRow += InitSettings.VehicleSizes.get(InitSettings.VehicleType.CAR);
				setOverallParkingSpotCounter(getOverallParkingSpotCounter()+InitSettings.VehicleSizes.get(InitSettings.VehicleType.CAR));
				lastTypeInRowIdentifier = InitSettings.VehicleSizes.get(InitSettings.VehicleType.CAR);
				break;
				
			case HANDICAPPED:
				GeneralParkingSpot handicappedParkingSpot = new GeneralParkingSpot(getOverallParkingSpotCounter(), InitSettings.VehicleSizes.get(InitSettings.VehicleType.CAR), true);
				parkingSpotRow.add(handicappedParkingSpot);
				//ParkingLot.getParkingSlotMap().put(getOverallParkingSpotCounter(),currentLevelAndRow);
				getRowAvailability().get(currentRow).set(0, Boolean.TRUE);
				positionInRow += InitSettings.VehicleSizes.get(InitSettings.VehicleType.CAR);
				setOverallParkingSpotCounter(getOverallParkingSpotCounter()+InitSettings.VehicleSizes.get(InitSettings.VehicleType.CAR));
				lastTypeInRowIdentifier = InitSettings.VehicleSizes.get(InitSettings.VehicleType.CAR);
				break;
				
			case BIKE:
				BikeParkingSpot bikeParkingSpot = new BikeParkingSpot(getOverallParkingSpotCounter(), InitSettings.VehicleSizes.get(InitSettings.VehicleType.BIKE));
				parkingSpotRow.add(bikeParkingSpot);
				//ParkingLot.getParkingSlotMap().put(getOverallParkingSpotCounter(),currentLevelAndRow);
				getRowAvailability().get(currentRow).set(0, Boolean.TRUE);
				positionInRow += InitSettings.VehicleSizes.get(InitSettings.VehicleType.BIKE);
				setOverallParkingSpotCounter(getOverallParkingSpotCounter()+InitSettings.VehicleSizes.get(InitSettings.VehicleType.BIKE));
				lastTypeInRowIdentifier = InitSettings.VehicleSizes.get(InitSettings.VehicleType.BIKE);
				break;
				
			default:
				break;
			}
		}
			
	}
	public void createParkingSpots(){
		createGeneralParkingSpotsHelper(getLevelNumber(), currentRow, positionInRow, InitSettings.NUMBER_OF_HANDICAPPED_PARKING, ParkingType.HANDICAPPED);
		createGeneralParkingSpotsHelper(getLevelNumber(), currentRow, positionInRow, InitSettings.NUMBER_OF_GENERAL_PARKING, ParkingType.NON_HANDICAPPED);
		createGeneralParkingSpotsHelper(getLevelNumber(), currentRow, positionInRow, InitSettings.NUMBER_OF_BIKE_PARKING, ParkingType.BIKE);
	}

}
