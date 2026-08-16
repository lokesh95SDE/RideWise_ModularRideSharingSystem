package Entity;

public class Driver {
    private int id;
    private String name;
    private String phoneNumber;
    private String currentLocation;
    private boolean available;

    public Driver(int id, String name, String phoneNumber, String currentLocation) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.currentLocation = currentLocation;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isAvailable() {
        return available;
    }

    public void reserveForRide(){
        if(!available){
            throw new IllegalStateException("Driver is not available for a ride.");
        }
        available = false;
    }

    public void releaseAfterRide(){
        if(available){
            throw new IllegalArgumentException("Driver is already available.");
        }
        available=true;
    }
}
