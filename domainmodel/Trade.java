package domainmodel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Trade {
    private LocalDateTime tradedDatetime;
    private String ticker;
    private String side;
    private int quantity;
    private BigDecimal tradedUnitPrice;
    private LocalDateTime inputDatetime;

    public Trade(LocalDateTime tradedDatetime, String ticker, String side,
                 int quantity, BigDecimal tradedUnitPrice, LocalDateTime inputDatetime) {
        this.tradedDatetime = tradedDatetime;
        this.ticker = ticker;
        this.side = side;
        this.quantity = quantity;
        this.tradedUnitPrice = tradedUnitPrice;
        this.inputDatetime = inputDatetime;
    }

    public LocalDateTime getTradedDatetime() {
        return tradedDatetime;
    }

    public String getTicker() {
        return ticker;
    }

    public String getSide() {
        return side;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getTradedUnitPrice() {
        return tradedUnitPrice;
    }

    public LocalDateTime getInputDatetime() {
        return inputDatetime;
    }

    public String toCsvRow() {
        return tradedDatetime + "," + ticker + "," + side + "," +
                quantity + "," + tradedUnitPrice + "," + inputDatetime;
    }

    @Override
    public String toString() {
        return String.format(
                "%-16s %-8s %-4s %6d %10s %16s",
                tradedDatetime, ticker, side, quantity, tradedUnitPrice, inputDatetime
        );
    }
}
