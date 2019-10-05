package Project2Point0;

/**
 * PASTRY CLASS
 * Pastry extends DessertItem
 * Has Unit price and price for heating which is multiplied by the quantity to get an additional cost
 * Has String[] for menu options.
 * @author Justin Mabutas 2/21/2019
 */
public class Pastry extends DessertItem {

    private final double UNIT_PRICE = 2.00;
    private final double PRICE_FOR_HEATING = 0.25;
    private double cost;
    private String quantity;
    private String heatingOption;

    private static String[] PastryOptions = {"Pastry", "Croissant", "Donut", "Muffin"};
    private static String[] QuantityOptions = {"Quantity", "1", "2", "3", "4", "5"};
    private static String[] HeatingOptions = {"Heating Option", "Don't Heat", "Microwave", "Toaster", "Oven"};

    /**
     * Overloaded Constructor
     * @param name
     * @param quantity
     * @param heatingOption
     */
    public Pastry(String name, String quantity, String heatingOption) {
        super(name);
        this.quantity = quantity;
        this.heatingOption = heatingOption;
        cost = UNIT_PRICE * Integer.parseInt(quantity);
        if(!this.heatingOption.equals("Don't Heat") && !this.heatingOption.equals("Heating Option")) cost += Double.parseDouble(quantity) * PRICE_FOR_HEATING;
    }

    /**
     * Getter method for cost
     * @return cost
     */
    public double getCost() {return cost;}

    /**
     * Getter method for quantity
     * @return quantity
     */
    public String getQuantity() {return quantity;}

    /**
     * Getter method for heatingOption
     * @return heatingOption
     */
    public String getHeatingOption() {return heatingOption;}

    /**
     * Getter method for PastryOptions
     * @return PastryOptions
     */
    public static String[] getPastryOptions() {return PastryOptions;}

    /**
     * Getter method for QuantityOptions
     * @return QuantityOptions
     */
    public static String[] getQuantityOptions() {return QuantityOptions;}

    /**
     * Getter method for HeatingOptions
     * @return HeatingOptions
     */
    public static String[] getHeatingOptions() {return HeatingOptions;}

    /**
     * compareTo method
     * @param dessert
     * @return if this is larger, 1; if not, -1; if equal, 0
     */
    public int compareTo(DessertItem dessert) {
        if(getCost() > dessert.getCost()) return 1;
        else if(getCost() == dessert.getCost()) return 0;
        else return -1;
    }

    /**
     * toString method
     * @return DessertName\n Price\n Quantity \n Heating Method
     */
    public String toString() {
        return super.toString() + "Quantity: " + getQuantity() + "\nHeating Method: " + getHeatingOption() + "\n\n";
    }
}
