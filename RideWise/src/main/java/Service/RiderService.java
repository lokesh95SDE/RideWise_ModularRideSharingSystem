package Service;

import Entity.Rider;
import Strategy.FareStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RiderService {

    private final Map<Integer, Rider> ridersById = new HashMap<>();

    public void registerRider(Rider rider) {
        Objects.requireNonNull(rider, "Rider must not be null");
        if(ridersById.putIfAbsent(rider.getRiderId(), rider) != null) {
            throw new IllegalArgumentException("Rider with ID " + rider.getRiderId() + " is already registered.");
        }
    }

    public Rider getRiderById(int riderId){
        if( riderId<=0 ){
            throw new IllegalArgumentException("Rider ID must be positive.");
        }
        if(ridersById.get(riderId) == null){
            throw new IllegalArgumentException("Rider with ID " + riderId + " is not registered.");
        }
        return ridersById.get(riderId);
    }

}
