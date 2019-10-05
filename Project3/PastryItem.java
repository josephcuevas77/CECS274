package Project3;

/**
 * Creates the pastry item with parameters/variables to be set 
 * @author Joseph
 * @since 3/19/19
 *
 */
public class PastryItem extends Item {

	private String flavor;
	private String name;
	private boolean isHeated;
	private static final double HEAT_PRICE = 0.50;
	
	/**
	 * Default constructor for Pastry Item
	 */
	public PastryItem() {
		name = "N/A";
		flavor = "N/A";
		isHeated = false;
	}
	
	/**
	 * Overloaded Constructor for Pastry Item
	 * @param newName - of the Pastry
	 * @param newFlavor - of the Pastry
	 * @param heated - determines if Pastry is heated or not
	 */
	public PastryItem(String newName, String newFlavor, boolean heated) {
		name = newName;
		flavor = newFlavor;
		isHeated = heated;
	}
	 
	/**
	 * Calculates the cost of the Pastry and adds .25 if heated
	 * @return the cost
	 */
	public double getCost() {
		double cost = 0;
		if(isHeated == false) {
		cost += getPrice();
		}else {
			cost += getPrice() + HEAT_PRICE;
		}
		return cost;
	}
	
	/**
	 * Gets the base price based on the name of the pastry
	 * @return the base price of the pastry
	 */
	public double getPrice() {
		double price = 0;
		switch(name) {
			case "Muffin":
				price = 2.00;
				break;
			case "Cheesecake Slice":
				switch(flavor) {
					case "Regular":
						price = 4.00;
						break;
					case "Cherry":
						price = 4.50;
						break;
					case "Blueberry":
						price = 4.50;
						break;
				}
				break;
			case "Cookie":
				price = 1.50;
				break;
			case "Danish":
				price = 2.50;
				break;
		}
		return price;
	}
	
	/**
	 * Allows the pastry item object to printed as a string
	 */
	public String toString() {
		String pastryItem;
		if(isHeated == true) pastryItem = "\t\t--" + name + " (heated)" + "\t\t" + String.format("$%.2f%n",getCost()) + "\t\t\t" + flavor + "\n";
		else {
			if(name.equalsIgnoreCase("Cheesecake Slice"))pastryItem = "\t\t--" + name + "\t\t" + String.format("$%.2f%n",getCost()) + "\t\t\t" + flavor + "\n";
			else pastryItem = "\t\t--" + name + "\t\t\t" + String.format("$%.2f%n",getCost()) + "\t\t\t" + flavor + "\n";
		}
		return pastryItem;
	}
	
	
}
