package domainmodel;

public enum Market {
    P("Prime"),
    S("Standard"),
    G("Growth");

    private final String label;

    Market(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}