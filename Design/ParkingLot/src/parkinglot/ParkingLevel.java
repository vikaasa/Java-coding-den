package parkinglot;

import java.util.ArrayList;
import java.util.List;

abstract public class ParkingLevel {
	private int totalParkingSpotsForLevel;
	private int rows;
	private char levelName;
	protected List<List<ParkingSpot>> rowsInLevel;
	private int overallParkingSpotCounter;
	public ParkingLevel(char levelName, int overallParkingSpotCounter){
		this.setTotalParkingSpotsForLevel(InitSettings.TOTAL_PARKING_SPOTS_FOR_LEVEL);
		this.setLevelName(levelName);
		this.setRows(InitSettings.ROWS_FOR_LEVEL);
		this.rowsInLevel = new ArrayList<List<ParkingSpot>>(rows);
		this.setOverallParkingSpotCounter(overallParkingSpotCounter);
	}
	public int getTotalParkingSpotsForLevel() {
		return totalParkingSpotsForLevel;
	}
	public void setTotalParkingSpotsForLevel(int totalParkingSpotsForLevel) {
		this.totalParkingSpotsForLevel = totalParkingSpotsForLevel;
	}
	public char getLevelName() {
		return levelName;
	}
	public void setLevelName(char levelName) {
		this.levelName = levelName;
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
}
