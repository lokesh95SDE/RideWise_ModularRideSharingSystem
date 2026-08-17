package Strategy;

import Entity.Driver;
import Entity.Rider;

import java.util.List;

public interface RideMatchingStrategy {
    Driver findDriver(Rider rider, List<Driver> drivers);
}
