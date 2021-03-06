package parkinglot;

import java.util.ArrayList;
import java.util.List;

abstract public class ParkingLevel {
	private int totalParkingSpotsForLevel;
	private int rows;
	private List<ArrayList<Boolean>> rowAvailability;
	private ArrayList<Boolean> levelAvailability;
	private int levelNumber;
	protected List<List<ParkingSpot>> rowsInLevel;
	private int overallParkingSpotCounter;
	public ParkingLevel(int levelNumber, int overallParkingSpotCounter){
		this.setTotalParkingSpotsForLevel(InitSettings.TOTAL_PARKING_SPOTS_FOR_LEVEL);
		this.setLevelNumber(levelNumber);
		this.setRows(InitSettings.ROWS_FOR_LEVEL);
		this.rowsInLevel = new ArrayList<List<ParkingSpot>>(rows);
		this.levelAvailability = new ArrayList<Boolean>();
		this.rowAvailability = new ArrayList<ArrayList<Boolean>>(rows);
		this.setOverallParkingSpotCounter(overallParkingSpotCounter);
	}
	public int getTotalParkingSpotsForLevel() {
		return totalParkingSpotsForLevel;
	}
	public void setTotalParkingSpotsForLevel(int totalParkingSpotsForLevel) {
		this.totalParkingSpotsForLevel = totalParkingSpotsForLevel;
	}
	public int getLevelNumber() {
		return levelNumber;
	}
	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getOverallParkingSpotCounter() {
		return overallParkingSpotCounter;
	}
	public void setOverallParkingSpotCounter(int overallParkingSpotCounter) {
		this.overallParkingSpotCounter = overallParkingSpotCounter;
	}
	public List<ArrayList<Boolean>> getRowAvailability() {
		return rowAvailability;
	}
	public void setRowAvailability(List<ArrayList<Boolean>> rowAvailability) {
		this.rowAvailability = rowAvailability;
	}
	public ArrayList<Boolean> getLevelAvailability() {
		return levelAvailability;
	}
	public void setLevelAvailability(ArrayList<Boolean> levelAvailability) {
		this.levelAvailability = levelAvailability;
	}
}
