package Strategy;

import Entity.FareReceipt;
import Entity.Ride;
import Entity.Rider;

import java.math.BigDecimal;

public interface FareStrategy {
    BigDecimal calculateFare(Ride ride);
}
