package Strategy;

import Entity.Driver;
import Entity.Location;
import Entity.Rider;

import java.util.List;

public class NearestDriverStrategy implements RideMatchingStrategy{
//Your strategy correctly does not reserve the driver or change ride status. It only selects a candidate. That keeps the strategy boundary clean.
    @Override
    public Driver findDriver(Rider rider, List<Driver> drivers) {
        Location riderLocation = rider.getLocation();
        Driver nearestDriver = null;
        double minDistance = Double.MAX_VALUE;
        for (Driver driver : drivers) {
            if (driver.isAvailable()) {
                Location driverLocation = driver.getCurrentLocation();
                double distance = riderLocation.distanceTo(driverLocation);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestDriver = driver;
                }
            }
        }
    return  nearestDriver;
    }
}