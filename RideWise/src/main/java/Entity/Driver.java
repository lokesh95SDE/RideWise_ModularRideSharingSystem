package Entity;

public class Driver {
    private int id;
    private String name;
    private String phoneNumber;
    private Location currentLocation;
    private boolean available;
    private VehicleType vehicleType;

    public Driver(int id, String name, String phoneNumber, Location currentLocation, VehicleType vehicleType) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.currentLocation = currentLocation;
        this.vehicleType = vehicleType;
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

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void updateCurrentLocation(Location currentLocation) {
        if(currentLocation == null){
            throw new IllegalArgumentException("Current location cannot be null.");
        }
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
