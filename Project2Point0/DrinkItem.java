package Project2Point0;

/**
 * DRINKITEM CLASS
 * Abstract class for DrinkItem
 * Contains the drinkName, sweetness, and size.
 * @author Justin Mabutas 2/21/2019
 */
public abstract class DrinkItem implements Comparable<DrinkItem> {
    private String drinkName;
    private String sweetness;
    private String size;

    /**
     * Default constructor
     * @param drinkName
     * @param sweetness
     * @param size
     */
    public DrinkItem(String drinkName, String sweetness, String size) {
        this.drinkName = drinkName;
        this.sweetness = sweetness;
        this.size = size;
    }

    /**
     * Abstract getter method for cost
     * @return cost
     */
    public abstract double getCost();

    /**
     * Getter method for name
     * @return drinkName
     */
    public String getName() {return drinkName;}

    /**
     * Getter method for sweetness
     * @return sweetness
     */
    public String getSweetness() {return sweetness;}

    /**
     * Getter method for size
     * @return size
     */
    public String getSize() {return size;}

    /**
     * Setter method for name
     * @param n
     */
    public void setName(String n) {drinkName = n;}

    /**
     * Setter method for sweetness
     * @param s
     */
    public void setSweetness(String s) {sweetness = s;}

    /**
     * Setter method for size
     * @param s
     */
    public void setSize(String s) {size = s;}

    /**
     * Comparable method to compare two drinkItems
     * @param drink1
     * @param drink2
     * @return true if drink1 is more expensive, false otherwise.
     */
    public static boolean max(DrinkItem drink1, DrinkItem drink2) {
        if(drink1.getCost() > drink2.getCost()) return true;
        return false;
    }

    /**
     * toString for this class
     * @return String: Drink name\nPrice\n
     */
    public String toString() {
        return String.format("Drink: %s\nPrice: $%.2f\n", drinkName, getCost());
    }
}
