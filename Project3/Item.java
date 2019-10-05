package Project3;

/**
 * Creates the parent item with parameters/variables to be set 
 * @author Joseph
 * @since 3/19/19
 *
 */
public abstract class Item {

	private String name;
	private double cost;
	
	/**
	 * Default Constructor for item
	 */
	public Item() {
		name = "N/A";
		cost = 0;
	}
	
	/**
	 * Overloaded Constructor for Item
	 * @param newName of item
	 * @param newCost of item
	 */
	public Item(String newName, double newCost) {
		name = newName;
		cost = newCost;
	}
	
	/**
	 * sets the name of the Item
	 * @param newName of item
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	/**
	 * Sets the cost of the item
	 * @param newCost of item
	 */
	public void setCost(double newCost) {
		cost = newCost;
	}
	
	/**
	 * Retrieves the name of the item
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Abstract Class to be used across all subclass items
	 * @return null
	 */
	public abstract double getCost();
}
