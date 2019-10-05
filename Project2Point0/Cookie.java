package Project2Point0;

/**
 * COOKIE CLASS
 * Extends DessertItem
 * Price is based on PRICEPERDOZEN and quantity.
 * Also has a flavor option.
 * Contains String[]'s which are for the sale menu options
 * @author Justin Mabutas 2/21/2019
 */
public class Cookie extends DessertItem {

    private final double PRICEPERDOZEN = 8.00;
    private double PRICE;
    private String flavor;
    private String quantity;

    private static String[] FlavorOptions = {"Flavor", "Oatmeal Raisin", "Chocolate", "Snickerdoodle"};
    private static String[] QuantityOptions = {"Quantity", "1 dozen", "2 dozen", "3 dozen", "4 dozen", "5 dozen"};

    /**
     * Default Constructor
     * Calculates PRICE by multiplying quantity by PRICEPERDOZEN
     * @param name
     * @param quantity
     */
    public Cookie(String name, String quantity) {
        super(name);
        this.flavor = name;
        this.quantity = quantity;
        PRICE = Integer.parseInt(quantity.substring(0,1)) * PRICEPERDOZEN;
    }

    /**
     * Getter method for quantity
     * @return quantity
     */
    public String getQuantity() {return quantity;}

    /**
     * Getter method for FlavorOptions
     * @return FlavorOptions: String[] for Sale menu
     */
    public static String[] getFlavorOptions() {return FlavorOptions;}
    /**
     * Getter method for QuantityOptions
     * @return QuantityOptions: String[] for Sale menu
     */
    public static String[] getQuantityOptions() {return QuantityOptions;}

    /**
     * Getter method for cost
     * @return PRICE;
     */
    public double getCost() {
        return PRICE;
    }

    /**
     * Comparable function that compmares this object to DessertItem object
     * @param dessert
     * @return if this is larger, return 1; elif smaller, return -1; else return 0
     */
    public int compareTo(DessertItem dessert) {
        if(getCost() > dessert.getCost()) return 1;
        else if(getCost() == dessert.getCost()) return 0;
        else return -1;
    }

    /**
     * toString method
     * @return String: Dessert name\n Price\n Flavor \n Quantity
     */
    public String toString() {
        return super.toString() + String.format("Flavor: %s              \nQuantity: %s           \n\n", flavor, quantity);
    }
}
