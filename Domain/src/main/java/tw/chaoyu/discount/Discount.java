package tw.chaoyu.discount;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class Discount {
    private final int percentageOff;
    private final String[] items;

    public Discount(int percentageOff, String... items) {
        this.percentageOff = percentageOff;
        this.items = items;
    }

    public int getPercentageOff() {
        return percentageOff;
    }

    public String[] getItems() {
        return items;
    }
}
