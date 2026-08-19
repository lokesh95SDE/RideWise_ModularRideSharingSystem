package Entity;

public class Ride {
    private int rideId;
    private Rider rider;
    private Driver driver;
    private double distance;
    private RideStatus status;

    public Ride(int rideId, Rider rider, double distance) {
        this.rideId = rideId;
        this.rider = rider;
        this.distance = distance;
        status = RideStatus.REQUESTED;
        driver = null;
    }

    public int getRideId() {
        return rideId;
    }


    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public double getDistance() {
        return distance;
    }


    public RideStatus getStatus() {
        return status;
    }

    //Check if the driver is null before assigning, if not null then do not assign and keep the status as requested
    public void assignDriver(Driver driver) {
        if(driver == null){throw new IllegalArgumentException("Driver cannot be null.");}
        if (status != RideStatus.REQUESTED) {
            throw new IllegalStateException(
                    "A driver can only be assigned to a requested ride."
            );
        }
        this.driver = driver;
        status = RideStatus.ASSIGNED;
    }


}
