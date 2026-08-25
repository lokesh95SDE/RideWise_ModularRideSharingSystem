package Service;

import Entity.Driver;

import java.util.*;

public class DriverService {
    private final Map<Integer, Driver> driversById = new HashMap<>();

    public void registerDriver(Driver driver){
        Objects.requireNonNull(driver, "Driver must not be null");
        if(driversById.putIfAbsent(driver.getId(), driver) != null) {
            throw new IllegalArgumentException("Driver with ID " + driver.getId() + " is already registered.");
        }
    }

    public Driver getDriverById(int driverId){
        if( driverId<=0 ){
            throw new IllegalArgumentException("Driver ID must be positive.");
        }
        if(driversById.get(driverId) == null){
            throw new IllegalArgumentException("Driver with ID " + driverId + " is not registered.");
        }
        return driversById.get(driverId);
    }

    public List<Driver> getAvailableDrivers(){
        return driversById.values().stream().filter(Driver::isAvailable).toList();
    }
}
