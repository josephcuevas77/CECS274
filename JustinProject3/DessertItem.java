package JustinProject3;

/**
 * DESSERTITEM CLASS
 * Abstract class for Dessert Items
 * Has a dessertName and getCost method
 * @author Justin Mabutas 2/21/2019
 */
public abstract class DessertItem {
    private String dessertName;

    /**
     * Abstract method getCost
     * @return cost: of item
     */
    public abstract double getCost();

    /**
     * Default Constructor
     * @param n
     */
    public DessertItem(String n) {
        dessertName = n;
    }

    /**
     * Getter method for name
     * @return dessertName
     */
    public String getName() {
        return dessertName;
    }

    /**
     * Setter method for name
     * @param n
     */
    public void setName(String n) {
        dessertName = n;
    }

    /**
     * toString method
     * @return String: Dessert name\nPrice\n
     */
    public String toString() {
        return String.format("Dessert: %s             \nPrice: $%.2f          \n", dessertName, getCost());
    }
}
