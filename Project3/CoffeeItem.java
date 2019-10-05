package Project3;

/**
 * Creates the coffee item with parameters/variables to be set 
 * @author Joseph
 * @since 3/19/19
 *
 */
public class CoffeeItem extends DrinkItem {

	
	private String size;
	private String flavor;
	private String sweetness;
	private String milk;
	private String temperature;
	private String specialInstructions;
	
	/**
	 * Default constructor for Coffee Item
	 */
	public CoffeeItem() {
		size = "N/A";
		flavor = "N/A";
		sweetness = "N/A";
		milk = "N/A";
		temperature = "N/A";
		specialInstructions = "N/A";
	}
	
	/**
	 * Overloaded Constructor for Coffee Item
	 * @param size of Coffee
	 * @param flavor of Coffee
	 * @param sweetness of Coffee
	 * @param milk of Coffee
	 * @param temp of Coffee
	 * @param specInst - userInputted special instructions
	 */
	public CoffeeItem(String size, String flavor, String sweetness, String milk, String temp, String specInst) {
		this.size = size;
		this.flavor = flavor;
		this.sweetness = sweetness;
		this.milk = milk;
		temperature = temp;
		specialInstructions = specInst;
	}
	
	/**
	 * Calculates the cost of the Coffee Item
	 * @return cost
	 */
	public double getCost() {
		double cost = 0;
		if(milk.equals("No Milk"))cost += 0.00;
		else cost += 0.25;
		switch(size) {
			case "Small":
				switch(temperature) {
					case "Hot":
						cost += 1.00;
						break;
					case "Iced":
						cost += 1.00;
						break;
					case "Blended":
						cost += 1.25;
						break;
				}
			break;
			case "Medium":
				switch(temperature) {
					case "Hot":
						cost += 1.50;
						break;
					case "Iced":
						cost += 1.50;
						break;
					case "Blended":
						cost += 1.75;
						break;
				}
				break;
			case "Large":
				switch(temperature) {
					case "Hot":
						cost += 2.00;
						break;
					case "Iced":
						cost += 2.00;
						break;
					case "Blended":
						cost += 2.25;
						break;
				}
			break;
		}
		
		return cost;
	}
	
	/**
	 * Allows the Coffee Item to be printed as a String
	 */
	public String toString() {
		String coffeeItem;
		if(specialInstructions.equals("")) coffeeItem = "\t\t--" + flavor + " Coffee (" + size + "):\t\t " + String.format("$%.2f%n",getCost()) 
														+ "\t\t\tSweetness: " + sweetness + "\n\t\t\tMilk: " + milk + "\n\t\t\tTemp: " + temperature;
		
		else coffeeItem = "\t\t--" + flavor + " Coffee (" + size + "):\t\t " + String.format("$%.2f%n",getCost()) 
						  + "\t\t\tSweetness: " + sweetness + "\n\t\t\tMilk: " + milk + "\n\t\t\tTemp: " + temperature 
						  + "\n\t\t\tSpecial Instructions: " + specialInstructions;
		return coffeeItem;
	}
}
