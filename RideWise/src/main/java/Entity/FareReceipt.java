package Entity;

import java.math.BigDecimal;
import java.time.Instant;

public class FareReceipt {
    private  int rideId;
    private BigDecimal amount;
    private Instant generatedAt;

    public FareReceipt(int rideId, BigDecimal amount, Instant generatedAt) {
        this.rideId = rideId;
        this.amount = amount;
        this.generatedAt = generatedAt;
    }

    public int getRideId() {
        return rideId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Instant getGeneratedAt() {
        return generatedAt;
    }

}
