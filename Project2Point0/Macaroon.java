package Project2Point0;

/**
 * MACAROON CLASS
 * Extends Cookie
 * Price is different between matcha and chocolate and is affected by quantity
 * Contains cost, flavor, quantity, and options for flavor and Quantity
 * @author Justin Mabutas 2/21/2019
 */
public class Macaroon extends Cookie {

    private final double MATCHA_INDIVIDUAL_PRICE = 1.25;
    private final double MATCHA_BULK_PRICE = 3.50;
    private final double CHOCO_INDIVIDUAL_PRICE = 1.00;
    private final double CHOCO_BULK_PRICE = 2.75;
    private double cost;
    private String flavor;
    public String quantity;

    private static String[] FlavorOptions = {"Flavor", "Matcha", "Chocolate"};
    private static String[] QuantityOptions =  new String[31];

    /**
     * Overloaded Constructor
     * @param flavor
     * @param quantity
     */
    public Macaroon(String flavor, String quantity) {
        super("Macaroon", quantity);

        this.flavor = flavor;
        this.quantity = quantity;
        double q = Integer.parseInt(quantity);
        switch (flavor) {
            case("Matcha"):
                cost = (q % 3) * MATCHA_INDIVIDUAL_PRICE;
                cost += Math.floor(q/3) * MATCHA_BULK_PRICE;
                break;
            case("Chocolate"):
                cost = (q % 3) * CHOCO_INDIVIDUAL_PRICE;
                cost += Math.floor(q/3) * CHOCO_BULK_PRICE;
                break;
        }
    }

    /**
     * Getter method for FlavorOptions
     * @return FlavorOptions
     */
    public static String[] getFlavorOptions() {return FlavorOptions;}

    /**
     * Getter method for QuantityOptions
     * @return QuantityOptions
     */
    public static String[] getQuantityOptions() {
        QuantityOptions[0] = "Quantity";
        for (int i = 1; i < QuantityOptions.length; i++) QuantityOptions[i] = Integer.toString(i);
        return QuantityOptions;
    }

    /**
     * Getter method for cost
     * @return cost
     */
    public double getCost() {return cost;}

    /**
     * compareTo method
     * Compares this item to another dessert item
     * @param dessert
     * @return if this is more expensive, 1; if not, -1; if equal, 0
     */
    public int compareTo(DessertItem dessert) {
        if(getCost() > dessert.getCost()) return 1;
        else if(getCost() == dessert.getCost()) return 0;
        else return -1;
    }

    /**
     * toString method
     * @return String: Flavor \n Name \n Price \n Quantity \n
     */
    public String toString() {
        return super.toString();
    }
}
