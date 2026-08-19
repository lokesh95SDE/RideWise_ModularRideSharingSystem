package Strategy;

import Entity.Driver;
import Entity.Rider;

import java.util.List;

public class LeastActiveDriverStrategy implements RideMatchingStrategy{
    @Override
    public Driver findDriver(Rider rider, List<Driver> drivers) {
        Driver leastActiveDriver = null;
        int minrRides = Integer.MAX_VALUE;
        for(Driver d : drivers){
            int actualRideCounts = d.getCompletedRideCount();
            if(actualRideCounts<minrRides){
                minrRides = actualRideCounts;
                leastActiveDriver=d;
            }
        }
    return leastActiveDriver;
    }
}
