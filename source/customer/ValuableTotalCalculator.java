package customer;

public class ValuableTotalCalculator {
    private double total = 0;

    void addNewValuable(Valuable valuable) {
        total += valuable.value();
    }

    public double netTotal() {
        return total;
    }
}