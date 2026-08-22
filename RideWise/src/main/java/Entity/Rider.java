package Entity;

public class Rider {
    private final int riderId;
    private String riderName;
    private String ridePhoneNumber;
    private Location location;

    public Rider(int riderId, String riderName, String ridePhoneNumber, Location location) {
        if (riderId <= 0) {
            throw new IllegalArgumentException("Driver id must be greater than zero.");
        }
        this.riderId = riderId;
        this.riderName = riderName;
        if(ridePhoneNumber.isBlank()){
            throw new IllegalArgumentException("Phone number cannot be blank.");
        }
        this.ridePhoneNumber = ridePhoneNumber;
        if(location == null){
            throw new IllegalArgumentException("Location cannot be null.");
        }
        this.location = location;
    }

    public int getRiderId() {
        return riderId;
    }

    public String getRiderName() {
        return riderName;
    }

    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    public String getRidePhoneNumber() {
        return ridePhoneNumber;
    }

    public void setRidePhoneNumber(String ridePhoneNumber) {
        this.ridePhoneNumber = ridePhoneNumber;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
