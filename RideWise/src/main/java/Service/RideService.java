package Service;

import Entity.FareReceipt;
import Entity.Ride;
import Strategy.FareStrategy;
import Strategy.RideMatchingStrategy;
import Exception.NoDriverAvailableException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class RideService {
    private final FareStrategy fareStrategy;
    private final RideMatchingStrategy rideMatchingStrategy;
    private final DriverService driverService;
    private final RiderService riderService;
    private final NavigableMap<Integer, Ride> ridesById = new TreeMap<>();
    public RideService(FareStrategy fareStrategy, RideMatchingStrategy rideMatchingStrategy, DriverService driverService, RiderService riderService) {
        this.fareStrategy = fareStrategy;
        this.rideMatchingStrategy = rideMatchingStrategy;
        this.driverService = driverService;
        this.riderService = riderService;
    }

    public Ride  requestRide(int riderId, double distance){
        int lastrideId = ridesById.isEmpty() ? 0 : ridesById.lastKey();
        var rider = riderService.getRiderById(riderId);
        var availableDrivers = driverService.getAvailableDrivers();
        var matchedDriver = rideMatchingStrategy.findDriver(rider, availableDrivers);
        if(matchedDriver == null){
            throw new NoDriverAvailableException("No available drivers found for the requested ride.");
        }
        Ride ride = new Ride(lastrideId+1, rider, distance);
        matchedDriver.reserveForRide();
        ride.assignDriver(matchedDriver);
        ridesById.put(ride.getRideId(), ride);
        return ride;
    }

    public void startRide(int rideId){
        Ride ride = ridesById.get(rideId);
        if(ride == null){
            throw new IllegalArgumentException("Ride with ID " + rideId + " does not exist.");
        }
        ride.startRide();
    }


    public FareReceipt completeRide(int rideId){
        Ride ride = ridesById.get(rideId);
        if (ride == null) {
            throw new IllegalArgumentException("Ride with ID " + rideId + " does not exist.");
        }
        ride.completeRide();
        ride.getDriver().completeRideAndRelease();
        return new FareReceipt(rideId, fareStrategy.calculateFare(ride), Instant.now());
    }

    public void cancelRide(int rideId){
        Ride ride =ridesById.get(rideId);
        if (ride == null) {
            throw new IllegalArgumentException("Ride with ID " + rideId + " does not exist.");
        }
        ride.cancelRide();
        if (ride.getDriver() != null) {
            ride.getDriver().releaseAfterCancellation();
        }
    }
}
