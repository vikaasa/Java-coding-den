package parkinglot;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class InitSettings {
	static final int NUMBER_OF_HEAVY_VEHICLE_BAYS = 0;
	static final int NUMBER_OF_PARKING_BAYS = 3;
	static final int TOTAL_NUMBER_OF_PARKING_LEVELS = NUMBER_OF_HEAVY_VEHICLE_BAYS + NUMBER_OF_PARKING_BAYS;
	static final int TOTAL_PARKING_SPOTS_FOR_LEVEL = 200;
	static final int ROWS_FOR_LEVEL = 10;
	
	public static enum VehicleType {CAR, BIKE, MINIVAN, VAN, BUS, TRUCK};
	public static enum ParkingType {HANDICAPPED, NON_HANDICAPPED, BIKE};
	public static final Map<VehicleType, Integer> VehicleSizes = initVehicleSizes();
    private final static Map<VehicleType, Integer> initVehicleSizes() {
        Map<VehicleType,Integer> vehicleSizeMap = new HashMap<VehicleType, Integer>();
        vehicleSizeMap.put(VehicleType.CAR, 2);
        vehicleSizeMap.put(VehicleType.BIKE, 1);
        return Collections.unmodifiableMap(vehicleSizeMap);
    }
    public static final Map<ParkingType, Double> parkingTypeRatios = initParkingTypeRatios();
    private final static Map<ParkingType, Double> initParkingTypeRatios() {
        Map<ParkingType,Double> parkingTypeRatiosMap = new HashMap<ParkingType, Double>();
        parkingTypeRatiosMap.put(ParkingType.HANDICAPPED, 0.1);
        parkingTypeRatiosMap.put(ParkingType.NON_HANDICAPPED, 0.6);
        parkingTypeRatiosMap.put(ParkingType.BIKE, 0.3);
        return Collections.unmodifiableMap(parkingTypeRatiosMap);
    }
}
