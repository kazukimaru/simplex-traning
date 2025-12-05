package domainmodel;

public class Stock {
    private final String ticker;
    private final String name;
    private final Market market;
    private final long sharesIssued;

    public Stock(String[] data) {
        this.ticker = data[0];
        this.name   = data[1];
        this.market = Market.valueOf(data[2]);
        this.sharesIssued = Long.parseLong(data[3]);
    }

    public String getTicker() { return ticker; }
    public String getProductName() {
        if (name.length() >= 28){
            return name.substring(0,28) + "...";
        }
        return name;
    }
    public Market getMarket() { return market; }
    public long   getSharesIssued() { return sharesIssued; }
}