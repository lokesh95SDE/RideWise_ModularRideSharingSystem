package Strategy;

import Entity.Ride;
import Entity.RideStatus;

import java.math.BigDecimal;

public class DefaultFareStrategy implements FareStrategy
{
    private static final BigDecimal basicFare = new BigDecimal(20);
    private static final BigDecimal perKmFactor = new BigDecimal(5);
    @Override
    public BigDecimal calculateFare(Ride ride) {
        if (ride.getStatus() == null || !ride.getStatus().equals(RideStatus.COMPLETED)) {
            throw new IllegalArgumentException("Ride must be completed to calculate fare.");
        }
        return basicFare.add(perKmFactor.multiply(BigDecimal.valueOf(ride.getDistance())));
    }
}
