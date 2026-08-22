package Strategy;

import Entity.Ride;
import Entity.RideStatus;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PeakHourFareStrategy implements FareStrategy{

    private static final BigDecimal peakMultiplyFactor = new BigDecimal(1.5);

    public final FareStrategy baseFareStrategy;

    public PeakHourFareStrategy(FareStrategy baseFareStrategy) {
        this.baseFareStrategy = baseFareStrategy;
    }

    @Override
    public BigDecimal calculateFare(Ride ride) {
        if (ride.getStatus() == null || !ride.getStatus().equals(RideStatus.COMPLETED)) {
            throw new IllegalArgumentException("Ride must be completed to calculate fare.");
        }
        return baseFareStrategy.calculateFare(ride).multiply(peakMultiplyFactor).setScale(2, RoundingMode.HALF_UP);
    }
}
