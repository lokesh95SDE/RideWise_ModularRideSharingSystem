package Strategy;

import Entity.Driver;
import Entity.Rider;

import java.util.List;

public class LeastActiveDriverStrategy implements RideMatchingStrategy{
    @Override
    public Driver findDriver(Rider rider, List<Driver> drivers) {
        Driver leastActiveDriver = null;
        int minRides = Integer.MAX_VALUE;
        for(Driver d : drivers){
            if (!d.isAvailable()) {
                continue;
            }
            if (d.getCompletedRideCount() < minRides)
            {
                minRides = d.getCompletedRideCount();
                leastActiveDriver=d;
            }
            if (d.getCompletedRideCount() == minRides  && d.getId() < leastActiveDriver.getId())
            {
                leastActiveDriver=d;
            }
        }
    return leastActiveDriver;
    }
}
