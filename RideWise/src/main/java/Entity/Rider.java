package Entity;

public class Rider {
    private int riderId;
    private String riderName;
    private String ridePhoneNumber;
    private String location;

    public Rider(int riderId, String riderName, String ridePhoneNumber, String location) {
        this.riderId = riderId;
        this.riderName = riderName;
        this.ridePhoneNumber = ridePhoneNumber;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
