package JustinProject3;

/**
 * PASTRY CLASS
 * Pastry extends DessertItem
 * Has Unit price and price for heating which is multiplied by the quantity to get an additional cost
 * Has String[] for menu options.
 * @author Justin Mabutas 2/21/2019
 */
public class Pastry extends DessertItem {

    private final double PRICE_FOR_HEATING = 0.25;
    private double cost;
    private String flavor;
    private boolean heated;

    private static String[] PastryOptions = {"Muffin", "Cheesecake", "Cookie", "Danish"};
    private static String[][] FlavorOptions = {{"Banana Nut", "Blueberry", "Chocolate Chip", "Coffee Cake"}, {"Regular", "Cherry", "Blueberry"}, {"Oatmeal", "White Choco & Macadamias", "Chocolate Chip", "Double Fudge"}, {"Apple Cinammon", "Strawberry & Cheese", "Double Cheese"}};
    private double[] prices = {2, -1, 1.5, 2.5};


    /**
     * Overloaded Constructor
     * @param name
     */
    public Pastry(String name, String flavor, boolean heated) {
        super(name);
        this.flavor = flavor;
        this.heated = heated;
    }

    /**
     * Getter method for cost
     * @return cost
     */
    public double getCost() {
        cost = 0;
        for(int i = 0; i < PastryOptions.length; i++) {
            if(getName().equals(PastryOptions[i])) {
               if(prices[i] == -1) {
                   for(int j = 0; i < FlavorOptions.length; j++) {
                       if(flavor.equals("Regular"))
                       {
                           cost += 4.0;
                           break;
                       }
                       else if(flavor.equals("Cherry") || flavor.equals("Blueberry"))
                       {
                           cost += 4.5;
                           break;
                       }
                   }
               }
               else {
                   cost += prices[i];
                   break;
               }
            }
        }

        if(heated) cost += 0.25;
        return cost;
    }

    /**
     * Static method for getting the PastryOptions
     * @return PastryOptions
     */
    public static String[] getPastryOptions() {return PastryOptions;}
    /**
     * Static method for getting the FlavorOptions
     * @return FlavorOptions
     */
    public static String[][] getFlavorOptions() {return FlavorOptions;}

    /**
     * To String method for this class
     * @return string
     */
    public String toString() {
        return super.toString() + "Flavor: " + flavor + "\nHeated: " + heated + "\n\n";
    }
}
